import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class MyPanel_02 extends JPanel implements ActionListener {
	private final int WIDTH = 500;
	private final int HEIGHT = 300;
	private final int START_X = 0;
	private final int START_Y = 250;
	private BufferedImage image;
	private Timer timer;
	private int x, y;

	public MyPanel_02() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		// ��õ �⺻ ũ�⸦ �˾Ƽ� ����
		setDoubleBuffered(true);
		// �׸� ���� �޸𸮸� Ȱ��ȭ

		File input = new File("ship.jpg");
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
			// �̹����� ȭ�鿡 �׸���
		}
		x = START_X;
		y = START_Y;

		timer = new Timer(1, this);
		timer.start();
		// Ÿ�̸� ��ü�� �����ϰ� ����
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	} // �̹����� ȭ�鿡 �׸���

	@Override
	public void actionPerformed(ActionEvent e) {
		x += 1;
		y -= 1;
		if (x > WIDTH) {
			x = START_X;
			y = START_Y;
		}
		repaint();
		// ȭ���� �ٽ� �׸��� �Ѵ�
	}
}

public class test extends JFrame {
	public test() {
		add(new MyPanel_02()); // �г��� �����ӿ� �߰�
		setTitle("���ϸ��̼� �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new test();
	}
}

