import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.awt.Graphics;
import javax.imageio.*;
import java.util.*;
public class CarParking extends JFrame{
	private Container ctn;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CarParking();
	}
	public CarParking()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new TimePanel());
		setSize(1000,700);setVisible(true);
	}
	private class TimePanel extends Panel
	{
		TimePanel()
		{
			
			setLayout(null);
			BufferedImage img=new BufferedImage(1000,700,BufferedImage.TYPE_INT_RGB);
			Graphics g2=img.getGraphics();
			JPanel p=new JPanel() {
				public void paintComponent(Graphics g)
				{
					g.drawImage(img,0,0,null);
				}
			};
			JLabel title=new JLabel("PARKING SYSTEM");
		
			title.setFont(new Font("Arial",Font.PLAIN,30));
			title.setLocation(250,50);
			title.setSize(500,60);
			title.setBackground(Color.pink);
			title.setOpaque(true);
			p1 p1=new p1();
			p1.setLocation(310,200);
			add(p1);add(title);
		}
		private class p1 extends Panel
		{
			p1()
			{
				setLayout(null);
				setBackground(Color.white);
				JLabel la[]=new JLabel[3];
				JComboBox<String> date[]=new JComboBox[3];
				la[0]=new JLabel("date");
				la[1]=new JLabel("time");
				la[2]=new JLabel("hour");
				date[0]=new JComboBox<String>();
				date[1]=new JComboBox<String>();
				date[2]=new JComboBox<String>();
				
				Month m=new Month();
				date[0]=new JComboBox<String>(m.getDate());
				date[1]=new JComboBox<String>(m.getTime());
				date[2]=new JComboBox<String>(m.getHour());
				for(int i=0;i<3;i++)
				{
					la[i].setLocation(50, 50+i*70);
					la[i].setSize(110,50);
					la[i].setFont(new Font("Arial",Font.PLAIN,20));
					la[i].setOpaque(true);
					add(la[i]);
			
					date[i].setLocation(200,50+i*70);
					date[i].setSize(110,50);
					date[i].setOpaque(true);

					add(date[i]);
				}
				
				JButton b1=new JButton("ADD");
				b1.setLocation(180,300);
				b1.setOpaque(true);
				b1.setSize(100,50);
				JButton b2=new JButton("CANCEL");
				b2.setLocation(70,300);
				b2.setOpaque(true);
				b2.setSize(100,50);
				event_1 e=new event_1();
				b1.addActionListener(e);
				b2.addActionListener(e);
				add(b1);add(b2);
				setSize(380,400);
			}

		}
		
	}
	class event_1 implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
		
	}
}
