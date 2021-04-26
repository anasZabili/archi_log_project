package shapes;

import java.awt.*;
import java.awt.geom.*;

import visitor.Visitor;

public class Rectangle implements Drawable {
	private double x0, y0, x1, y1;
	private Color c;

	public double getX0() {
		return x0;
	}

	public double getY0() {
		return y0;
	}

	public double getX1() {
		return x1;
	}

	public double getY1() {
		return y1;
	}

	public Color getC() {
		return c;
	}

	public Rectangle(double x0, double y0, double x1, double y1, Color c) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		this.c = c;
	}

	// Méthodes propres à Rectangle :
	public double getWidth() {
		return Math.abs(x1 - x0);
	}

	public double getHeight() {
		return Math.abs(y1 - y0);
	}

	public void move(int dx, int dy) {
		this.x0 += dx;
		this.x1 += dx;
		this.y0 += dy;
		this.y1 += dy;
	}

	// // Méthode de rendu :
	// public void draw(Graphics2D screen) {
	// screen.setColor(c);
	// screen.draw(new Rectangle2D.Double(x0, y0, x1 - x0, y1 - y0));
	// }

	@Override
	public void accept(Visitor v) {
		v.draw(this);
	}
}
