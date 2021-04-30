package builder;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

class HandlerImpl extends DefaultHandler implements ContentHandler, ErrorHandler {
  private List<String> stack;
  Builder builder;

  public HandlerImpl(Builder builder) {
    this.builder = builder;
  }

  public void characters(char[] ch, int start, int length) throws SAXException {
    String buf = new String(ch, start, length);
    int stackSize = this.stack.size() - 1;
    String top = stack.get(stackSize).trim();

    if ("radius".equals(top)) {
      builder.buildCircleRad(Integer.parseInt(buf));
    }
    // if ("titre".equals(top))
    // else if ("texte".equals(top))
    // mb.setText(buf);
    // else if ("de".equals(top))
    // mb.setFrom(buf);
    // else if ("à".equals(top))
    // mb.setTo(buf);
  }

  public void endDocument() throws SAXException {
    stack.clear();
  }

  public void endElement(String uri, String localName, String qName) throws SAXException {
    switch (qName) {
      case "rectangle":
        this.builder.make();
        break;
      case "line":
        this.builder.make();
        break;
      case "circle":
        this.builder.make();
        break;
      default:
        break;
    }
    int stackSize = this.stack.size() - 1;

    this.stack.remove(stackSize);
  }

  public void startDocument() {
    stack = new ArrayList<>();
  }

  public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
    switch (qName) {
      case "rectangle":
        builder.clearAttribut();
        builder.setContextShape(qName);

        builder.setRectangleColor(this.getColorFromString(atts.getValue(0)));
        break;
      case "line":
        builder.clearAttribut();
        builder.setContextShape(qName);
        builder.setLineColor(this.getColorFromString(atts.getValue(0)));

        break;
      case "circle":
        builder.clearAttribut();
        builder.setContextShape(qName);
        builder.setCircleColor(this.getColorFromString(atts.getValue(0)));

        break;
      case "point":
        // traitement des point du rectangle
        if (builder.getContextShape().equals("rectangle") && builder.getRectangleX0() == 0.0) {
          builder.buildRectangleX0(Integer.parseInt(atts.getValue(0)));
          builder.buildRectangleY0(Integer.parseInt(atts.getValue(1)));
        } else if (builder.getContextShape().equals("rectangle") && builder.getRectangleX0() != 0.0) {
          builder.buildRectangleX1(Integer.parseInt(atts.getValue(0)));
          builder.buildRectangleY1(Integer.parseInt(atts.getValue(1)));
        }
        // traitement des point de la ligne
        if (builder.getContextShape().equals("line") && builder.getLineX0() == 0.0) {
          builder.buildLineX0(Integer.parseInt(atts.getValue(0)));
          builder.buildLineY0(Integer.parseInt(atts.getValue(1)));
        } else if (builder.getContextShape().equals("line") && builder.getLineX0() != 0.0) {
          builder.buildLineX1(Integer.parseInt(atts.getValue(0)));
          builder.buildLineY1(Integer.parseInt(atts.getValue(1)));
        }
        // traitement des point du cercle
        if (builder.getContextShape().equals("circle") && builder.getCircleCX() == 0.0) {
          builder.buildCircleCX(Integer.parseInt(atts.getValue(0)));
          builder.buildCircleCY(Integer.parseInt(atts.getValue(1)));
        }
        break;
      case "radius":
        // if (builder.getContextShape().equals("circle") && builder.getCircleCX() ==
        // 0.0) {
        // builder.buildCircleRad(Integer.parseInt(atts.getValue(0)));
        // }
        break;
      default:
        break;
    }
    stack.add(qName);
  }

  // Utile
  public Color getColorFromString(String color) {
    switch (color) {
      case "black":
        return Color.BLACK;
      case "blue":
        return Color.BLUE;
      case "red":
        return Color.RED;
      case "yellow":
        return Color.YELLOW;
      case "grey":
        return Color.GRAY;
      case "green":
        return Color.GREEN;
      default:
        return Color.BLACK;
    }
  }
}