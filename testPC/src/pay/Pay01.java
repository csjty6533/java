package pay;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.Main;
import view.Pay;

public class Pay01 extends JPanel implements ActionListener{
//1381151828625.jpg
	private static Main frame=new Main();
	private JButton b1[],b2[];
	private JLabel la1[],la2[];
	public void paintComponent(Graphics g) 
	{ 
	    Toolkit tk = Toolkit.getDefaultToolkit(); 
	    Image img01 = tk.getImage("images/cupnuddle/1542930994812.jpg"); 
	    g.drawImage(img01, 0, 0,100,100, this);
	    Image img02 = tk.getImage("images/cupnuddle/1542959295736.jpg"); 
	    g.drawImage(img02, 130, 0,100,100, this);
	    Image img03 = tk.getImage("images/cupnuddle/1545377667141.jpg"); 
	    g.drawImage(img03, 260, 0,100,100, this);
	    Image img04 = tk.getImage("images/cupnuddle/1545377708988.jpg"); 
	    g.drawImage(img04, 390, 0,100,100, this);
	    Image img05 = tk.getImage("images/cupnuddle/1551052293060.jpg"); 
	    g.drawImage(img05, 520, 0,100,100, this);
	    
	    Image img11 = tk.getImage("images/cupnuddle/necup_434.jpg"); 
	    g.drawImage(img11, 0, 150,100,100, this);
	    Image img12 = tk.getImage("images/cupnuddle/39029766247423479_1807166190.jpg"); 
	    g.drawImage(img12, 130, 150,100,100, this);
	    Image img13 = tk.getImage("images/cupnuddle/5751877212.20130306165016.jpg"); 
	    g.drawImage(img13, 260, 150,100,100, this);
	    Image img14 = tk.getImage("images/cupnuddle/1545377708988.jpg"); 
	    g.drawImage(img14, 390, 150,100,100, this);
	    Image img15 = tk.getImage("images/cupnuddle/1551052293060.jpg"); 
	    g.drawImage(img15, 520, 150,100,100, this);
	    
	    Image img21 = tk.getImage("images/cupnuddle/necup_434.jpg"); 
	    g.drawImage(img21, 0, 300,100,100, this);
	    Image img22 = tk.getImage("images/cupnuddle/1542959295736.jpg"); 
	    g.drawImage(img22, 130, 300,100,100, this);
	    Image img23 = tk.getImage("images/cupnuddle/1545377667141.jpg"); 
	    g.drawImage(img23, 260, 300,100,100, this);
	    Image img24 = tk.getImage("images/cupnuddle/1545377708988.jpg"); 
	    g.drawImage(img24, 390, 300,100,100, this);
	    Image img25 = tk.getImage("images/cupnuddle/1551052293060.jpg"); 
	    g.drawImage(img25, 520, 300,100,100, this);
	    
	}
	public Pay01()
	{
		setLayout(null);
		b1=new JButton[15];
		b2=new JButton[15];
		for(int i=0;i<b1.length;i++)
		{
			b1[i] = new JButton("+");
	        b1[i].setBounds((i%5)*130, 110+(i/5)*150, 47, 25);
	        add(b1[i]);
	        b1[i].addActionListener(this);
		}
		
        for(int i=0;i<b2.length;i++)
        {
        	b2[i] = new JButton("-");
            b2[i].setBounds(50+(i%5)*130, 110+(i/5)*150, 47, 25);
            add(b2[i]);
            b2[i].addActionListener(this);
        }
        
        setOpaque(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(frame.getInstance()==null)frame=new Main();
		else frame=frame.getInstance();
		for(int i=0;i<b1.length;i++)
		{
			if(ob==b1[i])
			{
				Object data[]= {"111","222",333,"444"};
				frame.getLogin().getPay().getTable().addRow(data);
			}else if(ob==b2[i]&&frame.getLogin().getPay().getTable().getRowCount()>0)
			{
				frame.getLogin().getPay().getTable().removeRow(frame.getLogin().getPay().getTable().getRowCount()-1);
			}
		}
	
	}
	
}
