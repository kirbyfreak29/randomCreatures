package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Rectangle;

public class ShapeSquare implements Shape {
	
	@Override
	public String toString() {
		return "square";
	}

	// Draw the shape at the given coordinates
	@Override
	public void displayGraphics(Graphics g, float x, float y) {
		g.drawRect(x, y, 10, 10);
	}

}
