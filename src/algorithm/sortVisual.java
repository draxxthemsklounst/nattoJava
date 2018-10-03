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
		this.setPreferredSize(new Dimension(1000,500));
		this.setMinimumSize(new Dimension(1000,500));
		this.setMaximumSize(new Dimension(1000,500));
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(50, 50, 90, 90);
	}
	public void initArray(int n) {
		int[] temp = new int[n];
		temp = sortingAlgorithms.randArray(n);
		for(int i = 0;i<n;i++) {
			
		}
	}
}
