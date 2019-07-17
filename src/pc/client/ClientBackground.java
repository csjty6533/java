package pc.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

import view.Main;
 
public class ClientBackground {
 
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Main gui;
    private String msg;
    private int nickName;
	private String startTime;
	
	
 
	/*
	 * public final void setGui(Main gui) { this.gui = gui; }
	 */
 
    public void connet() {
        try {
            socket = new Socket("192.168.0.71", 7777);
            System.out.println("서버 연결됨.");
             
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
             
            //접속하자마자 닉네임 전송하면. 서버가 이걸 닉네임으로 인식을 하고서 맵에 집어넣겠지요?
            out.write(nickName); 
            System.out.println("클라이언트 : 메시지 전송완료"+nickName);
            
            out.writeUTF(startTime); 
            System.out.println("클라이언트 : 메시지 전송완료"+startTime);
			
			/*
			 * while(in!=null) { gui.setTitle(in.readUTF()); }
			 */
			 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        ClientBackground clientBackground = new ClientBackground();
        clientBackground.connet();
    }
 
    public void sendMessage(String msg2) {
        try {
            out.writeUTF(msg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void setNickname(int nickName) {
        this.nickName = nickName;
    }

	public void setStartTime(String startTime) {
		// TODO Auto-generated method stub
		this.startTime=startTime;
	}
	public void setPay(String payList) throws Exception{
		out.writeUTF("order"+payList);
		//gui.orderSetting(nickName);
	}
	public void exit() throws IOException
	{
		out.writeUTF("exit");
	}
}