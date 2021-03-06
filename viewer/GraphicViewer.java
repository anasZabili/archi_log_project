package viewer;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import builder.Builder;
import builder.Director;
import shapes.AbstractShapeFactory;
import shapes.NoisyShapeFactory;
import shapes.PerfectShapeFactory;
import shapes.Shape;
import visitor.ConcretVisitorGraphic;
import visitor.ConcreteVisitorGraphicHorizontalMirror;
import visitor.Visitor;

public class GraphicViewer extends JFrame {
	private final int width = 800;
	private final int height = 600;
	private Graphics2D onscreen;
	private int menuWidth = 100;
	private JButton horizontaleButton;
	private JButton drawPencilButton;
	private JButton drawDrawingButton;
	private JButton drawHouseButton;
	private JButton changeShapeTypeButton;
	// private JButton noisyShapeButton;
	private Visitor horizontaleVisitor = new ConcreteVisitorGraphicHorizontalMirror();
	private Visitor graphicVisitor = new ConcretVisitorGraphic();
	private AbstractShapeFactory shapeFactory;
	private Visitor currentVisitor;

	// current shape est l'attribut correspondant aux dessin actuellemnt dessinĂ©
	private List<Shape> currentShape;
	// private AbstractShapeFactory noisyShape = new NoisyShapeFactory();
	// private AbstractShapeFactory perfectShape = new PerfectShapeFactory();

	private List<Shape> shapes;

	public GraphicViewer() {
		setVisible(true);
		setSize(width + menuWidth, height);
		setTitle("Afficheur de dessin");
		shapes = new ArrayList<Shape>();
		this.shapeFactory = new PerfectShapeFactory();
		this.currentVisitor = this.graphicVisitor;
		this.horizontaleVisitor.setScreen(onscreen);
		this.graphicVisitor.setScreen(onscreen);

		BufferedImage onscreenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		ImageIcon icon = new ImageIcon(onscreenImage);
		JLabel draw = new JLabel(icon);
		JPanel menu = new JPanel();

		// Bouton perfomant l'action horizontale sur le dessin
		horizontaleButton = new JButton("Mirroir");
		horizontaleButton.addActionListener(e -> {

			// onscreen.setColor(Color.BLUE);
			onscreen.setBackground(Color.WHITE);
			onscreen.fillRect(0, 0, width, height);
			this.horizontaleVisitor.setScreen(onscreen);
			onscreen.clearRect(0, 0, width, height);
			for (Shape shape : this.currentShape) {
				shape.accept(this.horizontaleVisitor);
			}
			repaint(100);

		});

		// Bouton de dessin du style a partir du fichier xml
		drawPencilButton = new JButton("dessiner stylo");
		drawPencilButton.addActionListener(e -> {
			onscreen.setBackground(Color.WHITE);
			onscreen.fillRect(0, 0, width, height);
			this.graphicVisitor.setScreen(onscreen);
			onscreen.clearRect(0, 0, width, height);
			drawShapeFromXmlFile("pencil.xml", this.currentVisitor);
			repaint(100);
		});

		// Bouton de dessin de la forme Ă  partir du fichier xml
		drawDrawingButton = new JButton("dessiner forme");
		drawDrawingButton.addActionListener(e -> {
			onscreen.setBackground(Color.WHITE);
			onscreen.fillRect(0, 0, width, height);
			this.graphicVisitor.setScreen(onscreen);
			onscreen.clearRect(0, 0, width, height);
			drawShapeFromXmlFile("drawing.xml", this.currentVisitor);
			repaint(100);
		});

		// Bouton de dessin de la maison Ă  partir du fichier xml
		drawHouseButton = new JButton("dessiner maison");
		drawHouseButton.addActionListener(e -> {
			onscreen.setBackground(Color.WHITE);
			onscreen.fillRect(0, 0, width, height);
			this.graphicVisitor.setScreen(onscreen);
			onscreen.clearRect(0, 0, width, height);
			drawShapeFromXmlFile("house.xml", this.currentVisitor);
			repaint(100);
		});

		// Bouton en charge du changement de type de dessin
		changeShapeTypeButton = new JButton("main");
		changeShapeTypeButton.addActionListener(e -> {
			if (this.shapeFactory instanceof NoisyShapeFactory) {
				this.changeShapeTypeButton.setText("main");
				this.shapeFactory = new PerfectShapeFactory();
			} else {
				this.changeShapeTypeButton.setText("perfect");
				this.shapeFactory = new NoisyShapeFactory();
			}
			// onscreen.setBackground(Color.WHITE);
			// onscreen.fillRect(0, 0, width, height);
			// this.graphicVisitor.setScreen(onscreen);
			// onscreen.clearRect(0, 0, width, height);
			// drawShapeFromXmlFile("house.xml", this.graphicVisitor, this.shapeFactory);
			// repaint(100);
		});

		menu.setBackground(Color.lightGray);
		menu.setPreferredSize(new Dimension(menuWidth, menuWidth));
		getContentPane().add(menu, BorderLayout.WEST);

		getContentPane().add(draw);
		menu.add(horizontaleButton);
		menu.add(drawPencilButton);
		menu.add(drawDrawingButton);
		menu.add(drawHouseButton);
		menu.add(changeShapeTypeButton);
		onscreen = onscreenImage.createGraphics();

		// Closing any view will quit :
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void draw(List<Shape> shapes, Visitor visitor) {
		this.shapes = shapes;
		visitor.setScreen(onscreen);

		for (Shape shape : shapes) {
			shape.accept(visitor);
		}
		repaint(100);
	}

	private void drawShapeFromXmlFile(String file, Visitor visitor) {
		Builder builder = new Builder(this.shapeFactory);
		Director director = new Director(builder);
		director.construct(file);
		// List<Shape> demo = builder.getDrawables();
		this.currentShape = builder.getDrawables();
		for (Shape shape : this.currentShape) {
			shape.accept(visitor);
		}
	}

	private void drawCurrentShape(Visitor visitor) {
		for (Shape shape : this.currentShape) {
			shape.accept(visitor);
		}
	}

}
