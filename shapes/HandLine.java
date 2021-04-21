package shapes;

import java.awt.*;
import java.awt.geom.*;
import java.lang.Math;

import noise.Noise;

public class HandLine implements Drawable {
  private double x0, y0, x1, y1, startNoise, endNoise, ctrlNoise;
  private Color c;

  public HandLine(double x0, double y0, double x1, double y1, Color c) {
    this.x0 = x0;
    this.y0 = y0;
    this.x1 = x1;
    this.y1 = y1;
    this.c = c;
    this.startNoise = Noise.getNoise();
    this.endNoise = Noise.getNoise();
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

  // Méthode de rendu :
  public void draw(Graphics2D screen) {
    this.ctrlNoise = Noise.getNoise(this.getLength());
    double ctrlx = (x0 + x1) / 2;
    double ctrly = (y0 + y1) / 2;
    screen.setColor(c);
    screen.draw(new QuadCurve2D.Double(x0 + this.startNoise, y0 + this.startNoise, ctrlx + this.ctrlNoise,
        ctrly + this.ctrlNoise, x1 + this.endNoise, y1 + this.endNoise));
  }
}
