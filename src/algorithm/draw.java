package algorithm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class draw extends Canvas{
	public draw() {
		this.setSize(new Dimension(1000,500));
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(true);
	}
	public void drawing() {
		repaint();
	}
	
	public void paint(Graphics g,int width, int height) {
            
            g.drawRect(0, 0, 30, 30);
            g.drawRect(30, 0, 30, 30);
	}
	public static void addRectangle(int width,int height) {
		
	}
	public void initRectangles(int windowWidth, int windowHeight,int size) {
		int rectWidth = windowWidth / size;
		for(int i = 0; i<size;i++) {
			
		}
	}
}
