import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_3 extends JFrame
{
	private JFrame f;
	private ParkingLot person;
	private int index1,index2,index3,index4;
	
	private JTextField text[];
	private boolean key;
	private String id[];
	
	//ADD
	Parking_3(int a1,int a2,int a3,int a4,ParkingLot a5)
	{
		key=true;
		person=a5;
		index1=a1;
		index2=a2;
		index3=a3;
		index4=a4;
		
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("PARKINGLOT");
		f.add(new Page3());
		f.setSize(800,600);
		f.setVisible(true);
	}
	//CANCEL
	Parking_3(int a1,int a2,int a3,ParkingLot a4)
	{
		key=false;
		person=a4;
		index1=a1;
		index2=a2;
		index3=a3;
		
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("PARKINGLOT");
		f.setContentPane(new Page3());
		f.setSize(800,600);
		f.setVisible(true);
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
			
			text=new JTextField[6];
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
			b.addActionListener(new goNext());
			add(b);
		}
	}
	private class goNext implements ActionListener
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
				{   //add >goParking1
					if(key)
					{	
						person.setSlot(index1,index2,index3,index4,id);
						new Parking_1(person);
						f.dispose();
					}
					//cancel >goParking2
					else
					{
						int k=person.getCancel(index1, index2, index3, id);
						if(person.getCancelSlot(index1,index2,index3,id,k))
						{
							new Parking_2(index1,index2,index3,person,id);
							f.dispose();
						}
					}
				}
			}
		}
		
	}
}