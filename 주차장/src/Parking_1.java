import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_1
{
	private JFrame f;
	private ParkingLot person;
	
	private JButton index1;
	private int index2,index3;
	
	private JLabel error;
	
	public static void main(String[] args) 
	{
		ParkingLot p=new ParkingLot();
		new Parking_1(p);
	}
	public Parking_1(ParkingLot a1)
	{
		person=a1;
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("PARKINGLOT");
		f.add(new Page1());
		f.setSize(800,600);
		f.setVisible(true);
	}
	private class Page1 extends Panel
	{
		Page1()
		{
			setLayout(null);
			setBackground(Color.gray);
			
			Title p1=new Title();
			p1.setBounds(100,30,650,110);
			
			Calendar p2=new Calendar();
			p2.setBounds(30,170,340,250);
			
			Date p3=new Date();
			p3.setLocation(400,170);
			p3.setBackground(Color.white);
			
			add(p1);add(p2);add(p3);
			setSize(800,600);
		}
	}
	private class Title extends Panel
	{
		Title()
		{	
			setLayout(new FlowLayout());
			JLabel title=new JLabel("PARKING SYSTEM");
			title.setFont(new Font("Arial",Font.PLAIN,30));
			add(title);
		}
	}
	private class Calendar extends Panel
	{
		Calendar()
		{
			GridLayout gl=new GridLayout(6,7);
			setLayout(gl);
			
			JLabel la=new JLabel(" Jan");la.setFont(new Font("Verdana",Font.PLAIN,20));
			add(la);
			for(int i=0;i<8;i++)add(new JLabel());
			
			
			JButton calendarbutton[]=new JButton[31];
			for(int i=0;i<31;i++)
			{
				calendarbutton[i]=new JButton((i+1)+"");
				calendarbutton[i].setBackground(Color.white);
				calendarbutton[i].addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						index1=(JButton)e.getSource();
						for(int i=0;i<31;i++)calendarbutton[i].setBackground(Color.white);
						index1.setBackground(Color.green);
					}
				});
				add(calendarbutton[i]);
			}
		}
	} 
	
	private class Date extends Panel
	{
		Date()
		{
			
			setLayout(null);
			JComboBox<String>timeCombo[]=new JComboBox[2];
			
			String timeArr[]= new String[12];
			for(int i=0;i<timeArr.length;i++)timeArr[i]=new String((i+9)+":00");
			
			String hourArr[]=new String[6];
			for(int i=0;i<hourArr.length;i++)hourArr[i]=new String((i+1)+"hours");
			
			timeCombo[0]=new JComboBox<String>(timeArr);
			timeCombo[1]=new JComboBox<String>(hourArr);
			
			for(int i=0;i<2;i++)
			{
				timeCombo[i].setBounds(20,30+i*70,200,30);
				add(timeCombo[i]);
			}
			timeCombo[0].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					index2=((JComboBox<String>)e.getSource()).getSelectedIndex();	
				}
			});
			timeCombo[1].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					index3=((JComboBox<String>)e.getSource()).getSelectedIndex();	
				}
			});
			
			JButton add=new JButton("ADD");
			add.setBounds(130,200,90,30);
			add.addActionListener(new goPage2());
			add(add);
			
			JButton cancel=new JButton("CANCEL");
			cancel.setBounds(20,200,90,30);
			cancel.addActionListener(new goPage3());
			add(cancel);
			
			error=new JLabel("9:00~21:00 USE");
			error.setForeground(Color.red);
			error.setSize(130,20);
			error.setLocation(20,250);
			error.setOpaque(true);
			error.setVisible(false);
			add(error);
			
			setSize(250,300);
		}
	}
	private class goPage2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(index2+index3>12)error.setVisible(true);
			else
			{
				int x=Integer.parseInt(index1.getText().toString());
				new Parking_2(x,index2,index3,person);
				f.dispose();
			}
		}	
	}
	private class goPage3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(index2+index3>12)error.setVisible(true);
			else
			{
				int x=Integer.parseInt(index1.getText().toString());
				new Parking_3(x,index2,index3,person);
				f.dispose();
			}
		}
	}
}