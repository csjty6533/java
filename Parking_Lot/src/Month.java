import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
public class Month {
	private String month[][];
	private String a[],b[],c[];
	Month()
	{
		a=new String[7];
		b=new String[12];
		c=new String[6];
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		int year=calendar.get(Calendar.YEAR);
		int mon=calendar.get(Calendar.MONTH);
		int day=calendar.get(Calendar.DATE);
		month=new String[7][12];
		for(int i=0;i<a.length;i++)a[i]=new String(year+""+mon+""+(day+i)+"");
	
		for(int i=0;i<b.length;i++)b[i]=new String(i+9+":00");
	
		for(int i=0;i<c.length;i++)c[i]=new String(i+1+"hour");
	}
	String[] getDate()
	{
		return a;
	}
	String[] getTime()
	{
		return b;
	}
	String[] getHour()
	{
		return c;
	}
}
