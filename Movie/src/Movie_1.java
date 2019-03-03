import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Movie_1 {
	private Seat ss;
	private JFrame f;
	private Page p;
	private Movie movie;
	Movie_1(Movie a5)
	{
		
		movie=a5;
		p=new Page();
		p.setBounds(120,50,600,500);
		p.setVisible(false);
		f.add(p);
	}
	void get(int a1,int a2)
	{
		p.setVisible(true);
		ss.getSeat(a1, a2);
	}
	void setVisible(boolean a)
	{
		if(a)p.setVisible(true);
		else p.setVisible(false);
	}
	private class Page extends Panel
	{
		Page()
		{
			JButton b=new JButton("return");
			b.setSize(100,20);
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					p.setVisible(false);
					
				}
			});
			add(b);
		}
	}
}
