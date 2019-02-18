import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_3 extends JFrame
{
	private JTextField text[];
	private String dataArr[];
	private int calendar,time,hour,slot;
	Parking_3()
	{
		
	}
	Parking_3(int a1,int a2,int a3,int a4)
	{
		calendar=a1;
		time=a2;
		hour=a3;
		slot=a4;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Container());
		setBackground(Color.gray);
		getMenu();
		add(new Page3(),BorderLayout.CENTER);
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
	private class Page3 extends Panel
	{
		Page3()
		{
			setLayout(null);
			
			Title p1=new Title();
			p1.setBounds(140,70,700,90);
			
			Data p2=new Data();
			p2.setBounds(150,160,650,240);
			
			Submit p3=new Submit();
			p3.setBounds(300,500,385,540);
			
			add(p1);add(p2);add(p3);
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
			GridLayout gl=new GridLayout(3,4);
			gl.setVgap(80);gl.setHgap(10);
			setLayout(gl);
			
			JLabel id[]=new JLabel[6];
			String idArr[]= {"Name","Tel-1","Identify-number","Tel-2","Adress","E-mail"};
			for(int i=0;i<id.length;i++) 
			{
				id[i]=new JLabel(idArr[i]);
				id[i].setFont(new Font("Arial",Font.PLAIN,18));
				add(id[i]);
			}
			
			text=new JTextField[6];
			for(int i=0;i<text.length;i++)
			{
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
			for(int i=0;i<text.length;i++)
			{
				dataArr[i]=text[i].getText();
			}
			ParkingLot instance=new Customer(calendar,time,hour,slot,dataArr); 
		}
		
	}
}
