package viewer;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import shapes.Shape;
import visitor.ConcretVisitorGraphic;
import visitor.ConcreteVisitorGraphicHorizontalMirror;
import visitor.Visitor;

public class GraphicViewer extends JFrame implements ActionListener {
	private final int width = 800;
	private final int height = 600;
	private Graphics2D onscreen;
	private int menuWidth = 100;
	private JButton horizontaleButton;
	private Visitor horizontaleVisitor = new ConcreteVisitorGraphicHorizontalMirror();

	private List<Shape> shapes;

	public GraphicViewer() {
		setVisible(true);
		setSize(width + menuWidth, height);
		setTitle("Afficheur de dessin");
		shapes = new ArrayList<Shape>();

		Builder builder = new Builder(noisyShape);
		Director director = new Director(builder);
		director.construct("./drawing.xml");
		GraphicViewer gv = new GraphicViewer();
		List<Shape> demo = builder.getDrawables();
		gv.draw(demo, graphicVisitor);

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
			for (Shape shape : this.shapes) {
				shape.accept(this.horizontaleVisitor);
			}
			repaint(100);

		});

		menu.setBackground(Color.lightGray);
		menu.setPreferredSize(new Dimension(menuWidth, menuWidth));
		getContentPane().add(menu, BorderLayout.WEST);

		getContentPane().add(draw, BorderLayout.CENTER);
		menu.add(horizontaleButton, BorderLayout.CENTER);
		onscreen = onscreenImage.createGraphics();

		// Closing any view will quit :
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void draw(List<Shape> shapes, Visitor visitor) {
		// Shape line = new Line(2);
		// line.accept(vRed);
		// line.move();
		// line.accept(vRed);
		// line.accept(vBlue);
		this.shapes = shapes;
		visitor.setScreen(onscreen);

		for (Shape shape : shapes) {
			shape.accept(visitor);
		}
		repaint(100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if (e.getSource() == horizontaleButton) {
		// System.out.println("wow");
		// for (Shape shape : this.shapes) {
		// shape.accept(this.horizontaleVisitor);
		// }
		// repaint(100);
		// }
	}

}
