package builder;

import java.awt.Color;

public interface IBuilder {
  // méthode de construction associé aux ligne
  public void buildLineX0(double x0);

  public void buildLineY0(double y0);

  public void buildLineX1(double x1);

  public void buildLineY1(double y1);

  public void buildLineColor(Color c);

  // methode de construction associé aux rectangle

  public void buildRectangleX0(double x0);

  public void buildRectangleY0(double y0);

  public void buildRectangleX1(double x1);

  public void buildRectangleY1(double y1);

  public void buildRectangleColor(Color c);

  // methode de construction associé aux cercle
  public void buildCircleCX(double cx);

  public void buildCircleCY(double cy);

  public void buildCircleRad(double rad);

  public void buildCircleColor(Color c);

}
