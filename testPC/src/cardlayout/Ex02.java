package cardlayout;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ex02 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton b1,b2;
	private JPanel panel;
	private View1 v1=new View1();
	private View2 v2=new View2();
	
	private CardLayout card=new CardLayout();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try
				{
					Ex02 frame=new Ex02();
					frame.setVisible(true);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}

		});
	
		
	}
	public Ex02()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 488, 495);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        panel = new JPanel();
        
        panel.setLayout(card);
        panel.add("view1", v1);//화면에 이름붙임.
        panel.add("view2",v2);
       
        card.show(panel, "view2");//실행하자 마자 보이는 panel
        
        panel.setBounds(12, 55, 448, 392);
        contentPane.add(panel);
        
        b1 = new JButton("화면 11");
        b1.setBounds(12, 10, 97, 35);
        contentPane.add(b1);
        
        b2 = new JButton("\uD654\uBA742");
        b2.setBounds(121, 10, 97, 35);
        contentPane.add(b2);
        
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
       


		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  Object ob = e.getSource();
	        if(ob == b1) {
	            card.show(panel, "view1");
	        }else if(ob == b2) {
	            card.show(panel, "view2");
	        }
	
	}

}
