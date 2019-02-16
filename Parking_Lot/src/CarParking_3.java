import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CarParking_3 extends JFrame{

	public CarParking_3()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Information());
		setSize(1000,700);setVisible(true);
	}
	private class Information extends Panel
	{
		Information()
		{
			setLayout(null);
			setBackground(Color.pink);
			all all=new all();
			all.setLocation(200,120);
			add(all);
		}
	}
	private class all extends Panel
	{
		all()
		{	
			setLayout(null);
			setBackground(Color.gray);
			p4 p4=new p4();
			p4.setLocation(50,90);
			add(p4);
			JLabel title =new JLabel("Information");
			title.setLocation(240,20);
			title.setSize(200,60);
			title.setFont(new Font("Arial",Font.PLAIN,30));
			title.setOpaque(true);
			title.setBackground(Color.white);
			add(title);
			JButton b=new JButton("Submit");
			b.setFont(new Font("Arial",Font.PLAIN,20));
			b.setLocation(250,400);
			b.setSize(100,30);
			b.addActionListener(new event_3());
			add(b);
			setSize(600,500);
		}
	}
	private class p4 extends Panel
	{
		p4()
		{
			GridLayout gl=new GridLayout(3,4);
			gl.setVgap(65);gl.setHgap(10);
			setLayout(gl);
			setBackground(Color.white);
			JLabel la[]=new JLabel[6];
			la[0]=new JLabel("name");
			la[1]=new JLabel("tel-1");
			la[2]=new JLabel("Identify-N");
			la[3]=new JLabel("tel-2");
			la[4]=new JLabel("Adress");
			la[5]=new JLabel("E-mail");
			JTextField text[]=new JTextField[6];
			for(int i=0;i<la.length;i++)
			{
				la[i].setFont(new Font("Arial",Font.PLAIN,20));
				add(la[i]);
				text[i]=new JTextField(15);
				add(text[i]);
			}
			setSize(500,300);
		}
	}
}
