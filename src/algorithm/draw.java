package algorithm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class draw extends Canvas{
	public draw() {
		this.setSize(new Dimension(800,400));
		this.setBackground(Color.DARK_GRAY);
	}
	public void drawing() {
		repaint();
	}
	@Override
	public void paint(Graphics g) {
            
            g.drawRect(0, 0, 30, 30);
            g.drawRect(30, 0, 30, 30);
	}
	public void addRectangle() {
		
	}
}
