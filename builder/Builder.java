package builder;

import shapes.AbstractShapeFactory;
import shapes.Drawable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Builder implements IBuilder {

  private AbstractShapeFactory factory;
  private String contextShape;

  List<Drawable> shapes = new ArrayList<Drawable>();

  // line attributs
  private double lineX0;
  private double lineY0;
  private double lineX1;
  private double lineY1;
  private Color lineColor;

  // rectangle attributs
  private double rectangleX0;
  private double rectangleY0;
  private double rectangleX1;
  private double rectangleY1;
  private Color rectangleColor;

  // circle attributs
  private double circleCX;
  private double circleCY;
  private double circleRad;
  private Color circleColor;

  public Builder(AbstractShapeFactory factory) {
    this.factory = factory;
  }

  public void setContextShape(String contextShape) {
    this.contextShape = contextShape;
  }

  public void clearAttribut() {
    this.circleCX = 0.0;
    this.circleCY = 0.0;
    this.circleRad = 0.0;
    this.circleColor = null;

    this.lineX0 = 0.0;
    this.lineY0 = 0.0;
    this.lineX1 = 0.0;
    this.lineY1 = 0.0;
    this.lineColor = null;

    this.rectangleX0 = 0.0;
    this.rectangleY0 = 0.0;
    this.rectangleX1 = 0.0;
    this.rectangleY1 = 0.0;
    this.rectangleColor = null;
  }

  public String getContextShape() {
    return contextShape;
  }

  // mehtode de construction associé aux lignes

  @Override
  public void buildLineX0(double x0) {
    this.lineX0 = x0;
  }

  @Override
  public void buildLineY0(double y0) {
    this.lineY0 = y0;
  }

  @Override
  public void buildLineX1(double x1) {
    this.lineX1 = x1;
  }

  @Override
  public void buildLineY1(double y1) {
    this.lineY1 = y1;
  }

  @Override
  public void buildLineColor(Color c) {
    this.lineColor = c;
  }

  // methode de construction associé aux rectangles
  @Override
  public void buildRectangleX0(double x0) {
    this.rectangleX0 = x0;
  }

  @Override
  public void buildRectangleY0(double y0) {
    this.rectangleY0 = y0;
  }

  @Override
  public void buildRectangleX1(double x1) {
    this.rectangleX1 = x1;
  }

  @Override
  public void buildRectangleY1(double y1) {
    this.rectangleY1 = y1;
  }

  @Override
  public void buildRectangleColor(Color c) {
    this.rectangleColor = c;
  }

  // methode de construction associé aux cercles
  @Override
  public void buildCircleCX(double cx) {
    this.circleCX = cx;
  }

  @Override
  public void buildCircleCY(double cy) {
    this.circleCY = cy;
  }

  @Override
  public void buildCircleRad(double rad) {
    this.circleRad = rad;
  }

  @Override
  public void buildCircleColor(Color c) {
    this.circleColor = c;
  }

  public void make() {
    switch (this.contextShape) {
    case "line":
      this.shapes.add(factory.createLine(this.lineX0, this.lineY0, this.lineX1, this.lineY1, this.lineColor));
      break;
    case "rectangle":
      this.shapes.add(factory.createRectangle(this.rectangleX0, this.rectangleY0, this.rectangleX1, this.rectangleY1,
          this.rectangleColor));
      break;
    case "circle":
      this.shapes.add(factory.createCircle(this.circleCX, this.circleCY, this.circleRad, this.circleColor));
    default:
      break;
    }
  }

  public List<Drawable> getDrawables() {
    return this.shapes;
  }

  // Getter and Setter

  public AbstractShapeFactory getFactory() {
    return factory;
  }

  public void setFactory(AbstractShapeFactory factory) {
    this.factory = factory;
  }

  public double getLineX0() {
    return lineX0;
  }

  public void setLineX0(double lineX0) {
    this.lineX0 = lineX0;
  }

  public double getLineY0() {
    return lineY0;
  }

  public void setLineY0(double lineY0) {
    this.lineY0 = lineY0;
  }

  public double getLineX1() {
    return lineX1;
  }

  public void setLineX1(double lineX1) {
    this.lineX1 = lineX1;
  }

  public double getLineY1() {
    return lineY1;
  }

  public void setLineY1(double lineY1) {
    this.lineY1 = lineY1;
  }

  public Color getLineColor() {
    return lineColor;
  }

  public void setLineColor(Color lineColor) {
    this.lineColor = lineColor;
  }

  public double getRectangleX0() {
    return rectangleX0;
  }

  public void setRectangleX0(double rectangleX0) {
    this.rectangleX0 = rectangleX0;
  }

  public double getRectangleY0() {
    return rectangleY0;
  }

  public void setRectangleY0(double rectangleY0) {
    this.rectangleY0 = rectangleY0;
  }

  public double getRectangleX1() {
    return rectangleX1;
  }

  public void setRectangleX1(double rectangleX1) {
    this.rectangleX1 = rectangleX1;
  }

  public double getRectangleY1() {
    return rectangleY1;
  }

  public void setRectangleY1(double rectangleY1) {
    this.rectangleY1 = rectangleY1;
  }

  public Color getRectangleColor() {
    return rectangleColor;
  }

  public void setRectangleColor(Color rectangleColor) {
    this.rectangleColor = rectangleColor;
  }

  public double getCircleCX() {
    return circleCX;
  }

  public void setCircleCX(double circleCX) {
    this.circleCX = circleCX;
  }

  public double getCircleCY() {
    return circleCY;
  }

  public void setCircleCY(double circleCY) {
    this.circleCY = circleCY;
  }

  public double getCircleRad() {
    return circleRad;
  }

  public void setCircleRad(double circleRad) {
    this.circleRad = circleRad;
  }

  public Color getCircleColor() {
    return circleColor;
  }

  public void setCircleColor(Color circleColor) {
    this.circleColor = circleColor;
  }
}
