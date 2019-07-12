package clock;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clock extends JPanel implements Runnable{

	private int i=Calendar.getInstance().get(Calendar.AM_PM);
	private String ampm[]= {"AM","PM"};
	private SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
	private String time=sdf.format(new Date());
	private JLabel timeLabel,ampmLabel;
	public Clock()
	{
		setLayout(null);
		timeLabel=new JLabel(time);
		timeLabel.setBounds(40,0,100,20);
		timeLabel.setForeground(new Color(36,205,198));
		timeLabel.setFont(new Font("FixedSys",Font.BOLD,20));
		//timeLabel.setFont(new Font(""))
		
		ampmLabel=new JLabel(ampm[i]);
		ampmLabel.setBounds(0,0,50,20);
		ampmLabel.setForeground(new Color(36,205,198));
		ampmLabel.setForeground(new Color(36,205,198));
		ampmLabel.setFont(new Font("FixedSys",Font.BOLD,20));
		add(timeLabel);
		add(ampmLabel);
	}

	@Override
	public void run() {
		do
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			timeLabel.setText(sdf.format(new Date()));
			ampmLabel.setText(ampm[Calendar.getInstance().get(Calendar.AM_PM)]);
		}while(true);
		
	}
}
