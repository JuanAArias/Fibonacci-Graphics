package hw4;

import java.awt.Graphics;

/**
 * Interface for shape implementations
 * 
 */
public interface Shape {
	void draw(Graphics g);
	void createChildren();
	boolean addLevel();
	boolean removeLevel();
	int getLevel();
}
