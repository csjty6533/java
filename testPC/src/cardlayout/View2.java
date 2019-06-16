package cardlayout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class View2 extends JPanel{
	public void paintComponent(Graphics g) 
	{ 
	    Toolkit tk = Toolkit.getDefaultToolkit(); 
	    Image img = tk.getImage("images/lion02.jpg"); 
	    g.drawImage(img, 0, 0,300,380, this); 
	}
}
