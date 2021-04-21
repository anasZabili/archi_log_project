package builder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

import shapes.AbstractShapeFactory;
import org.xml.sax.*;

public class XMLShapeLoader {
  private IBuilder builder;
  private AbstractShapeFactory factory;

  public XMLShapeLoader(IBuilder builder, AbstractShapeFactory factory) {
    this.builder = builder;
    this.factory = factory;
  }

  public static void load(String XMLFileName, Builder mb)
      throws ParserConfigurationException, org.xml.sax.SAXException, FileNotFoundException {
    InputSource is = new InputSource(new BufferedInputStream(new FileInputStream(XMLFileName)));
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser sp = spf.newSAXParser();
    XMLReader xr = sp.getXMLReader();
    HandlerImpl handler = new HandlerImpl(mb);
    xr.setContentHandler(handler);
    xr.setErrorHandler(handler);
    try {
      xr.parse(is);
    } catch (Exception e) {
      System.out.println(" " + e);
    }
  }

}
