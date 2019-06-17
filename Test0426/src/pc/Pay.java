package pc;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Pay extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JButton b1,b2,b3,b4,b5;
	private JPanel panel;
	private CardLayout card=new CardLayout();
	private Pay01 pay01=new Pay01();
	private Pay02 pay02=new Pay02();
	private Pay03 pay03=new Pay03();
	private Pay04 pay04=new Pay04();
	private Pay05 pay05=new Pay05();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try
				{
					Pay frame=new Pay();
					frame.setVisible(true);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}

		});
	}
	public Pay()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 20, 1000, 695);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        panel = new JPanel();
        panel.setBounds(150, 100, 800, 500);
        
        panel.setLayout(card);
        panel.add("01",pay01);
        panel.add("02",pay02);
        panel.add("03",pay03);
        panel.add("04",pay04);
        panel.add("05",pay05);
        
        card.show(panel, "01");
        
        b1 = new JButton("01");
        b1.setBounds(12, 10, 97, 35);
        contentPane.add(b1);
        
        b2 = new JButton("02");
        b2.setBounds(12, 110, 97, 35);
        contentPane.add(b2);
        
        b3 = new JButton("03");
        b3.setBounds(12, 210, 97, 35);
        contentPane.add(b3);
        
        b4 = new JButton("04");
        b4.setBounds(12, 310, 97, 35);
        contentPane.add(b4);
        
        b5 = new JButton("05");
        b5.setBounds(12, 410, 97, 35);
        contentPane.add(b5);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        contentPane.add(panel);
        contentPane.setOpaque(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 Object ob = e.getSource();
	        if(ob == b1) {
	            card.show(panel, "01");
	        }
	        else if(ob == b2) {
	            card.show(panel, "02");
	        }else if(ob == b3) {
	           card.show(panel, "03");
	        }else if(ob == b4) {
		           card.show(panel, "04");
		    }else if(ob == b5) {
		           card.show(panel, "05");
		    }
	}

}
