package pc.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Character.Subset;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dao.OrderDao;
import dto.OrderDto;
 
public class ServerBackground {
 
    // 지금까지 한일. GUi연동시키면서 서버Gui에 메시지띄움.
    // 다음 이슈. Gui 상에서 일단 1:1 채팅을 하고 싶다.
    private ServerSocket serverSocket;
    private Socket socket;
    private ServerMain gui;
    private String msg;
    
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmm");
    private OrderDao orderDao=new OrderDao();
    /** XXX 03. 세번째 중요한것. 사용자들의 정보를 저장하는 맵입니다. */
    private static Map<Integer, DataOutputStream> clientsMap = new HashMap<Integer, DataOutputStream>();
    private static Map<Integer, String> clientsTime = new HashMap<Integer, String>();
    private static Map<Integer, OrderDto> clientsOrder = new HashMap<Integer, OrderDto>();
    
    public final void setGui(ServerMain gui) {
        this.gui = gui;
    }
    
    public static Map<Integer, DataOutputStream> getClientsMap() {
		return clientsMap;
	}

	public static void setClientsMap(Map<Integer, DataOutputStream> clientsMap) {
		ServerBackground.clientsMap = clientsMap;
	}

	public void setting() throws IOException {
            Collections.synchronizedMap(clientsMap); // 이걸 교통정리 해줍니다^^
            serverSocket = new ServerSocket(7777);
            while (true) {
                /** XXX 01. 첫번째. 서버가 할일 분담. 계속 접속받는것. */
                System.out.println("서버 대기중...");
                socket = serverSocket.accept(); // 먼저 서버가 할일은 계속 반복해서 사용자를 받는다.
                System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
                // 여기서 새로운 사용자 쓰레드 클래스 생성해서 소켓정보를 넣어줘야겠죠?!
                
			    Receiver receiver = new Receiver(socket); 
			    receiver.start();

            }
    }
 
    public static void main(String[] args) throws IOException {
        ServerBackground serverBackground = new ServerBackground();
        serverBackground.setting();
    }
 
    // 맵의내용(클라이언트) 저장과 삭제
    public void addClient(int nick, DataOutputStream out) throws IOException {
        sendMessage(nick + "님이 접속하셨습니다.");
        clientsMap.put(nick, out);
    }
 
    public void removeClient(int nick) {

        clientsMap.remove(nick);
        gui.clientSetting();
        removeClientTime(nick);
    }
    
   // 맵의내용(클라이언트) 저장과 삭제
    public void addClientTime(int nick, String startTime) throws IOException {
        clientsTime.put(nick, startTime);
    }
 
    public void removeClientTime(int nick) {
        clientsTime.remove(nick);  
    }
    
    // 메시지 내용 전파
    public void sendMessage(String msg) {
        Iterator<Integer> it = clientsMap.keySet().iterator();
        int key;
        while (it.hasNext()) {
            key = it.next();
            try {
                clientsMap.get(key).writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    // -----------------------------------------------------------------------------
    class Receiver extends Thread {
        private DataInputStream in;
        private DataOutputStream out;
        private int nick;
        private String startTime;
 
        /** XXX 2. 리시버가 한일은 자기 혼자서 네트워크 처리 계속..듣기.. 처리해주는 것. */
        public Receiver(Socket socket) throws IOException {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            nick = in.read();
            addClient(nick, out);
            
            startTime=in.readUTF();
            addClientTime(nick, startTime);
            gui.clientSetting();
            
            //start();
        }
 
        public void run() {
            try {// 계속 듣기만!!
            	System.out.println("next");
                while (in != null) {
                    msg = in.readUTF();
                    sendMessage(msg);
                    
                    if(msg.charAt(0)=='o')
                    {
                    	OrderDto orderDto=new OrderDto();
                    	orderDto.setSeat_code(nick);
                    	orderDto.setProduct_code(msg.substring(5));
                    	orderDto.setOrder_code(sdf.format(new Date())+nick);
                    	orderDao.insert(orderDto);
                    	gui.orderSetting();
                    	//gui.clientSetting();
                    }
                    else if(msg.equals("exit"))removeClient(nick);
                    else if(msg.charAt(1)=='h')gui.timerStart(nick,msg);
                    
                    
                    
                }
            } catch (IOException e) {
                // 사용접속종료시 여기서 에러 발생. 그럼나간거에요.. 여기서 리무브 클라이언트 처리 해줍니다.
                removeClient(nick);
            }
        }
    }
  
	public static Map<Integer, String> getClientsTime() {
		// TODO Auto-generated method stub
		return clientsTime;
	}
}
