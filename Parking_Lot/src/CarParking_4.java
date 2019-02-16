import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CarParking_4 extends JFrame{
	public CarParking_4()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new End());
		setSize(1000,700);setVisible(true);
	}
	private class End extends Panel
	{
		End()
		{
			setLayout(null);
			setBackground(Color.pink);
			JLabel title=new JLabel("THANK YOU FOR USING ME");
			title.setFont(new Font("Arial",Font.PLAIN,30));
			title.setSize(600,100);
			title.setLocation(200,120);
			add(title);
			JButton b=new JButton("Return");
			b.setSize(100,30);
			b.setLocation(500,500);
			b.addActionListener(new event_4());
			add(b);
		}
	}
}
