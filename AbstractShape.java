package hw4;
import java.awt.*;

/**
 * An AbstractPiece is the super class for shape instances
 *
 * @author Juan.Arias
 *
 */

public abstract class AbstractShape implements Shape {
	
	protected Shape[] children;
	protected String colorName;
	protected Color color;
	protected int x, y, size;

	
	/**
	 * constructor to initialize fields common to all shapes
	 * 
	 * @param x
	 * 			X coordinate
	 * @param y
	 * 			Y coordinate
	 * @param c
	 * 			Color
	 */
	public AbstractShape(int x, int y, Color c, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = c;
		this.colorName = getColorName(color.getRGB() );
	}
	
	/**
	 * Starts by setting the color,
	 * rest to be overridden by shape classes
	 * 
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
	}

	/**
	 * Adds level to current shape if able to
	 * 
	 * @return
	 * 			boolean of whether level can be added or not
	 * 
	 */
	public boolean addLevel() {
		if (children[0] == null) {
			createChildren();
			return true;
		}
		boolean b = false;
		for (Shape s: children) {
			b = s.addLevel();
		}
		return b;
	}

	/**
	 * Removes one level of current shape if able to
	 * 
	 * @return
	 * 			boolean of whether level can be removed or not
	 */
	public boolean removeLevel() {
		if (children[0] == null) {
			return false;
		} 
		AbstractShape first = (AbstractShape) children[0];
		if(first.children[0] == null) {
			for (int i = 0; i < children.length; i++) {
				children[i] = null;
			}
			return true;
		}
		for (Shape child: children) {
			child.removeLevel();
		}
		return true;
	}
	
	/**
	 * String representation with class, location, color, size and level
	 * 
	 */
	public String toString() {
		return String.format("%s \nlocation: [%d, %d] \ncolor: %s  \nsize: %d  \nlevel: %d\n", this.getClass(), x, y, colorName, size, getLevel());
	}
	
	/**
	 * Gets the level of Shape
	 * 
	 * @return
	 * 			The current level of Shape
	 * 
	 */
	public int getLevel() {
		if (children[0] == null) {
			return 1;
		}
		AbstractShape first = (AbstractShape) children[0];
		if(first.children[0] == null) {
			return 2;
		}
		return 1 + children[0].getLevel();
	}
	
	/**
	 * 
	 * Returns Color as String
	 * 
	 * @param c
	 * 			The Color
	 * @return
	 * 			String version of Color
	 */
	private String getColorName(int c) {
		switch(c) {
		case -16777216:
			return "BLACK";
		case -16776961:
			return "BLUE";
		case -65536:
			return "RED";
		case -16711936:
			return "GREEN";
		case -256:
			return "YELLOW";
		case -14336:
			return "ORANGE";
		case -8355712:
			return "GRAY";
		case -65281:
			return "MAGENTA";
		case -16711681:
			return "CYAN";
		case -12566464:
			return "DARK_GRAY";
		case -4144960:
			return "LIGHT_GRAY";
		case -20561:
			return "PINK";
		default:     //WHITE
			return "WHITE";
		}
	}

}
