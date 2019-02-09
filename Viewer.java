package hw4;

import java.awt.*;
import javax.swing.*;

public class Viewer extends JPanel implements View {

	private static final long serialVersionUID = 1L;
	private DrawingModel model;
	
	/**
	 * Constructor that sets a black background
	 * 
	 */
	public Viewer() {
		setBackground(Color.BLACK);
	}
	
	/**
	 * Updates the the model and redraws new Shapes
	 * 
	 * @param model
	 * 				The DrawingModel attached to this Viewer
	 * 
	 */
	@Override
	public void update(DrawingModel model) {
		this.model = model;
		repaint();
	}

	/**
	 * Draws the Shapes in the DrawingModel
	 * 
	 * @param g
	 * 			The Graphics context to use
	 * 
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw the shapes
		if (model != null) {
			for (Shape s : model.getShapes()) {
				s.draw(g);
			}
		}
	}
}
