package algorithm;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class shapes {
	protected shapes() {
		JFrame frame = new JFrame("Test");
		frame.setVisible(true);
		frame.setSize(800,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new FlowLayout());
		draw object = new draw();
		frame.add(object);
	}
	private static void init() {
		JFrame frame = new JFrame("Test");
		frame.setVisible(true);
		frame.setSize(800,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new FlowLayout());
		draw object = new draw();
		frame.add(object);
	}

}
