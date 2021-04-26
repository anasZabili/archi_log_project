package shapes;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

import visitor.Visitor;

public class SubPicture implements Drawable {
  private List<Drawable> picturesTab;

  public SubPicture() {
    super();
    this.picturesTab = new ArrayList<Drawable>();
  }

  public List<Drawable> getPicturesTab() {
    return picturesTab;
  }

  public void setPicturesTab(List<Drawable> picturesTab) {
    this.picturesTab = picturesTab;
  }

  // Méthodes propres à subPicture :
  public void addPicture(Drawable drawable) {
    this.picturesTab.add(drawable);
  }

  public void move(int dx, int dy) {
    System.out.println("coucou");
    for (Drawable shape : picturesTab) {
      shape.move(dx, dy);
    }
  }

  // méthode de rendu
  // public void draw(Graphics2D screen) {
  // for (Drawable drawable : this.picturesTab) {
  // drawable.draw(screen);
  // }
  // }

  @Override
  public void accept(Visitor v) {
    v.draw(this);
  }
}
