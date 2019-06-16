package cardlayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Ex01 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame();
		CardLayout card=new CardLayout(10,10);
		f.setSize(300,200);
		
		Panel c1=new Panel();
		c1.setBackground(Color.yellow);
		Panel c2=new Panel();
		c2.setBackground(Color.red);
		Panel c3=new Panel();
		c3.setBackground(Color.black);
		f.add(c1,"1");
		f.add(c2,"2");
		f.add(c3,"3");
		
		class handler extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				card.show(f,"3");
			}
		}
		c1.addMouseListener(new handler());
		c2.addMouseListener(new handler());
		c3.addMouseListener(new handler());
		f.setLocation(300,200);
		f.setVisible(true);
		card.show(f,"1");
		
	}

	
}
