package algorithm;

import java.awt.Dimension;

import javax.swing.JFrame;

public class insertion {
	public static void main(String [] args) {
		frame f = new frame();
		
		//GUI
		JFrame window = new JFrame();
		window.add(f);
		window.setContentPane(f);
		window.setTitle("Search Algorithm GUI");
		window.getContentPane().setPreferredSize(new Dimension(1280,720));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setLocationRelativeTo("Center");
		window.setVisible(true);
		window.setResizable(false);
		window.pack();
	}
}
