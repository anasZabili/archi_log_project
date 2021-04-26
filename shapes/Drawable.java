package shapes;

import java.awt.Graphics2D;

import visitor.Visitor;

public interface Drawable {
	// public void draw(Graphics2D screen);
	public void accept(Visitor v);

	public void move(int dx, int dy);

}
