/*
 * File Name: Decorator.java
 * Assignment: ENSF 614 Lab 6 - Exercise F
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */
public abstract class Decorator implements Component {
	
	protected Component cmp;
	protected int x;
	protected int y;
	protected int width;
	public int height;
	
	public Decorator(Component cmp, int x, int y, int width, int height) {
		super();
		this.setCmp(cmp);
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Component getCmp() {
		return cmp;
	}

	public void setCmp(Component cmp) {
		this.cmp = cmp;
	}

}
