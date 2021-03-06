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


public class Main extends JFrame implements ActionListener{
	public static Main frame;
	private JPanel contentPane;
	private JButton b1,b2,b3;
	private JPanel panel;
	private CardLayout card=new CardLayout();
	private Login login=new Login();
	
	public Main getInstance()
	{
		return frame;
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 20, 1000, 695);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(051,051,051));
        panel = new JPanel();
        panel.setBounds(0, 0, 800, 675);
        
        panel.setLayout(card);
        panel.add("login",login);
        //panel.add("home",home);
        //panel.add("pay",pay);
        card.show(panel, "login");
        
        b1 = new JButton("처음으로");
        b1.setBounds(822, 100, 100, 55);
        b1.setBackground(new Color(204,000,051));
        b1.setForeground(Color.white);
        contentPane.add(b1);
        
        b2 = new JButton("좌석");
        b2.setBounds(822, 200, 100, 55);
        b2.setBackground(new Color(204,000,051));
        b2.setForeground(Color.white);
        contentPane.add(b2);
        
        b3 = new JButton("상품주문");
        b3.setBounds(822, 300, 100, 55);
        b3.setBackground(new Color(204,000,051));
        b3.setForeground(Color.white);
        contentPane.add(b3);
        
        b1.addActionListener(this);
        
        b2.addActionListener(this);
        b3.addActionListener(this);
        contentPane.add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  Object ob = e.getSource();
	        if(ob == b1) {
	            card.show(panel, "login");
	        }
	        else if(ob == b2) {
	            card.show(panel, "home");
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
