import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login {
	private JTextField tf[];
	private JFrame f;
	private Movie movie;
	private Page1 p1;
	Login(Movie a)
	{
		movie=a;
		f=movie.getF();
		p1=new Page1();
		p1.setBounds(10,80,100,100);
		p1.setBackground(Color.red);
		p1.setVisible(false);
		f.add(p1);
	}
	void getLogin()
	{
		p1.setVisible(true);
	}
	private class Page1 extends Panel
	{
		Page1()
		{
			setLayout(null);
			JLabel la[]=new JLabel[2];
			la[0]=new JLabel("id:");
			la[1]=new JLabel("pw:");
			tf=new JTextField[2];
			for(int i=0;i<2;i++)
			{
				la[i].setHorizontalAlignment(Label.LEFT);
				la[i].setBounds(5,5+i*35,30,30);
				add(la[i]);
				tf[i]=new JTextField();
				tf[i].setBounds(35,5+i*35,60,30);
				add(tf[i]);
			}
			setSize(100,100);
		}
	}
}
