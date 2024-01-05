import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
/*
 * File Name: BorderDecorator.java
 * Assignment: ENSF 614 Lab 6 - Exercise F
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */

public class BorderDecorator extends Decorator {

	public BorderDecorator(Component cmp, int x, int y, int width, int height) {
		super(cmp, x, y, width, height);
	}

	public void draw(Graphics g) {
		getCmp().draw(g);
		Graphics2D g2d = (Graphics2D) g; // Cast to Graphics2D
		Stroke oldStroke = g2d.getStroke();
		Color oldColor = g2d.getColor();
		Stroke dashed = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
		g2d.setStroke(dashed);
		g2d.drawRect(getX(), getY(), getWidth(), getHeight());
		g2d.setStroke(oldStroke);
		g2d.setColor(oldColor);
	}
}
