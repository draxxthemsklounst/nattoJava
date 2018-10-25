package algorithm;

import java.awt.Color;

public class rectangles {
	private int width;
	private int height;
	private int x;
	private int y;
	private int value;
	private Color c = Color.WHITE; //regular rectangle color
	
	public rectangles() {
		width = 0;
		height = 0;
		x = 0;
		y = 0;
		value = 0;
	}
	public void setX(int n) {
		this.x = n;
	}
	public void setHeight(int n) {
		this.height = n;
	}
	public void setWidth(int n) {
		this.width = n;
	}
	public void setY(int n) {
		this.y = n;
	}
	public void setValue(int n) {
		this.value = n;
	}
	public void setColor(Color color) {
		this.c = color;
	}
	
	public int getX() {
		return x;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public int getY() {
		return y;
	}
	public int getValue() {
		return value;
	}
	public Color getColor() {
		return c;
	}
	
	public static void swap(rectangles[] r, int n,int m) {
		rectangles temp = new rectangles();
		
		temp.setColor(r[n].getColor());
		temp.setHeight(r[n].getHeight());
		temp.setY(r[n].getY());
		temp.setValue(r[n].getValue());
		
		r[n].setColor(r[m].getColor());
		r[n].setHeight(r[m].getHeight());
		r[n].setValue(r[m].getValue());
		r[n].setY(r[m].getY());
		
		r[m].setColor(temp.getColor());
		r[m].setHeight(temp.getHeight());
		r[m].setValue(temp.getValue());
		r[m].setY(temp.getY());
	}
	public static void swapRectComponent(rectangles[] n,rectangles [] m,int i, int j) {
		rectangles temp = new rectangles();
		
		temp.setColor(n[i].getColor());
		temp.setHeight(n[i].getHeight());
		temp.setY(n[i].getY());
		temp.setValue(n[i].getValue());
		
		n[i].setColor(m[j].getColor());
		n[i].setHeight(m[j].getHeight());
		n[i].setValue(m[j].getValue());
		n[i].setY(m[j].getY());
		
		m[j].setColor(temp.getColor());
		m[j].setHeight(temp.getHeight());
		m[j].setValue(temp.getValue());
		m[j].setY(temp.getY());
	}
}
