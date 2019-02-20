import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_3 extends JFrame
{
	private int calendar,startT,endT,slot;
	private JTextField text[];
	private ParkingLot instance;
	private boolean key;
	private String id[];
	//ADD
	Parking_3(int a1,int a2,int a3,int a4,ParkingLot a5)
	{
		key=true;
		calendar=a1;
		startT=a2;
		endT=a3;
		slot=a4;
		instance=a5;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PARKINGLOT");
		setContentPane(new Page3());
		
		setSize(800,600);setVisible(true);
	}
	//CANCEL
	Parking_3(int a1,int a2,int a3,ParkingLot a4)
	{
		calendar=a1;
		startT=a2;
		endT=a3;
		instance=a4;
		key=false;
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
			
			JLabel la[]=new JLabel[6];
			la[0]=new JLabel("Name");
			la[1]=new JLabel("Tel-1");
			la[2]=new JLabel("Identify-N");
			la[3]=new JLabel("Tel-2");
			la[4]=new JLabel("Address");
			la[5]=new JLabel("E-mail");
			
			text=new JTextField[6];
			for(int i=0;i<la.length;i++)
			{
				la[i].setFont(new Font("Verdana",Font.PLAIN,18));
				la[i].setHorizontalAlignment(Label.RIGHT);
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
			b.addActionListener(new event());
			add(b);
		}
	}
	private class event implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			id=new String[6];
			for(int i=0;i<text.length;i++)
			{
				id[i]=new String(text[i].getText());
			}
			for(int i=0;i<id.length;i++)
			{
				if(id[i].equals(""))break;
				else
				{
					//add >goParking1
					if(key)
					{	
						instance.setSlot(calendar,startT,endT,slot,id);
						new Parking_1(instance);
					}
					//cancel >goParking2
					else
					{
						int k=instance.getCancel(calendar, startT, endT, id);
						if(instance.getCancelSlot(calendar,startT,endT,id,k))new Parking_2(calendar,startT,endT,instance,id);
					}
				}
			}
		}
		
	}
}