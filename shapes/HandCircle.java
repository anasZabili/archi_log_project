package shapes;

import java.awt.*;
import java.awt.geom.*;

import noise.Noise;
import visitor.Visitor;

public class HandCircle implements Drawable {
  private double cx, cy, rad, noiseRayX, noiseRayY;
  private Color c;

  public HandCircle(double cx, double cy, double rad, Color c) {
    this.cx = cx;
    this.cy = cy;
    this.rad = rad;
    this.c = c;
    this.noiseRayX = rad * 2 + Noise.getNoise(rad * 2);
    this.noiseRayY = rad * 2 + Noise.getNoise(rad * 2);
  }

  // Méthodes propres à HandCircle :
  public double getRadius() {
    return rad;
  }

  public void move(int dx, int dy) {
    this.cx += dx;
    this.cy += dy;
  }

  // // Méthode de rendu :
  // public void draw(Graphics2D screen) {
  // screen.setColor(c);
  // screen.draw(new Ellipse2D.Double(cx - rad, cy - rad, noiseRayX, noiseRayY));
  // }

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

  public double getNoiseRayX() {
    return noiseRayX;
  }

  public void setNoiseRayX(double noiseRayX) {
    this.noiseRayX = noiseRayX;
  }

  public double getNoiseRayY() {
    return noiseRayY;
  }

  public void setNoiseRayY(double noiseRayY) {
    this.noiseRayY = noiseRayY;
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
