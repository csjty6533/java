import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.Toolkit; 
public class Parking_2 extends JFrame
{
	private JButton slot[];
	
	//add
	public Parking_2() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PARKINGLOT");
		add(new Page2());
		setSize(800,600);setVisible(true);
	}
	
	private class Page2 extends Panel
	{
		//add
		Page2()
		{
			setLayout(null);
			
			Parking p1=new Parking();
			p1.setLocation(40,30);
			
			JButton b=new JButton("add");
			b.setFont(new Font("Arial",Font.PLAIN,18));
			b.setBounds(695,470,70,40);
			
			add(p1);add(b);
			setSize(800,600);
		}
	}
	private class Parking extends JPanel
	{
		public void paintComponent(Graphics g) 
		{ 
		    Toolkit tk = Toolkit.getDefaultToolkit(); 
		    Image img = tk.getImage("img/parking.png"); 
		    g.drawImage(img, 0, 0,650,480, this); 
		}
		//add
		Parking()
		{
			setLayout(null);
			JButton slot[]=new JButton[15];
		
			for(int i=0;i<slot.length;i++)
			{
				slot[i]=new JButton("S"+(i+1));
				slot[i].setOpaque(true);
				add(slot[i]);
			}
			for(int i=0;i<9;i++)slot[i].setBounds(12+i*71,40,60,110);
			
			for(int i=9;i<12;i++)slot[i].setBounds(500,260+(i-9)*71,110,60);

			for(int i=12;i<15;i++)slot[i].setBounds(35,400-(i-12)*71,110,60);	
			
	
			setOpaque(false);
			setSize(680,500);
		}
	
	}
	
	
	
}