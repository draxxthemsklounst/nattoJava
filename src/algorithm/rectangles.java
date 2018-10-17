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
	
	public static void swapRect(rectangles[] r, int n,int m) {
		rectangles temp = new rectangles();
		/*
		temp.setY(r[n].getY());
		temp.setX(r[n].getX());
		
		r[n].setY(r[m].getY());
		r[n].setX(r[n].getX());
		
		r[m].setY(temp.getY());
		r[m].setX(temp.getX());
		*/
		
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
}
