package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomeModal extends JFrame{
	private JPanel contentPane;
	private JButton b;
	HomeModal()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(230, 220, 500, 305);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try
				{
					HomeModal frame=new HomeModal();
					frame.setVisible(true);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}

		});
	}
}
