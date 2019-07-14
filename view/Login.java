package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel implements ActionListener{
	private JTextField code;
	private JButton b1;
	private static Main frame=new Main();
	private static Pay pay;
	private static Home home;
	private static Order order;
	
	Login()
	{
		setLayout(null);
		//setBackground(new Color(000,051,102));
		JLabel la_code=new JLabel("CODE");
		add(la_code);
		//la_code.setBackground(Color.white);
		//la_code.setOpaque(true);
		la_code.setBounds(270,250,70,30);
		la_code.setFont(new Font("Verdana",Font.PLAIN,18));
		la_code.setForeground(Color.black);
		code=new JTextField();
		add(code);
		code.setBounds(345,250,150,30);
		
		b1=new JButton("확인");
		b1.setBounds(500,250,70,30);
		b1.setBackground(new Color(36,205,198));
        b1.setForeground(Color.black);
		b1.addActionListener(this);
		add(b1);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(frame.getInstance()==null)frame=new Main();
		else frame=frame.getInstance();
		//frame.getHome().setCode(code.getText());
		home=new Home(code.getText());
		pay=new Pay();
		order=new Order();
		home.setOpaque(false);
		pay.setOpaque(false);
		order.setOpaque(false);
		frame.getPanel().add("home",home);
        frame.getPanel().add("pay",pay);
        frame.getPanel().add("order",order);
		frame.getCard().show(frame.getPanel(), "home");
		
		
	}
	public Pay getPay()
	{
		return pay;
	}
	public Order getOrder() {return order;}
	
	
}
