package shapes;

import java.awt.*;

import visitor.Visitor;

public class HandRectangle implements Shape {
  private double x0, y0, x1, y1;
  private Color c;

  public HandRectangle(double x0, double y0, double x1, double y1, Color c) {
    this.x0 = x0;
    this.y0 = y0;
    this.x1 = x1;
    this.y1 = y1;
    this.c = c;
  }

  // Méthodes propres à HandRectangle :
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
  // HandLine l1 = new HandLine(x0, y0, x1, y0, c);
  // HandLine l2 = new HandLine(x0, y0, x0, y1, c);
  // HandLine l3 = new HandLine(x0, y1, x1, y1, c);
  // HandLine l4 = new HandLine(x1, y0, x1, y1, c);
  // l1.draw(screen);
  // l2.draw(screen);
  // l3.draw(screen);
  // l4.draw(screen);
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
