package hw4;
import java.awt.Color;
import javax.swing.*;

/**
 * MainClass creates the Model, Views and Controller to run the GUI
 * 
 * @author Juan
 *
 */
public class MainClass {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			
			createGUI();
		});
	}
	
	/**
	 * Does some ish hoe
	 */
	private static void createGUI() {
		
		//create display frame
		JFrame frame = new JFrame("Homework 3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400, 800);

		// create the model and views, attach to each other
		DrawingModel model = new DrawingModel();
		Viewer vPanel = new Viewer();
		model.addView(vPanel);
		frame.add(vPanel);
		frame.setVisible(true);
		
		
		//reset button
		JButton reset = new JButton("Reset");
		vPanel.add(reset);
		
		//increase/decrease JRadio buttons
		ButtonGroup group = new ButtonGroup();;
		JRadioButton increase = new JRadioButton("increase");
		JRadioButton decrease = new JRadioButton("decrease");
		group.add(increase);
		group.add(decrease);
		vPanel.add(increase);
		vPanel.add(decrease);
		
		//create controller
		MouseLeveler leveler = new MouseLeveler(model, increase, decrease);
		reset.addMouseListener(leveler);
		vPanel.addMouseListener(leveler);
		
		
		// create the Shapes and add to model
		Shape pr = new FibonacciSquare(1050, 510, Color.BLUE, 1, 1);
		model.addShape(pr);
	
		Shape[] hs = {new HShape(50, 510, Color.green, 210),
						new HShape(50, 260, Color.yellow, 210),
						new HShape(50, 10, Color.red, 210)};
		for (Shape h: hs) {
			model.addShape(h);
		}
		
		//add TextViewer to model
		View text = new TextViewer();
		model.addView(text);
	}
}








