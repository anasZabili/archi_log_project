package visitor;

import java.awt.*;
import java.awt.geom.*;
import shapes.*;
import shapes.Rectangle;

public interface Visitor {

  public void setScreen(Graphics2D screen);

  public void draw(Rectangle rectangle);

  public void draw(Line line);

  public void draw(Circle circle);

  public void draw(HandRectangle rectangle);

  public void draw(HandLine line);

  public void draw(HandCircle circle);

  public void draw(SubPicture circle);

}
