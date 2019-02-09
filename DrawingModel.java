package hw4;

import java.util.ArrayList;
import java.util.List;
import hw4.Shape;

/**
 * Holds the state of the drawing
 * 
 * @author Juan.Arias
 *
 */
public class DrawingModel {
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<View> views = new ArrayList<View>();
	
	/**
	 * Connects given View to model
	 * @param v The View to be added
	 */
	public void addView(View v) {
		views.add(v);
		v.update(this);
	}

	/**
	 * Updates all views
	 */
	public void updateAll() {
		for(View v: views) {
			v.update(this);
		}
	}
	
	/**
	 * Adds a square to the list of squares
	 */
	public void addShape(Shape s) {
		shapes.add(s);
		updateAll();
	}

	/**
	 * Returns the list of the shapes
	 */
	public List<Shape> getShapes() {
		return shapes;
	}

	/**
	 * Adds levels to shapes if possible
	 * 
	 * @return
	 * 			boolean of whether levels were added or not
	 */
	public boolean addLevel(Shape shape) {
		boolean b = shape.addLevel();
		updateAll();
		return b;
	}

	/**
	 * Removes levels to shapes if possible
	 * 
	 * @return
	 * 			boolean of whether levels were removed or not
	 */
	public boolean removeLevel(Shape shape) {
		boolean b = shape.removeLevel();
		updateAll();
		return b;
	}

	/**
	 * Resets levels of all Shapes
	 * 
	 */
	public void reset() {
		boolean b = false;
		for (Shape s: shapes) {
			b = removeLevel(s);
			while (b) {
				b = removeLevel(s);
			}
		}
	}


}





