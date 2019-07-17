package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import clock.Timer;

public class Home extends JPanel implements ActionListener,Runnable{
	private JButton btn[][];
	private Login login=new Login();
	private String code;
	private int num1,num2;
	private SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
	private Timer timer;
	private Calendar dateBefore;
	Home(String num)
	{
		code=num;
		setLayout(null);
		num1=(Integer.parseInt(code)-1)/6;
		num2=(Integer.parseInt(code)-1)%6;
		btn=new JButton[5][6];
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<6;j++)
			{
				btn[i][j]=new JButton("<html><p style='color:#ea7722;'>NUM:"+(i*6+j+1)+"</p>시간:     <br/>요금:     </html>");
				btn[i][j].setBounds(20+j*130,70+i*100,120,80);
				btn[i][j].setBackground(Color.white);
				add(btn[i][j]);
				if(code!=null&&Integer.parseInt(code)==(i*6+j+1))
					{
						btn[i][j].setBackground(Color.green);
						btn[i][j].setText("<html><p style='color:#ea7722;'>NUM:"+(i*6+j+1)+"</p>시간:     "+sdf.format(new Date())+"~<br/>요금:     </html>");
					}
			}
		}	
		dateBefore = Calendar.getInstance(); 
		dateBefore.setTimeInMillis(System.currentTimeMillis());
		timer=new Timer(dateBefore);
		Thread th=new Thread(timer);
		th.start();
		Thread th2=new Thread(this);
		th2.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setCode(String num)
	{
		code=num;
	}
	public void run()
	{
		if(login.getInstance()==null)login=new Login();
		else login=login.getInstance();
		do
		{
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			btn[num1][num2].setText("<html><p style='color:#ea7722;'>NUM:"+code+"</p>시간: "+(timer.getDiffer()/3600)+":"+(timer.getMin())+"<br/>요금: "+(timer.getMoney())+"원</html>");
			login.getClient().sendMessage("<html><p style='color:#ea7722;'>NUM:"+code+"</p>시간: "+(timer.getDiffer()/3600)+":"+(timer.getMin())+"<br/>요금: "+(timer.getMoney())+"원</html>");
		}while(true);
	}
}