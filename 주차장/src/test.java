import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.Toolkit; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
public class test extends JFrame { 
  test() { 
    setTitle("GUI Test"); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setVisible(true); 
    TestPanel p = new TestPanel(); 
    add(p); 
    setSize(500, 500); 
 } 
 class TestPanel extends JPanel { 
   TestPanel() { 
     JLabel lb = new JLabel("라벨"); 
     final JTextField tf = new JTextField(20); 
     JButton bt = new JButton("실행"); 
     add(lb); 
     add(tf); 
     add(bt); 
     setSize(500, 500); 
  } 
  public void paintComponent(Graphics g) { 
    Toolkit tk = Toolkit.getDefaultToolkit(); 
    Image img = tk.getImage("img/parking.png"); 
    g.drawImage(img, 0, 0,470,300, this); 
 } 
} 
public static void main(String[] args) { 
  new test(); 
} 
} 