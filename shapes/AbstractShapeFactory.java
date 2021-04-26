package shapes;

import java.awt.*;

public interface AbstractShapeFactory {
  public Shape createCircle(double cx, double cy, double rad, Color c);

  public Shape createRectangle(double x0, double y0, double x1, double y1, Color c);

  public Shape createLine(double x0, double y0, double x1, double y1, Color c);
}
