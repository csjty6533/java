import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Event{

	
}
class event_1 implements ActionListener
{
	String date[];
	event_1(JComboBox<String>[] a1)
	{
		date=new String[3];
		for(int i=0;i<a1.length;i++)
		{
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		new CarParking_2();
	}
	
}

	
class event_2 implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new CarParking_3();
	}
	
}
class event_3 implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new CarParking_4();
	}
	
}
class event_4 implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new CarParking();
	}
	
}
