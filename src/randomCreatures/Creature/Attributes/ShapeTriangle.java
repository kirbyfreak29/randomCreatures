package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

/**
 * Represents the shape of a triangle
 * 
 * @author kirbyfreak29
 */
public class ShapeTriangle implements Shape {
	
	@Override
	/**
	 * Returns a String representation of the shape
	 */
	public String toString() {
		return "triangle";
	}
	
	@Override
	/**
	 * Draw the shape at the given coordinates
	 */
	public void displayGraphics(Graphics g, float x, float y) {
		g.drawLine(x + 5, y, x + 10, y + 10);
		g.drawLine(x + 10, y + 10, x , y + 10);
		g.drawLine(x, y + 10, x + 5, y);
	}

}
