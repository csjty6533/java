package chat.server;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PayDao;

public class ServerHome extends JFrame implements ActionListener,Runnable{
	private static JButton btn[][];
	//private static Main frame=new Main();
	private JPanel contentPane;
	private ArrayList<String> others;
	private SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
	
	private ServerBackground server = new ServerBackground();
	
	public ServerHome () throws IOException
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 20, 1000, 695);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
		//192.168.0.71
        contentPane.setLayout(null);
		setBackground(new Color(051,051,051));
		btn= new JButton[5][6];
		PayDao payDao=new PayDao();
		ArrayList<Integer>list=payDao.select();	
		for(int i=0;i<list.size();i++)System.out.println(list.get(i));
		System.out.println();
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
		setVisible(true);
		server.setGui(this);
		server.setting();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
