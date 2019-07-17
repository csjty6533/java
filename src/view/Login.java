package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pc.client.ClientBackground;

public class Login extends JPanel implements ActionListener{
	
	
	private JTextField code;
	private JButton b1;
	private static Main frame=new Main();
	private static Pay pay;
	private static Home home;
	private static Order order;
	private static ClientBackground client = new ClientBackground();
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmm");
	private SimpleDateFormat datesdf=new SimpleDateFormat("hh:mm");
	Login()
	{
		
		setLayout(null);
		setBackground(new Color(051,051,051));
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
		if(frame.getClient()==null)client=new ClientBackground();
		else client=frame.getClient();
		
		//frame.getAdmin().getClient().put(Integer.parseInt(code.getText()), sdf.format(new Date()).toString());
		//frame.getHome().setCode(code.getText());
		home=new Home(code.getText());
		
		/*
		 * PayDto payDto=new PayDto(Integer.parseInt(code.getText()),(sdf.format(new
		 * Date())+code.getText()).toString(),sdf.format(new Date()).toString(),null);
		 * PayDao payDao=new PayDao();
		 * 
		 * 
		 * payDao.insert(payDto); payDao.commit();
		 */
		//Integer.parseInt(code.getText())
		home=new Home(code.getText());
		pay=new Pay();
		order=new Order(Integer.parseInt(code.getText()));
		home.setOpaque(false);
		pay.setOpaque(false);
		order.setOpaque(false);
		client.setNickname(Integer.parseInt(code.getText()));
		client.setStartTime(datesdf.format(new Date()).toString());
        client.connet(); 
		frame.getPanel().add("home",home); 
		frame.getPanel().add("pay",pay);
		frame.getPanel().add("order",order);
		frame.getCard().show(frame.getPanel(), "home");
		
	}

	public Login getInstance() {return this;}
	public Pay getPay() { return pay; }
	public Home getHome() { return home; }
	public int getCode() { return Integer.parseInt(code.getText()); }
	public Order getOrder() {return order;}
	public void orderSetting() {order.orderSetting();}
	public ClientBackground getClient() {return client;}	
		
	
	
}