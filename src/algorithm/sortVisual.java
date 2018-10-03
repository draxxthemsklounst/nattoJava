package algorithm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class sortVisual extends JPanel{
	public void sortVisual() {
		init();
	}
	public void init() {
		this.setSize(new Dimension(1000,500));
		this.setBackground(Color.GREEN);
		this.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(10, 10, 10, 10);
	}
}
