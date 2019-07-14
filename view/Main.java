package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clock.Clock;





public class Main extends JFrame implements ActionListener{
	public static Main frame;
	private JPanel contentPane;
	private JButton b1,b2,b3;
	private JPanel panel;
	private CardLayout card=new CardLayout();
	private Clock clock;
	private Login login=new Login();
	//private ClientBackground client = new ClientBackground();
	//private static String nickName;
	public Main getInstance()
	{
		return frame;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.print("당신의 닉네임부터 설정하세요 : ");
		 */
        //nickName = scanner.nextLine();
        //scanner.close();        

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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        panel.add("login",login);
        //panel.add("home",home);
        //panel.add("pay",pay);
        card.show(panel, "login");
        
        b1 = new JButton("주문목록");
        b1.setBounds(822, 100, 100, 55);
        b1.setBackground(new Color(36,205,198));
        b1.setForeground(Color.black);
        contentPane.add(b1);
        
        b2 = new JButton("좌석");
        b2.setBounds(822, 200, 100, 55);
        b2.setBackground(new Color(36,205,198));
        b2.setForeground(Color.black);
        contentPane.add(b2);
        
        b3 = new JButton("상품주문");
        b3.setBounds(822, 300, 100, 55);
        b3.setBackground(new Color(36,205,198));
        b3.setForeground(Color.black);
        contentPane.add(b3);
        
        clock=new Clock();
        clock.setBounds(810,550,170,150);
        clock.setOpaque(false);
        Thread th=new Thread(clock);
        th.start();
        contentPane.add(clock);
        
        b1.addActionListener(this);
        
        b2.addActionListener(this);
        b3.addActionListener(this);
        contentPane.add(panel);
        
        login.setOpaque(false);
        
		/*
		 * client.setGui(this); client.setNickname(nickName); client.connet();
		 */
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  Object ob = e.getSource();
	        if(ob == b1) {
	            card.show(panel, "order");
	            Object data[]= {"111","222",333,"444"};
	            login.getOrder().getTable().addRow(data);
	            frame.setTitle("주문목록");
	        }
	        else if(ob == b2) {
	            card.show(panel, "home");
	            
	            frame.setTitle("좌석배치");
	        }
	        else if(ob == b3) {
	            card.show(panel, "pay");
	            frame.setTitle("상품주문");
	        }
	
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
}
