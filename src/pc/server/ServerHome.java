package pc.server;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import clock.Timer;
import dao.OrderDao;



public class ServerHome extends JPanel implements ActionListener{
	private static JButton btn[][];
	//private static Main frame=new Main();
	private JPanel contentPane;
	private JPanel panel;
	private ArrayList<String> others;
	private SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
	private CardLayout card=new CardLayout();
	private ServerBackground server = new ServerBackground();
	private static Map<Integer, DataOutputStream> clientsMap = new HashMap<Integer, DataOutputStream>();
	private static Map<Integer, Calendar> clientsTime = new HashMap<Integer, Calendar>();
	private OrderDao orderDao;
	
	public ServerHome () throws IOException
	{
		
        setLayout(null);
		btn= new JButton[5][6];
		//PayDao payDao=new PayDao();
		//ArrayList<Integer>list=payDao.select();	
		//for(int i=0;i<list.size();i++)System.out.println(list.get(i));
		orderDao=new OrderDao();
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<6;j++)
			{
				int k=(i*6+j+1);
				btn[i][j]=new JButton("<html><p style='color:#ea7722;'>NUM:"+(i*6+j+1)+"</p>시간:     <br/>요금:     </html>");
				btn[i][j].setBounds(20+j*130,70+i*100,120,80);
				btn[i][j].setBackground(Color.white);
				add(btn[i][j]);
				
				//Thread counterThread=new Thread(btn[i][j]);
				//counterThread.start();
				
			    
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void clientSetting()
	{
		clientsMap=server.getClientsMap();
		
		//setTitle("setting");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<6;j++)
			{
				btn[i][j].setBackground(Color.white);
				btn[i][j].setText("<html><p style='color:#ea7722;'>NUM:"+(i*6+j+1)+"</p>시간:     <br/>요금:     </html>");
				int k=(i*6+j+1);
				Iterator<Integer> it = clientsMap.keySet().iterator();
		        int key;
		        while (it.hasNext()) {
		        	//this.setTitle("come");
		            key = it.next();
		            
		            if(key==k)btn[i][j].setBackground(Color.red); 
		            
					/*
					 * else { btn[i][j].setBackground(Color.white); btn[i][j]=new
					 * JButton("<html><p style='color:#ea7722;'>NUM:"+(i*6+j+1)
					 * +"</p>시간:     <br/>요금:     </html>"); }
					 */
		        }
		        

			}
		}
	}
	

	public void timerStart(int nick,String msg) {
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<6;j++)
			{
				int k=(i*6+j+1);
				if(nick==k)btn[i][j].setText(msg);
			}
		}
		 
		
		
		
	}
	
}
