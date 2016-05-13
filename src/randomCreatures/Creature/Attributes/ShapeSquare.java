package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Rectangle;

/**
 * Represents the shape of a square
 * 
 * @author kirbyfreak29
 */
public class ShapeSquare implements Shape {
	
	@Override
	/**
	 * Returns a String representation of the shape
	 */
	public String toString() {
		return "square";
	}

	@Override
	/**
	 * Draw the shape at the given coordinates
	 */
	public void displayGraphics(Graphics g, float x, float y) {
		g.drawRect(x, y, 10, 10);
	}

}
