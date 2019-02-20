import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_1 extends JFrame{
	
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
			
			JButton add=new JButton("ADD");
			add.setBounds(130,200,90,30);
			add(add);
			
			JButton cancel=new JButton("CANCEL");
			cancel.setBounds(20,200,90,30);
			add(cancel);
			
			setSize(250,300);
		}
	}

}