package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JComponent;

public class SecondCounterRunnable extends JComponent implements Runnable{

	private volatile boolean keepRunning=true;
	private Font paintFont;
	private volatile String timeMsg="";
	private volatile int arcLen=0;
	public SecondCounterRunnable()
	{
		System.out.println("00");
		paintFont=new Font("SanSerif",Font.BOLD,14);
		//timeMsg="never started";
		arcLen=0;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("0");
		runClock();
	}
	public void runClock()
	{
		//DecimalFormat fmt=new DecimalFormat("0.000");
		System.out.println("1");
		long normalSleepTime=100;
		int counter=0;
		System.out.println("2");
		keepRunning=true;
		System.out.println("3");
		while(keepRunning)
		{
			System.out.println("4");
			try
			{
				System.out.println("5");
				Thread.sleep(100);
				System.out.println("6");
			}catch(Exception e) {System.out.println(e.getMessage());}
			counter++;
			System.out.println(counter);
			double counterSecs=counter/10.0;
			//timeMsg=fmt.format(counterSecs);
			arcLen=(((int)counterSecs)%60)*360/60;
			repaint();
		}
	}
	public void stopClock()
	{
		keepRunning=false;
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		//g.setFont(paintFont);
		//g.drawString(timeMsg, 0, 15);
		g.fillOval(0, 20, 100, 100);
		
		g.setColor(Color.white);
		g.fillOval(3, 23, 94, 94);
		
		g.setColor(Color.blue);
		g.fillArc(2, 22, 96, 96, 90, arcLen);
	}
}
