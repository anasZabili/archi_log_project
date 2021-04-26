package client;

import java.awt.Color;
import java.util.*;

import builder.Builder;
import builder.Director;
import builder.XMLShapeLoader;
import shapes.*;
import viewer.GraphicViewer;
import visitor.ConcretVisitorGraphic;
import visitor.Visitor;

public class Test {

	private static AbstractShapeFactory noisyShape = new NoisyShapeFactory();

	private static Visitor graphicVisitor = new ConcretVisitorGraphic();

	public static java.util.List<Drawable> getDemo() {

		java.util.List<Drawable> ls = new ArrayList<Drawable>();
		ls.add(noisyShape.createLine(0, 500, 800, 500, Color.GREEN));
		ls.add(noisyShape.createLine(300, 0, 0, 300, Color.YELLOW));

		ls.add(noisyShape.createLine(30, 300, 180, 200, Color.BLUE));
		ls.add(noisyShape.createLine(330, 300, 180, 200, Color.BLUE));
		ls.add(noisyShape.createRectangle(30, 300, 330, 500, Color.RED));

		double sunX = 600;
		double sunY = 120;
		double sunRad = 60;
		ls.add(noisyShape.createCircle(sunX, sunY, sunRad, Color.BLACK));
		int sunRay = 20;
		for (int i = 0; i < sunRay; ++i) {
			double tau = i * 2 * Math.PI / sunRay;
			ls.add(noisyShape.createLine(sunX + (sunRad + 5) * Math.cos(tau), sunY - (sunRad + 5) * Math.sin(tau),
					sunX + (1.5 * sunRad + 5) * Math.cos(tau), sunY - (1.5 * sunRad + 5) * Math.sin(tau), Color.BLACK));
		}

		double manX = 600;
		double manY = 450;
		ls.add(noisyShape.createLine(manX, manY - 70, manX - 40, manY - 110, Color.RED));
		ls.add(noisyShape.createLine(manX, manY - 70, manX + 40, manY - 110, Color.RED));
		ls.add(noisyShape.createCircle(manX, manY - 120, 20, Color.GRAY));
		ls.add(noisyShape.createLine(manX, manY, manX, manY - 100, Color.BLUE));
		ls.add(noisyShape.createLine(manX, manY, manX - 20, manY + 50, Color.BLACK));
		ls.add(noisyShape.createLine(manX, manY, manX + 20, manY + 50, Color.BLACK));

		return ls;
	}

	public static java.util.List<Drawable> getDemoGroups() {
		SubPicture houseSubPicture = new SubPicture();

		java.util.List<Drawable> ls = new ArrayList<Drawable>();
		houseSubPicture.addPicture(noisyShape.createLine(0, 500, 800, 500, Color.GREEN));
		houseSubPicture.addPicture(noisyShape.createLine(300, 0, 0, 300, Color.YELLOW));

		houseSubPicture.addPicture(noisyShape.createLine(30, 300, 180, 200, Color.BLUE));
		houseSubPicture.addPicture(noisyShape.createLine(330, 300, 180, 200, Color.BLUE));
		houseSubPicture.addPicture(noisyShape.createRectangle(30, 300, 330, 500, Color.RED));
		ls.add(houseSubPicture);

		SubPicture sunSubPicture = new SubPicture();
		double sunX = 600;
		double sunY = 120;
		double sunRad = 60;
		sunSubPicture.addPicture(noisyShape.createCircle(sunX, sunY, sunRad, Color.BLACK));
		int sunRay = 20;
		for (int i = 0; i < sunRay; ++i) {
			double tau = i * 2 * Math.PI / sunRay;
			sunSubPicture
					.addPicture(noisyShape.createLine(sunX + (sunRad + 5) * Math.cos(tau), sunY - (sunRad + 5) * Math.sin(tau),
							sunX + (1.5 * sunRad + 5) * Math.cos(tau), sunY - (1.5 * sunRad + 5) * Math.sin(tau), Color.BLACK));
		}
		ls.add(sunSubPicture);

		SubPicture stickManSubPicture = new SubPicture();

		double manX = 600;
		double manY = 450;
		stickManSubPicture.addPicture(noisyShape.createLine(manX, manY - 70, manX - 40, manY - 110, Color.RED));
		stickManSubPicture.addPicture(noisyShape.createLine(manX, manY - 70, manX + 40, manY - 110, Color.RED));
		stickManSubPicture.addPicture(noisyShape.createCircle(manX, manY - 120, 20, Color.GRAY));
		stickManSubPicture.addPicture(noisyShape.createLine(manX, manY, manX, manY - 100, Color.BLUE));
		stickManSubPicture.addPicture(noisyShape.createLine(manX, manY, manX - 20, manY + 50, Color.BLACK));
		stickManSubPicture.addPicture(noisyShape.createLine(manX, manY, manX + 20, manY + 50, Color.BLACK));

		ls.add(stickManSubPicture);

		// mouvement du bonhome
		stickManSubPicture.move(-400, 0);
		return ls;
	}

	// public static void main(String[] args) {
	// GraphicViewer gv = new GraphicViewer();
	// java.util.List<Drawable> demo = getDemoGroups();
	// gv.draw(demo, graphicVisitor);

	// }

	public static void main(String[] args) {
		Builder builder = new Builder(noisyShape);
		Director director = new Director(builder);
		director.construct("./pencil.xml");
		GraphicViewer gv = new GraphicViewer();
		List<Drawable> demo = builder.getDrawables();
		gv.draw(demo, graphicVisitor);
	}

}
