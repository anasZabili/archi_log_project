package shapes;

import java.awt.Color;
import noise.Noise;

public class NoisyShapeFactory implements AbstractShapeFactory {

  @Override
  public Drawable createCircle(double cx, double cy, double rad, Color c) {
    return new HandCircle(cx, cy, rad, c);

  }

  @Override
  public Drawable createRectangle(double x0, double y0, double x1, double y1, Color c) {
    return new HandRectangle(x0, y0, x1, y1, c);

  }

  @Override
  public Drawable createLine(double x0, double y0, double x1, double y1, Color c) {
    return new HandLine(x0, y0, x1, y1, c);
  }
}
