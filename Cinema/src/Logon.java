import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Logon extends JPanel
{
	
	Logon()
	{
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Page1());
		f.setSize(400,700);
		f.setVisible(true);
	}
	private class Page1 extends Panel
	{
		Page1()
		{
			
		}
	}
	public static void main(String[] args)
	{
		new Logon();
	}
}
class Login extends Panel
{
	private String customer[];
	Login()
	{
		setLayout(null);
		setBackground(Color.red);
		JLabel login =new JLabel("Log-in");
		login.setBounds(100,100,100,50);
		
		add(login);
		JTextField log[]=new JTextField[4];
		String arr[]= {"ID","PW","NAME","TEL"};
		JLabel log2[]=new JLabel [4];
		for(int i=0;i<4;i++)
		{
			log[i]=new JTextField();
			log2[i]=new JLabel(arr[i]);
			log[i].setBounds(250+(i%2)*100,200+(i/2)*40,30,30);
			log2[i].setBounds(200+(i%2)*100,200+(i/2)*40,30,30);
			add(log2[i]);
			add(log[i]);
		}
		JButton b=new JButton("login");
		b.setBounds(300,300,100,50);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				customer=new String[4];
				for(int i=0;i<customer.length;i++)customer[i]=log[i].getText();
				Logon l=new Logon();
			
			}
		});
		add(b);
		setSize(800,500);
	}
}