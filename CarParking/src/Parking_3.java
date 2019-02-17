import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_3 extends JFrame
{
	Parking_3()
	{
		
	}
	Parking_3(int a1,int a2,int a3,int a4)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Container());
		setLayout(null);
		Title p1=new Title();
		p1.setLocation(200,80);
		p1.setSize(560,50);
		Data p2=new Data();
		p2.setLocation(220,160);
		Submit p3=new Submit();
		p3.setLocation(420,500);
		add(p1);add(p2);add(p3);
		setBackground(Color.gray);
		setSize(1000,700);setVisible(true);
	}
	private class Title extends Panel
	{
		Title()
		{
			setLayout(new FlowLayout());
			JLabel title=new JLabel("INFORMATION");
			title.setFont(new Font("Arial",Font.PLAIN,30));
			add(title);
		}		
	}
	private class Data extends Panel
	{
		Data()
		{
			GridLayout gl=new GridLayout(3,4);
			gl.setVgap(80);gl.setHgap(10);
			setLayout(gl);
			JLabel la[]=new JLabel[6];
			la[0]=new JLabel("Name");
			la[1]=new JLabel("Tel-1");
			la[2]=new JLabel("Identify-number");
			la[3]=new JLabel("Tel-2");
			la[4]=new JLabel("Adress");
			la[5]=new JLabel("E-mail");
			JTextField text[]=new JTextField[6];
			for(int i=0;i<la.length;i++)
			{
				la[i].setFont(new Font("Arial",Font.PLAIN,18));
				add(la[i]);
				text[i]=new JTextField(15);
				add(text[i]);
			}
			setSize(500,300);
		}
	}
	private class Submit extends Panel
	{
		Submit()
		{
			setLayout(new FlowLayout());
			JButton b=new JButton("submit");
			setSize(85,40);
			add(b);
		}
	}
}
