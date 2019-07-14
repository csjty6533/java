package clock;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

public class Timer extends JPanel implements Runnable{


	private static Calendar dateBefore;
	private long differ=0;
	private int min=0,money = 0;
	public static void main(String[] args) 
	{ 
		Timer timer=new Timer();
		Thread th=new Thread(timer);
		th.start();
	}
	public Timer()
	{
		dateBefore = Calendar.getInstance(); 
		dateBefore.setTimeInMillis(System.currentTimeMillis()); 
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
				System.out.println("사용시간부터 지금까지 " + differ / 3600 +"시 "+ min+"분이 지났다~");
				money = (int) (differ / 60) * 100 / 6; 
				System.out.println("사용요금은 " + money + "원이다."); 
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
	
	
	
}
