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
		// 추천 기본 크기를 알아서 지정
		setDoubleBuffered(true);
		// 그림 넣을 메모리를 활성화

		File input = new File("ship.jpg");
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
			// 이미지를 화면에 그린다
		}
		x = START_X;
		y = START_Y;

		timer = new Timer(1, this);
		timer.start();
		// 타이머 객체를 생성하고 시작
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	} // 이미지를 화면에 그린다

	@Override
	public void actionPerformed(ActionEvent e) {
		x += 1;
		y -= 1;
		if (x > WIDTH) {
			x = START_X;
			y = START_Y;
		}
		repaint();
		// 화면을 다시 그리게 한다
	}
}

public class test extends JFrame {
	public test() {
		add(new MyPanel_02()); // 패널을 프레임에 추가
		setTitle("에니메이션 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new test();
	}
}


