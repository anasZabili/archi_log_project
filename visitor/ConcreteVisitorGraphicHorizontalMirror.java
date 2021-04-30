package visitor;

import java.awt.*;
import java.awt.geom.*;

import noise.Noise;
import shapes.Circle;
import shapes.Shape;
import shapes.HandCircle;
import shapes.HandLine;
import shapes.HandRectangle;
import shapes.Line;
import shapes.Rectangle;
import shapes.SubPicture;

public class ConcreteVisitorGraphicHorizontalMirror implements Visitor {

  private Graphics2D screen;
  private static final int windowHeight = 600;

  public Graphics2D getScreen() {
    return screen;
  }

  public void setScreen(Graphics2D screen) {
    this.screen = screen;
  }

  @Override
  public void draw(Rectangle rectangle) {
    double x0 = rectangle.getX0();
    double y0 = rectangle.getY0() - rectangle.getHeight();
    double x1 = rectangle.getX1();
    double y1 = rectangle.getY1() - rectangle.getHeight();
    Color color = rectangle.getC();

    screen.setColor(color);
    screen.draw(new Rectangle2D.Double(x0, y0, x1 - x0, y1 - y0));

  }

  @Override
  public void draw(Line line) {
    double x0 = line.getX0();
    double y0 = windowHeight - line.getY0();
    double x1 = line.getX1();
    double y1 = windowHeight - line.getY1();
    Color color = line.getC();

    screen.setColor(color);
    screen.draw(new Line2D.Double(x0, y0, x1, y1));

  }

  @Override
  public void draw(Circle circle) {
    double rad = circle.getRad();
    double cx = circle.getCx();
    double cy = windowHeight - circle.getCy();
    Color color = circle.getC();

    screen.setColor(color);
    screen.draw(new Ellipse2D.Double(cx - rad, cy - rad, rad * 2, rad * 2));
  }

  @Override
  public void draw(HandRectangle rectangle) {
    double x0 = rectangle.getX0();
    double y0 = rectangle.getY0();
    double x1 = rectangle.getX1();
    double y1 = rectangle.getY1();
    Color color = rectangle.getC();

    screen.setColor(color);
    HandLine l1 = new HandLine(x0, y0, x1, y0, color);
    HandLine l2 = new HandLine(x0, y0, x0, y1, color);
    HandLine l3 = new HandLine(x0, y1, x1, y1, color);
    HandLine l4 = new HandLine(x1, y0, x1, y1, color);
    l1.accept(this);
    l2.accept(this);
    l3.accept(this);
    l4.accept(this);
  }

  @Override
  public void draw(HandLine line) {
    double x0 = line.getX0();
    double y0 = windowHeight - line.getY0();
    double x1 = line.getX1();
    double y1 = windowHeight - line.getY1();
    Color color = line.getC();
    double startNoise = line.getStartNoise();
    double endNoise = line.getEndNoise();
    double ctrlNoise = line.getCtrlNoise();

    line.setCtrlNoise(Noise.getNoise(line.getLength()));
    double ctrlx = (x0 + x1) / 2;
    double ctrly = (y0 + y1) / 2;
    screen.setColor(color);
    screen.draw(new QuadCurve2D.Double(x0 + startNoise, y0 + startNoise, ctrlx + ctrlNoise, ctrly + ctrlNoise,
        x1 + endNoise, y1 + endNoise));

  }

  @Override
  public void draw(SubPicture subPicture) {
    for (Shape Shape : subPicture.getPicturesTab()) {
      Shape.accept(this);
    }
  }

  @Override
  public void draw(HandCircle circle) {
    double rad = circle.getRad();
    double cx = circle.getCx();
    double cy = windowHeight - circle.getCy();
    double noiseRayX = circle.getNoiseRayX();
    double noiseRayY = circle.getNoiseRayY();
    Color color = circle.getC();

    screen.setColor(color);
    screen.draw(new Ellipse2D.Double(cx - rad, cy - rad, noiseRayX, noiseRayY));

  }

}
