import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_1 extends JFrame{
	private JButton getdate;
	private int index1,index2;
	private JLabel error;
	
	public static void main(String[] args) {
		new Parking_1();
	}
	public Parking_1()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PARKINGLOT");
		add(new Page1());
		setSize(800,600);setVisible(true);
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
						getdate=(JButton)e.getSource();
						for(int i=0;i<31;i++)calendarbutton[i].setBackground(Color.white);
						getdate.setBackground(Color.green);
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
					
					index1=((JComboBox<String>)e.getSource()).getSelectedIndex();	
				}
			});
			timeCombo[1].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					index2=((JComboBox<String>)e.getSource()).getSelectedIndex();	
				}
			});
			
			JButton add=new JButton("ADD");
			add.setBounds(130,200,90,30);
			add(add);
			add.addActionListener(new goPage2());
			
			JButton cancel=new JButton("CANCEL");
			cancel.setBounds(20,200,90,30);
			add(cancel);
			
			error=new JLabel("9:00~21:00 USE");
			error.setForeground(Color.red);
			error.setBounds(20,240,100,20);
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
			if(index1+index2>12)error.setVisible(true);
			else
			{
				int x=Integer.parseInt(getdate.getText().toString());
				System.out.println(x+" "+index1+" "+index2);
			}
		}	
	}
}