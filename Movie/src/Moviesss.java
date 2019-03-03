import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Moviesss 
{
	private int index1,index2;//choose movie
	private JFrame f;
	private Page mp;
	private Movie movie;
	Moviesss(Movie a)
	{
		movie=a;
		f=movie.getF();
		mp=new Page();
		mp.setBounds(120,50,600,600);
		mp.setBackground(Color.blue);
		f.add(mp);
	}
	void getMovies()
	{
		
	}
	void Renew()
	{
		
	}
	private class Page extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			 Toolkit tk = Toolkit.getDefaultToolkit(); 
			    Image img1 = tk.getImage("img/afterhours.jpg"); 
			    g.drawImage(img1, 20, 30,120,190, this); 
			    Image img2 = tk.getImage("img/fargo.jpg"); 
			    g.drawImage(img2, 160, 30,120,190, this); 
			    Image img3 = tk.getImage("img/nest.jpg"); 
			    g.drawImage(img3, 300, 30,120,190, this); 
			    Image img4 = tk.getImage("img/north.jpg"); 
			    g.drawImage(img4, 20, 260,120,190, this); 
			    Image img5 = tk.getImage("img/hot.jpg"); 
			    g.drawImage(img5, 160, 260,120,190, this); 
			    Image img6 = tk.getImage("img/three.jpg"); 
			    g.drawImage(img6, 300, 260,120,190, this); 
		}
		Page()
		{
			setLayout(null);
			JButton b[]=new JButton[6];
			String a[]= {"After Hours","Fargo","One Flew Over The Cuckoo's Nest","North By Northwest","Dog Day Afternoon","Le Cercle Rouge"};
			for(int i=0;i<6;i++)
			{
				b[i]=new JButton(a[i]);
				b[i].setBounds(20+(i%3)*140,220+(i/3)*230,120,40);
				b[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton c=(JButton)e.getSource();
						
						for(int j=0;j<6;j++)
						{
							if(c==b[j])index1=j;
						}
					}
				});
				add(b[i]);
			}
			Object a1[]= {"AB","Schedule"};
			Object a2[][]= 
				{
						{"A","11:00~13:00"},{"B","13:00~16:00"},
						{"A","15:00~18:00"},{"B","18:00~21:00"},
						{"A","20:00~23:00"},{"B","23:00~02:00"},
				};
			DefaultTableModel m=new DefaultTableModel(a2,a1);
			JTable t=new JTable(m);
			JTableHeader h=t.getTableHeader();
			h.setBackground(Color.gray);
			h.setOpaque(true);
			t.add(h);
			JScrollPane pane=new JScrollPane(t);
			add(pane);
			t.getColumn("AB").setPreferredWidth(20);
			t.getColumn("Schedule").setPreferredWidth(100);
			t.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					index2=t.getSelectedRow();
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			t.setBounds(460,50,120,400);
			add(t);
			
			JButton s=new JButton("submit");
			s.setBounds(460,460,120,30);
			add(s);
			
			s.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					movie.getM1(index1,index2);
					mp.setVisible(false);
				}
			});
			setOpaque(false);
		}
	}

}
