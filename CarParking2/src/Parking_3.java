import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_3 extends JFrame
{
	//ADD
	Parking_3(int a1,int a2,int a3,int a4,ParkingLot a5)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PARKINGLOT");
		setContentPane(new Page3());
		
		setSize(800,600);setVisible(true);
	}
	private class Page3 extends Panel
	{
		Page3()
		{
			setLayout(null);
			Title p1=new Title();
			p1.setBounds(150,30,500,50);
			
			Data p2=new Data();
			p2.setBounds(120,130,500,300);
			
			Submit p3=new Submit();
			p3.setBounds(370,480,85,40);
			
			add(p1);add(p2);add(p3);
			setBackground(Color.gray);
			setSize(1000,700);
		}
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
			GridLayout gl=new GridLayout(3,4); gl.setVgap(80);gl.setHgap(10);
			setLayout(gl);
			
			String labeldata[]= {"Name","Tel-1","Identify-N","Tel-2","Address","E-mail"};
			JLabel la[]=new JLabel[6];
			
			JTextField text[]=new JTextField[6];
			for(int i=0;i<la.length;i++)
			{
				la[i]=new JLabel(labeldata[i]);
				la[i].setFont(new Font("Verdana",Font.PLAIN,18));
				add(la[i]);
				
				text[i]=new JTextField(15);
				add(text[i]);
			}
			
		}
	}
	private class Submit extends Panel
	{
		Submit()
		{
			setLayout(new FlowLayout());
			JButton b=new JButton("submit");
			add(b);
		}
	}
}