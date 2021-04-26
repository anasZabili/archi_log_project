package shapes;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

import visitor.Visitor;

public class SubPicture implements Shape {
  private List<Shape> picturesTab;

  public SubPicture() {
    super();
    this.picturesTab = new ArrayList<Shape>();
  }

  public List<Shape> getPicturesTab() {
    return picturesTab;
  }

  public void setPicturesTab(List<Shape> picturesTab) {
    this.picturesTab = picturesTab;
  }

  // Méthodes propres à subPicture :
  public void addPicture(Shape Shape) {
    this.picturesTab.add(Shape);
  }

  public void move(int dx, int dy) {
    System.out.println("coucou");
    for (Shape shape : picturesTab) {
      shape.move(dx, dy);
    }
  }

  // méthode de rendu
  // public void draw(Graphics2D screen) {
  // for (Shape Shape : this.picturesTab) {
  // Shape.draw(screen);
  // }
  // }

  @Override
  public void accept(Visitor v) {
    v.draw(this);
  }

  @Override
  public void horizontalMirror() {
    // TODO Auto-generated method stub

  }
}
