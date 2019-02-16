import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
			setBackground(Color.pink);
			JLabel title=new JLabel("PARKING LOT");
			title.setFont(new Font("Arial",Font.PLAIN,30));
			title.setLocation(200,50);
			title.setSize(500,60);
			title.setBackground(Color.pink);
			title.setOpaque(true);
			p1 p1=new p1();
			p1.setLocation(200,200);
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
				
				JButton b1=new JButton("ют╥б");
				b1.setLocation(160,300);
				b1.setOpaque(true);
				b1.setSize(100,50);
				b1.addActionListener(new event_1());
				add(b1);
				setSize(400,400);
			}

		}
		
	}
	
}
