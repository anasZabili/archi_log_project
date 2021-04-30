package shapes;

import java.awt.*;
import java.awt.geom.*;

import visitor.Visitor;

public class Circle implements Shape {
	private double cx, cy, rad;
	private Color c;

	public Circle(double cx, double cy, double rad, Color c) {
		this.cx = cx;
		this.cy = cy;
		this.rad = rad;
		this.c = c;
	}

	// Méthodes propres à Circle :
	public double getRadius() {
		return rad;
	}

	// Méthode de rendu :
	public void draw(Graphics2D screen) {
		screen.setColor(c);
		screen.draw(new Ellipse2D.Double(cx - rad, cy - rad, rad * 2, rad * 2));
	}

	public double getCx() {
		return cx;
	}

	public void setCx(double cx) {
		this.cx = cx;
	}

	public double getCy() {
		return cy;
	}

	public void setCy(double cy) {
		this.cy = cy;
	}

	public double getRad() {
		return rad;
	}

	public void setRad(double rad) {
		this.rad = rad;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	@Override
	public void move(int dx, int dy) {
		this.cx += dx;
		this.cy += dy;
	}

	@Override
	public void accept(Visitor v) {
		v.draw(this);
	}

}
