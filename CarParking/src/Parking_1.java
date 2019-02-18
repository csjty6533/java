import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_1 extends JFrame{
	private JButton calendarbutton[];
	private JButton getdate;
	private int index1,index2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Parking_1();
	}
	public Parking_1()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Container());
		add(new Page1(),BorderLayout.CENTER);
		getMenu();
		setSize(1000,700);setVisible(true);
	}
	private void getMenu()
	{
		JMenuBar bar=new JMenuBar();
		JMenu menu=new JMenu("µÚ·Î");
		menu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
	
			}
		});
		bar.add(menu);
		setJMenuBar(bar);
	}
	private class Page1 extends Panel
	{
		Page1()
		{
			setLayout(null);
			setBackground(Color.gray);
			
			Title p1=new Title();
			p1.setBounds(150,50,650,110);
			
			Calendar p2=new Calendar();
			p2.setBounds(100,200,470,250);
			Date p3=new Date();
			p3.setLocation(600,200);
			p3.setBackground(Color.white);
			add(p1);add(p2);add(p3);
			setSize(1000,700);
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
			GridLayout gl=new GridLayout(5,7);
			setLayout(gl);
			JLabel la=new JLabel(" Jan");la.setFont(new Font("Verdana",Font.PLAIN,24));
			add(la);
			add(new JLabel(""));
			calendarbutton=new JButton[31];
			for(int i=0;i<31;i++)
			{
				calendarbutton[i]=new JButton((i+1)+"");
				calendarbutton[i].setBackground(Color.white);
				calendarbutton[i].addActionListener(new event());
				add(calendarbutton[i]);
			}
		}
	} 
	private class event implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			getdate=(JButton)e.getSource();
			for(int i=0;i<31;i++)calendarbutton[i].setBackground(Color.white);
			getdate.setBackground(Color.green);
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
			
			timeCombo[0].setLocation(20,30);
			timeCombo[1].setLocation(20,100);
			
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
			for(int i=0;i<2;i++)
			{
				timeCombo[i].setSize(200,30);
				timeCombo[i].setOpaque(true);
				add(timeCombo[i]);
			}
			JButton add=new JButton("ADD");
			add.setLocation(130,200);
			add.setSize(90,30);
			add.addActionListener(new goPage2());
			add(add);
			
			JButton cancel=new JButton("CANCEL");
			cancel.setLocation(20,200);
			cancel.setSize(90,30);
			cancel.addActionListener(new goPage3());
			add(cancel);
			setSize(250,300);
		}
	}
	private class goPage2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			int x=Integer.parseInt(getdate.getText().toString());
			new Parking_2(x,index1,index2);
			System.out.println(x+""+index1+""+index2);
		}
	}
	private class goPage3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			new Parking_3();
		}
		
	}
}
