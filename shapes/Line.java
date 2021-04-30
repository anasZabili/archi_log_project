package shapes;

import java.awt.*;
import java.awt.geom.*;

import visitor.Visitor;

public class Line implements Shape {
	private double x0, y0, x1, y1;
	private Color c;

	public Line(double x0, double y0, double x1, double y1, Color c) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		this.c = c;
	}

	// Méthodes propres à Line :
	public double getLength() {
		double dx = Math.abs(x1 - x0);
		double dy = Math.abs(y1 - y0);
		return Math.sqrt(dx * dx + dy * dy);
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
	// screen.draw(new Line2D.Double(x0, y0, x1, y1));
	// }

	public double getX0() {
		return x0;
	}

	public void setX0(double x0) {
		this.x0 = x0;
	}

	public double getY0() {
		return y0;
	}

	public void setY0(double y0) {
		this.y0 = y0;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	@Override
	public void accept(Visitor v) {
		v.draw(this);
	}

}
