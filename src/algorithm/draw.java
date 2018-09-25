package algorithm;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JPanel;

public class draw extends Canvas{
	
	public void drawing() {
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		
		g.drawRect(30, 30, 30, 30);
	}
}
