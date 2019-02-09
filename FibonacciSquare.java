package hw4;

import java.awt.*;

/**
 * A FibonacciSquare is a square with size F(n) in the Fibonacci sequence &
 * an arc drawn in one of four quadrants
 * 
 * @author Juan.Arias
 *
 */

public class FibonacciSquare extends AbstractShape {
	static final int AMP = 12; //Amplify size to see better
	private int q,n;

	private static int[] fib = new int[100];

	/**
	 * Creates a FibonacciSquare with given location, color, quadrant and nth Fibonacci number
	 * 
	 * @param x
	 *            The x coordinate of the topleft of the square
	 * @param y
	 *            The y coordinate of the topleft of the square
	 * @param c
	 *            The color of the square
	 * @param quadrant
	 *            The quadrant of the arc
	 * @param n
	 *            The nth number in the Fibonacci Sequence
	 */
	public FibonacciSquare(int x, int y, Color c, int n, int quadrant) {
		super(x, y, c, AMP*f(n));
		q = quadrant;
		this.n = n;
		children = new FibonacciSquare[1];
	}

	/**
	 * Draws the FibonacciSquare
	 * 
	 * @param g
	 *            The Graphics context to use
	 */
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawRect(x, y, size, size);
		switch (q) {
		case 1:
			g.drawArc(x-size, y,  2*size,  2*size, 0, 90);
			break;
		case 2:
			g.drawArc(x, y, 2 * size, 2 * size, 90, 90);
			break;
		case 3:
			g.drawArc(x, y-size, 2 * size, 2 * size, 180, 90);
			break;
		default: // 4
			g.drawArc(x - size, y-size, 2 * size, 2 * size, 270, 90);
			break;
		}
		if (children[0] != null) {
			children[0].draw(g);
		}
	}


	/**
	 * Algorithm for calculating F(n) in Fibonacci sequence, used as the length
	 * & height of the square
	 * 
	 * @param n
	 *            The nth number in sequence
	 */
	private static int f(int n) {
		if (fib[n] != 0) {
			return fib[n];
		} else if (n == 1 || n == 2) {
			fib[n] = 1;
			return 1;
		}
		int f = f(n - 1) + f(n - 2);
		fib[n] = f;
		return f;
	}
	
	
	/**
	 * Populates array for next level
	 * calculates fields for spiral coordination
	 * 
	 */
	public void createChildren() {
		children = new FibonacciSquare[1];
		int nextQ = (q < 4) ? q+1 : 1;
		int nextX = x, nextY = y, newN = n +1, newSize = AMP *f(newN);
		switch (nextQ) {
		case 1:
			nextX -= AMP * f(newN-2);
			nextY -= newSize;
			break;
		case 2:
			nextX -= newSize;
			break;
		case 3:
			nextY += size;
			break;
		default: // 4
			nextX += size;
			nextY -= AMP * f(newN-2);
			break;
		}
		children[0] = new FibonacciSquare(nextX, nextY, color, newN,  nextQ);
	}
}
