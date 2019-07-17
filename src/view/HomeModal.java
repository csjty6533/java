package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomeModal extends JFrame implements WindowListener{
	private JLabel orders,nick;
	private static Main frame=new Main();
	HomeModal()
	{
		if(frame.getInstance()==null)frame=new Main();
		else frame=frame.getInstance();

		setBounds(250,150,400,370);
		setLayout(new BorderLayout());
		setVisible(true);
		
		nick=new JLabel(frame.getLogin().getCode()+"");
		add(nick,BorderLayout.NORTH);
		String order="<html>";
		Iterator <String> it=Main.getOrderList().iterator();

		while(it.hasNext())
		{
			System.out.println("4444");
			order.concat(it.toString()+"<br/>");
		}
		System.out.println("5555");
		order.concat("</html>");
		orders=new JLabel(order);
		orders.setOpaque(true);
		
		add(orders,BorderLayout.CENTER);
	}
	public void setOrders(ArrayList<String> orderList)
	{
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
