import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/*
 * File Name: ColouredGlassDecorator.java
 * Assignment: ENSF 614 Lab 6 - Exercise F
 * Completed by: Jenn Bushey
 * Submission Date: November 10, 2023
 */

public class ColouredGlassDecorator extends Decorator {

	public ColouredGlassDecorator(Component cmp, int x, int y, int width, int height) {
		super(cmp, x, y, width, height);
	}

	public void draw(Graphics g) {
		getCmp().draw(g);
		Graphics2D g2d = (Graphics2D) g; // Cast to Graphics2D
		Color oldColor = g2d.getColor();
		g2d.setColor(Color.green);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1 * 0.1f));
		g2d.fillRect(getX(), getY(), getWidth(), getHeight());
		g2d.setColor(oldColor);
	}
}

