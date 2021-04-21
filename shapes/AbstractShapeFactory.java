package shapes;

import java.awt.*;

public interface AbstractShapeFactory {
  public Drawable createCircle(double cx, double cy, double rad, Color c);

  public Drawable createRectangle(double x0, double y0, double x1, double y1, Color c);

  public Drawable createLine(double x0, double y0, double x1, double y1, Color c);
}
