package algorithm;

import java.awt.Color;

public class rectangles {
	private int width;
	private int height;
	private int x;
	private int y;
	private int value;
	private boolean isWhite;
	
	public rectangles() {
		width = 0;
		height = 0;
		x = 0;
		y=0;
		value = 0;
		isWhite = true;
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
	public void setWhiteBool(boolean b) {
		isWhite = b;
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
	public boolean getWhiteBool() {
		return isWhite;
	}
}
