package algorithm;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class insertion {
	public static void main(String [] args) {
		dewit();
	}
	protected static void dewit() {
		frame f = new frame();
		
		//GUI
		JFrame window = new JFrame();
		window.add(f);
		window.setContentPane(f);
		window.setTitle("Visual Algorithm and GUI Project (natto)");
		window.getContentPane().setPreferredSize(new Dimension(1280,720));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
		
	}
}
