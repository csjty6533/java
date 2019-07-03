package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JComponent;

public class SecondCounterLockup extends JComponent{
	private boolean keepRunning;
	private Font paintFont;
	private String timeMsg;
	private int arcLen;
	public SecondCounterLockup()
	{
		paintFont=new Font("Sanserif",Font.BOLD,14);
		timeMsg="never started";
		arcLen=0;
	}
	public void runClock()
	{
		System.out.println("thread running runClock() is "+Thread.currentThread().getName());
		DecimalFormat fmt=new DecimalFormat("0.000");
		long normalSleepTime=100;
		int counter=0;
		keepRunning=true;
		while(keepRunning)
		{
			try {
				Thread.sleep(normalSleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++;
			double counterSecs=counter/10.0;
			timeMsg=fmt.format(counterSecs);
			arcLen=(((int)counterSecs)%60)*360/60;
			repaint();
		}
	}
	public void stopClock()
	{
		keepRunning=false;
	}
	public void patin(Graphics g)
	{
		System.out.println("thread that invoke paint() is "+Thread.currentThread().getName());
		g.setColor(Color.black);
		g.setFont(paintFont);
		g.drawString(timeMsg, 0, 15);
		g.fillOval(0, 220, 100, 100);
		g.setColor(Color.white);
		g.fillOval(3, 23, 94, 94);
		g.setColor(Color.blue);
		g.fillArc(2, 22, 96, 96,90,arcLen);
	}
}
