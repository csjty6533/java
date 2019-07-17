package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clock.Clock;
import pc.client.ClientBackground;


public class Main extends JFrame implements ActionListener,WindowListener{
	
	public static Main frame;
	
	private JPanel contentPane;
	private JButton b1,b2,b3;
	private Clock clockLabel;
	private JPanel panel;
	private CardLayout card=new CardLayout();
	private Login login=new Login();
	private static Socket socket;
	private Clock clock;
	private static ClientBackground client = new ClientBackground();
	
	private SimpleDateFormat sdf=new SimpleDateFormat("hhmm");
	private static ArrayList<String> orderList=new ArrayList<String>();
	public static ArrayList<String> getOrderList() {
		return orderList;
	}
	public void setOrderList(ArrayList<String> orderList) {
		this.orderList = orderList;
	}
	public Main getInstance()
	{
		
		return frame;
	}
	public ClientBackground getClient()
	{
		return client;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try
				{
					frame=new Main();
					frame.setVisible(true);
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}

		});
		
	}
	
	public Main()
	{
		setTitle("PC방pos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		
        setBounds(100, 20, 1000, 695);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(204,204,204));
        panel = new JPanel();
        panel.setBounds(0, 0, 800, 675);
        
        panel.setLayout(card);
        panel.setBackground(new Color(204,204,204));
        
        //panel.add("home",home);
        //panel.add("pay",pay);
        card.show(panel, "login");
        
        b1 = new JButton("주문목록");
        b1.setBounds(822, 100, 100, 55);
        contentPane.add(setButton(b1));
        
        b2 = new JButton("좌석");
        b2.setBounds(822, 200, 100, 55);
        contentPane.add(setButton(b2));
        
        b3 = new JButton("상품주문");
        b3.setBounds(822, 300, 100, 55);
        contentPane.add(setButton(b3));
        
        clock=new Clock();
        clock.setBounds(810,550,170,150);
        clock.setOpaque(false);
        Thread th=new Thread(clock);
        th.start();
        contentPane.add(clock);
        
        contentPane.add(panel);
        login.setOpaque(false);
        
        //client.setGui(this);
        panel.add("login",login);
        card.show(panel,"login");
        
		
        
	}

	 


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
        if(ob == b1) {
        	
        	card.show(panel, "order");
        	login.orderSetting();
            setTitle("주문목록");
        }
        else if(ob == b2) {
            card.show(panel, "home");
            setTitle("좌석");
        }
        else if(ob == b3) {
            card.show(panel, "pay");
            setTitle("상품주문");
        }
        //else if(ob==JFrame.EXIT_ON_CLOSE)
	
	}
	public JButton setButton(JButton a)
	{
		a.setBackground(new Color(36,205,198));
		a.setForeground(Color.white);
		a.setFont(new Font("FixedSys",Font.BOLD,15));
		a.addActionListener(this);
		return a;
	}
	public CardLayout getCard()
	{
		return card;
	}
	public JPanel getPanel()
	{
		return panel;
	}
	public Login getLogin()
	{
		return login;
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		try { 
			client.exit();
		  System.out.println("exit"); 
		  } catch (Exception e1) {
			  e1.printStackTrace(); 
		  } 
		System.exit(0);
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}