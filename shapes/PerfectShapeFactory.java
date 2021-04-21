package shapes;

import java.awt.Color;

public class PerfectShapeFactory implements AbstractShapeFactory {

  @Override
  public Circle createCircle(double cx, double cy, double rad, Color c) {
    return new Circle(cx, cy, rad, c);

  }

  @Override
  public Rectangle createRectangle(double x0, double y0, double x1, double y1, Color c) {
    return new Rectangle(x0, y0, x1, y1, c);

  }

  @Override
  public Line createLine(double x0, double y0, double x1, double y1, Color c) {
    return new Line(x0, y0, x1, y1, c);
  }

}
