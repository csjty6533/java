package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Home extends JPanel implements ActionListener{
	private JButton btn[][];
	private static Main frame=new Main();
	private String code;
	private SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
	Home(String num)
	{
		code=num;
		setLayout(null);
		setBackground(new Color(051,051,051));
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
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setCode(String num)
	{
		code=num;
	}
}
