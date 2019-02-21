import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ex02 extends JFrame{
	private JComboBox<String> combo[];
	private int price=0;
	private int index1,index2,index3;
	private JLabel result;
	private boolean tag=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex02();
	}
	Ex02()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Do you want something for dinner?");
		add(new Page1());
		setSize(780,450);setVisible(true);
	}
	private class Page1 extends Panel
	{
		Page1()
		{
			setLayout(null);
			Input1 p1=new Input1();
			p1.setBounds(50,50,500,220);
			add(p1);
			
			Output p2=new Output();
			p2.setBounds(580,50,150,200);
			p2.setBackground(Color.white);
			add(p2);
			
			Pricetag p3=new Pricetag();
			p3.setBounds(300,270,450,130);
			add(p3);
			setSize(780,450);
		}
	}
	private class Input1 extends JPanel
	{
		Input1()
		{
			setLayout(null);
			JLabel title=new JLabel("SchoolFood is Best");
			title.setBounds(10,10,120,20);
			title.setOpaque(true);
			add(title);
			
			String a[]= {"rice","noodle","count","3500","4000","3000","2000","1500"};
			JLabel la[]=new JLabel[3];
			for(int i=0;i<la.length;i++)
				{
				la[i]=new JLabel(a[i]);
				add(la[i]);
				}
			la[0].setBounds(40,40,40,20);
			la[1].setBounds(40,90,40,20);
			la[2].setBounds(240,40,40,20);
			
			String b[]= {"choose","Gochidon","Jeyoukbokkem","chickenmoyo"};
			String c[]= {"choose","noodle"};
			String d[]= {"1person","2person","3person","4person"};
			
			combo=new JComboBox[3];
			combo[0]=new JComboBox<String>(b);
			combo[1]=new JComboBox<String>(c);
			combo[2]=new JComboBox<String>(d);
			
			combo[0].addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					index1=((JComboBox<String>)e.getSource()).getSelectedIndex();	
				}
			});
			combo[1].addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					index2=((JComboBox<String>)e.getSource()).getSelectedIndex();	
				}
			});
			combo[2].addItemListener(new ItemListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				index3=((JComboBox<String>)e.getSource()).getSelectedIndex();	
			}
			});
			
			combo[0].setBounds(90,40,100,20);
			combo[1].setBounds(90,90,100,20);
			combo[2].setBounds(290,40,100,20);
			
			add(combo[0]);
			add(combo[1]);
			add(combo[2]);
			
			
			JCheckBox check=new JCheckBox("Strawberry yogurt");
			check.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange()==ItemEvent.SELECTED)price+=1500;
					if(e.getStateChange()==ItemEvent.DESELECTED)price-=1500;
				}
			});
			check.setBounds(70,130,200,20);
			add(check);
		}
		public void paintComponent(Graphics g) 
		{ 
		   super.paintComponent(g);
		   g.drawRect(10, 20, 470, 180);
		 }
	}
	private class Output extends Panel
	{
		Output()
		{
			setLayout(new FlowLayout());
			result=new JLabel("sumary");
			add(result);
		}
	}
	private class Pricetag extends JPanel
	{
		Pricetag()
		{
			setLayout(null);
			JLabel title=new JLabel("receipt");
			title.setBounds(10,0,50,20);
			title.setOpaque(true);
			add(title);
			
			JRadioButton r[]=new JRadioButton[2];
			ButtonGroup bg=new ButtonGroup();
			r[0]=new JRadioButton("Without PriceTag",true);
			r[1]=new JRadioButton("Inculde PriceTag");
			for(int i=0;i<r.length;i++)
			{
				r[i].addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange()==ItemEvent.DESELECTED)return;
						if(r[0].isSelected())tag=false;
						else tag=true;
					}
				});
				bg.add(r[i]);
				r[i].setBounds(20,30+i*20,150,20);
				add(r[i]);
			}
			
			JButton submit=new JButton("Calculation");
			submit.setBounds(280,10,150,30);
			submit.addActionListener(new ActionListener() {
				
				private int getprice;
				public void actionPerformed(ActionEvent e) {
					int rice[]= {0,3500,4000,3000};
					int noodle[]={0,2000};
					int count[]={1,2,3,4};
					getprice=price+rice[index1]*count[index3]+noodle[index2];
					if(tag) result.setText((getprice*1.1)+"");
					else result.setText(getprice+"");
				}
			});
			add(submit);
			setSize(300,450);
		}
		public void paintComponent(Graphics g) 
		{ 
		   super.paintComponent(g);
		   g.drawRect(0, 10, 225, 80);
		}
	}
}
