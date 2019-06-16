package date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JFrame;

public class TitleTime extends JFrame{
	private LocalDate now=LocalDate.now();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TitleTime();
	}
	public TitleTime()
	{
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		new Thread(new Runnable() {
			private SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
					try
					{
						setTitle(now+sdf.format(new Date()));
						Thread.sleep(1000);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
			}
			
		}).start();
	}
}
