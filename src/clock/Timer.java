package clock;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

public class Timer extends Thread{


	private static Calendar dateBefore;
	private long differ=0;
	private int min=0,money = 0;
	
	public Timer(Calendar dateBefore)
	{
		this.dateBefore = dateBefore;
	}
	@Override
	public void run() {
		do
		{
			try {
				
				Thread.sleep(60000);
				Calendar dateAfter = Calendar.getInstance(); 
				dateAfter.setTimeInMillis(System.currentTimeMillis()); 
				differ = (dateAfter.getTimeInMillis() - dateBefore.getTimeInMillis()) / 1000; 
				min = (int)((differ/60)%60);
				
				money = (int) (differ / 60) * 100 / 6; 
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}while(true);
		
	}
	public long getDiffer() {
		return differ;
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMoney() {
		return money;
	}
	public static Calendar getDateBefore() {
		return dateBefore;
	}
	public static void setDateBefore(Calendar dateBefore) {
		Timer.dateBefore = dateBefore;
	}
	
	
	
}