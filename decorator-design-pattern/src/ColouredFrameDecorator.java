import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
/*
 * File Name: ColouredFrameDecorator.java
 * Assignment: ENSF 614 Lab 6 - Exercise F
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */

public class ColouredFrameDecorator extends Decorator{
	private int thickness;
	
	public ColouredFrameDecorator(Component cmp, int x, int y, int width, int height, int thickness) {
		super(cmp, x, y, width, height);
		this.thickness = thickness;
	}

	public void draw(Graphics g) {
		getCmp().draw(g);
		Graphics2D g2d = (Graphics2D) g;  // Cast to Graphics2D
		Stroke oldStroke = g2d.getStroke();
		Color oldColor = g2d.getColor();
		g2d.setStroke(new BasicStroke(thickness));
		g2d.setColor(Color.red);
		g2d.drawRect(getX(),  getY(),  getWidth(), getHeight());
		g2d.setStroke(oldStroke);
		g2d.setColor(oldColor);
	}
}
