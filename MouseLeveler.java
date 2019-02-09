package hw4;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

/**
 * A MouseLeveler is an Event Handler for mouse clicks
 * 
 * @author Juan
 *
 */
public class MouseLeveler extends MouseAdapter {
	
	//int that represents the divider of the frame
	private static final int DIVIDER = 300;
	
	//maximum FibonacciSpiral level
	private static final int FIBMAX = 10;
	
	//maximum HShape level
	private static final int HMAX = 4;
	
	private DrawingModel model;
	
	// fields for radio buttons allows to see which is selected
	private JRadioButton increase;
	private JRadioButton decrease;
	
	/**
	 * Constructs a MouseLeveler attached to the model
	 * @param model
	 * @param view
	 */
	public MouseLeveler(DrawingModel model, JRadioButton increase, JRadioButton decrease) {
		this.model = model;
		this.increase = increase;
		this.decrease = decrease;
	}
	
	/**
	 * Executes the action for a mouse click for either Shape to increase,
	 * decrease or reset all.
	 * 
	 * @param e The MouseEvent (mouse click) on the screen
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		List<Shape> shapes = model.getShapes();
		Shape fib = shapes.get(0);
		Shape[] hs = {shapes.get(1), shapes.get(2), shapes.get(3)};
		Object o = e.getComponent();
		
		if (o instanceof JButton) {
			model.reset();	
		} else if (e.getX() > DIVIDER && increase.isSelected()) {
			if (fib.getLevel() < FIBMAX) {
			
				model.addLevel(fib); 
			
			} else {
				
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Maximum Spiral level reached");
			
			}
		} else if (e.getX() > DIVIDER && decrease.isSelected()) {
			
			model.removeLevel(shapes.get(0));
		
		} else if (e.getX() < DIVIDER && increase.isSelected()) {
			
			if (hs[0].getLevel() < HMAX) {
				for (Shape h: hs) {
					model.addLevel(h);
				}
			
			} else {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Maximum Spiral level reached");
			}
		} else if (e.getX() < DIVIDER && decrease.isSelected()) {
			
			for (Shape h: hs) {
				model.removeLevel(h);
			}
		}
	}
	
}
