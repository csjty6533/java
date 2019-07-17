package pc.server;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class ServerMain extends JFrame implements ActionListener,Runnable{
	private static JButton btn[][];
	//private static Main frame=new Main();
	private JPanel contentPane;
	private JPanel panel;
	private ServerHome serverHome;
	private ServerOrder serverOrder;
	private ArrayList<String> others;
	private SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
	private CardLayout card=new CardLayout();
	private ServerBackground server = new ServerBackground();
	private static Map<Integer, DataOutputStream> clientsMap = new HashMap<Integer, DataOutputStream>();
	private static Map<Integer, String> clientsTime = new HashMap<Integer, String>();
	private JButton b1,b2;
	
	public ServerMain () throws IOException
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 20, 1000, 695);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        panel=new JPanel();
        panel.setLayout(card);
        panel.setBackground(new Color(204,204,204));
        panel.setBounds(0, 0, 800, 675);
		
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(204,204,204));
        contentPane.add(panel);
        
        serverHome=new ServerHome();
        serverHome.setOpaque(false);
        panel.add("home",serverHome);
        card.show(panel, "home");
        
        serverOrder=new ServerOrder();
        serverOrder.setOpaque(false);
        panel.add("order",serverOrder);
        
        b1 = new JButton("주문목록");
        b1.setBounds(822, 100, 100, 55);
        contentPane.add(setButton(b1));
        
        b2 = new JButton("좌석");
        b2.setBounds(822, 200, 100, 55);
        contentPane.add(setButton(b2));
		
		setVisible(true);
		server.setGui(this);
		System.out.println("gui");
		server.setting();
		System.out.println("setting");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
        if(ob == b1) {
        	card.show(panel, "order");
            setTitle("주문목록");
        }
        else if(ob == b2) {
            card.show(panel, "home");
            setTitle("좌석");
        }
		
	}
	public void clientSetting()
	{
		serverHome.clientSetting();
	}
	public void orderSetting()
	{
		serverOrder.orderSetting();
	}
	public JButton setButton(JButton a)
	{
		a.setBackground(new Color(36,205,198));
		a.setForeground(Color.white);
		a.setFont(new Font("FixedSys",Font.BOLD,15));
		a.addActionListener(this);
		return a;
	}
	public ServerMain getInstance() {return this;}
	@Override
	public void run() {
		
		
	}
	public static void main(String[] args) throws IOException {
        ServerMain serverHome=new ServerMain();
        
    }
	public void timerStart(int nick,String msg) {
		serverHome.timerStart(nick,msg);
		
	}
}
