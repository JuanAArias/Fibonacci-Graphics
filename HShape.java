package hw4;

import java.awt.*;

/**
 * A HShape is a square consisting of 9 squares,
 * 7 are filled in with color and 2 are left blank to create an H
 * 
 * @author Juan.Arias
 *
 */
public class HShape extends AbstractShape {
	
	/**
	 * Creates a HShape with the given location, color and size
	 * 
	 * @param x
	 * 			The x coordinate of the topleft of the H
	 * @param y
	 * 			The y coordinate of the topleft of the H
	 * @param c
	 * 			The color of the H
	 * @param size	
	 *			The length & height of the H
	 *
	 */
	public HShape(int x, int y, Color c, int size) {
		super(x, y, c, size);
		children = new HShape[7];
	}
	
	/**
	 * Draws the HShape
	 * 
	 * @param g
	 * 			The Graphics context to use
	 */
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		if (children[0] == null) {
			//size for each square
			int s3 = (int)(size/3.0);
			
			//top row
			g.fillRect(x, y, s3, s3); //1
			g.fillRect(x + (s3*2), y, s3, s3); //3
			
			//middle row
			g.fillRect(x, y + s3, s3, s3); //4
			g.fillRect(x + s3, y + s3, s3, s3); //5
			g.fillRect(x + (s3*2), y + s3, s3, s3); //6
			
			//bottom row
			g.fillRect(x, y + (2*s3), s3, s3); //7
			g.fillRect(x + (s3*2), y + (2*s3), s3, s3); //9
		} else {
			for (Shape child: children) {
				if (child != null) {
					child.draw(g);
				}
			}
		}
	}
	
	
	/**
	 * 
	 * 
	 */
	public void createChildren() {
		int s3 = (int)(size/3.0);
		for (int i = 0, newX = x; i < 2; i++ , newX += s3*2) { //top row
			children[i] = new HShape(newX, y, color, s3);
		}
		for (int i = 2, newX = x; i < 5; i++, newX += s3) { //middle row
			children[i] = new HShape(newX, y + s3, color, s3);
		}
		for (int i = 5, newX = x; i < 7; i++, newX += s3*2) { //bottom row
			children[i] = new HShape(newX, y + (s3*2), color, s3);
		}
	}
}
