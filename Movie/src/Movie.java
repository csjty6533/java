import java.awt.Font;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Movie
{
	private Seat seat;
	private JFrame f;
	private Login l;
	private Moviesss m;
	private Movie_1 m1;
	private static Movie mm;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Seat seat=new Seat();
		mm=new Movie(seat);
	}
	Movie(Seat a1)
	{
		seat=a1;
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l=new Login(mm);
		m=new Moviesss(mm);
		m1=new Movie_1(mm);
		Page p=new Page();
		p.setBounds(0,20,800,500);
		f.add(p);
		
		JLabel t=new JLabel("MOVIE");
		t.setFont(new Font("Arial",Font.PLAIN,30));
		t.setBounds(50,20,120,50);
		f.add(t);
		f.setSize(800, 600);
		f.setVisible(true);
	}
	private class Page extends Panel
	{
		Page()
		{
			setLayout(null);
			m.getMovies();
			l.getLogin();
		}
	}
	void getM1(int a1,int a2){m1.get(a1, a2);};
	JFrame getF() {return f;};
	Seat getS() {return seat;};
}