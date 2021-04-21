package shapes;

import java.awt.*;
import java.awt.geom.*;

import noise.Noise;

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

  // Méthode de rendu :
  public void draw(Graphics2D screen) {
    screen.setColor(c);
    screen.draw(new Ellipse2D.Double(cx - rad, cy - rad, noiseRayX, noiseRayY));
  }
}
