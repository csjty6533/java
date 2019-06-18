package pc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Pay04 extends JPanel implements ActionListener{
//1381151828625.jpg
	private static Pay frame=new Pay();
	private JButton b1[],b2[];
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
	    Image img06 = tk.getImage("images/cupnuddle/necup_434.jpg"); 
	    g.drawImage(img06, 0, 150,100,100, this);
	    
	}
	public Pay04()
	{
		setLayout(null);
		b1=new JButton[6];
		b2=new JButton[6];
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
		if(frame.getInstance()==null)frame=new Pay();
		else frame=frame.getInstance();
		for(int i=0;i<b1.length;i++)
		{
			if(ob==b1[i])
			{
				Object data[]= {"111","222",333,"444"};
				frame.getTable().addRow(data);
			}else if(ob==b2[i]&&frame.getTable().getRowCount()>0)
			{
				frame.getTable().removeRow(frame.getTable().getRowCount()-1);
			}
		}
	
	}
	
}
