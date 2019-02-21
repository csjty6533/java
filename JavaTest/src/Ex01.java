import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ex01 extends JFrame{
	private JTextField text[];
	private JRadioButton b[];
	private JCheckBox cb[];
	private JLabel result1[],result2[];
	private String a[]= {"NAME: ","HEIGHT: ","WEIGHT: ","GENDER","WOMEN","MEN","HABIT","DRINKING","SMOKING","EXERCISE"};
	private JLabel color;
	private boolean gender,index1,index2,index3;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Ex01();
	}
	Ex01()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Container());
		setTitle("BodyMessIndex(BMI)");
		add(new Page1());
		setSize(600,500);setVisible(true);
	}
	private class Page1 extends Panel
	{
		Page1()
		{
			setLayout(null);
			Body p1=new Body();
			p1.setLocation(20,40);
			add(p1);
			
			BMI p2=new BMI();
			p2.setLocation(320,40);
			add(p2);
			
			JButton b=new JButton("Body Measure");
			b.setBounds(410,20,120,20);
			b.setOpaque(true);
			b.addActionListener(new event());
			add(b);
			
			JLabel title =new JLabel("Body Max Index");
			title.setBounds(20,20,100,20);
			title.setOpaque(true);
			add(title);
			
			setSize(600,600);
		}
	}
	private class event implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			StringBuffer sb[]=new StringBuffer[3];
			Double height=Double.parseDouble(text[1].getText());
			Double weight=Double.parseDouble(text[2].getText());
		    Double bmi=(weight/((height/100)*(height/100)));
		    float bmi2=((int)(bmi*100))/100;
		    for(int j=0;j<sb.length;j++)
			{
				sb[j]=new StringBuffer(text[j].getText());
			}
		    String aa;
			if(gender)aa="Cool ";
			else aa="Pretty ";
			result1[0].setText(aa+sb[0].toString()+"'s");
			
			if(bmi>30)result1[2].setText(bmi2+"(high fat)");
			else if(bmi>=25)result1[2].setText(bmi2+"(mid fat)");
			else if(bmi>=23)result1[2].setText(bmi2+"(over fat)");
			else if(bmi>=18.5)result1[2].setText(bmi2+"(normal)");
			else result1[2].setText(bmi2+"(low fat)");
			
			for(int i=0;i<text.length;i++)
				{
					result1[i].setVisible(true);
					if(bmi>23)color.setBackground(Color.red);
					else if(bmi>18.5)color.setBackground(Color.green);
					else color.setBackground(Color.blue);
				}
			if(index1)result2[0].setVisible(true);
			else result2[0].setVisible(false);
			if(index2)result2[1].setVisible(true);
			else result2[1].setVisible(false);
			if(index3)result2[2].setVisible(false);
			else result2[2].setVisible(true);
		}
	}
	private class Body extends JPanel
	{
		public void paintComponent(Graphics g) 
		{ 
		   super.paintComponent(g);
		   g.setColor(Color.gray);
		   g.drawRect(0, 0, 270, 350);
		   g.setColor(Color.white);
		   g.drawRect(20, 120, 200, 100);
		 }
		Body()
		{
			setLayout(null);
			
			JLabel la[]=new JLabel[3];
			for(int i=0;i<la.length;i++)
			{
				la[i]=new JLabel(a[i]);
				la[i].setLocation(10,20+i*30);
				la[i].setSize(50,20);
				la[i].setHorizontalAlignment(Label.LEFT);
				la[i].setOpaque(true);
				add(la[i]);
			}
			text=new JTextField[3];
			for(int i=0;i<text.length;i++)
			{
				text[i]=new JTextField(15);
				text[i].setLocation(70,20+i*30);
				text[i].setSize(100,20);
				text[i].setOpaque(true);
				add(text[i]);
			}
			JLabel la2[]=new JLabel[2];
			la2[0]=new JLabel("(cm)");
			la2[1]=new JLabel("(kg)");
			for(int i=0;i<la2.length;i++)
			{
				la2[i].setLocation(200,20+i*30);
				la2[i].setSize(40,20);
				la2[i].setOpaque(true);
				add(la2[i]);
			}
			
			b=new JRadioButton[2];
			b[0]=new JRadioButton(a[4],true);
			b[1]=new JRadioButton(a[5]);
			ButtonGroup bg=new ButtonGroup();
			for(int i=0;i<b.length;i++)
			{
				bg.add(b[i]);
				b[i].setLocation(30+i*90,160);
				b[i].setSize(87,20);
				b[i].setOpaque(true);
				b[i].addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange()==ItemEvent.DESELECTED)return;
						if(b[0].isSelected())gender=false;
						else gender=true;
					}
				});
				add(b[i]);
			}
			
			JLabel la3=new JLabel(a[3]);
			la3.setBounds(20,120,60,20);
			add(la3);
			
			JLabel la4=new JLabel(a[6]);
			la4.setBounds(20,240,60,20);
			add(la4);
			
			cb=new JCheckBox[3];
			cb[0]=new JCheckBox(a[7]);
			cb[1]=new JCheckBox(a[8]);
			cb[2]=new JCheckBox(a[9]);
			for(int i=0;i<cb.length;i++)
			{
				cb[i].setLocation(5+i*87,280);
				cb[i].setSize(87,20);
				cb[i].setOpaque(true);
				cb[i].addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange()==ItemEvent.SELECTED)
						{
							if(e.getItem()==cb[0])index1=true;
							else if(e.getItem()==cb[1])index2=true;
							else if(e.getItem()==cb[2])index3=true;
						}
						if(e.getStateChange()==ItemEvent.DESELECTED)
						{
							if(e.getItem()==cb[0])index1=false;
							else if(e.getItem()==cb[1])index2=false;
							else if(e.getItem()==cb[2])index3=false;
						}
					}
				});
				add(cb[i]);
			}
			setSize(300,500);
		}
		
	}
	private class BMI extends JPanel
	{
		public void paintComponent(Graphics g) 
		{ 
		   super.paintComponent(g);
		   g.setColor(Color.gray);
		   g.drawRect(10, 20, 200, 200);
		   g.setColor(Color.gray);
		   g.drawRect(62, 80, 90, 90);
		   g.setColor(Color.gray);
		   g.drawRect(10, 250, 200, 100);
		 }
		BMI() 
		{
			setLayout(null);
			JLabel la1=new JLabel("BMI-result");
			la1.setBounds(20,0,100,20);
			la1.setOpaque(true);
			result1=new JLabel[3];
			result1[0]=new JLabel();
			result1[1]=new JLabel("BMI:");
			result1[2]=new JLabel();
			for(int i=0;i<result1.length;i++)
			{	
				result1[i].setBounds(10,i*20+20,200,20);
				result1[i].setVisible(false);
				add(result1[i]);
			}
			
			result2=new JLabel[3];
			result2[0]=new JLabel("DRINKING NO!");
			result2[1]=new JLabel("SMOKING NO!");
			result2[2]=new JLabel("MORE EXERCISE!");
			for(int i=0;i<result1.length;i++)
			{	
				result2[i].setBounds(10,i*20+250,150,20);
				result2[i].setVisible(false);
				add(result2[i]);
			}
			
			JLabel la2=new JLabel("opinion");
			la2.setBounds(20,230,100,20);
			la2.setOpaque(true);
			add(la2);
			add(la1);
			
			color=new JLabel();
			color.setBounds(65, 82, 85, 85);
			color.setOpaque(true);
			add(color);
			
	
			setSize(400,700);
		}
	}

}
