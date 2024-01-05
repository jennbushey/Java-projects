import java.awt.Graphics;
import java.awt.Graphics2D;
/*
 * File Name: Text.java
 * Assignment: ENSF 614 Lab 6 - Exercise F
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */
public class Text implements Component {
	private int x;
	private int y;
	private String text;
	Component t;
	
	public Text(String string, int i, int j) {
		this.text = string;
		this.x = i;
		this.y = j;
	}


	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString(text, x, y);
	}
}
