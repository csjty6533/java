package cardlayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class View1 extends JPanel {

	public void paintComponent(Graphics g) 
	{ 
	    Toolkit tk = Toolkit.getDefaultToolkit(); 
	    Image img = tk.getImage("images/lion01.jpg"); 
	    g.drawImage(img, 0, 0,300,380, this); 
	}
}
