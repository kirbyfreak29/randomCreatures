package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

public class ShapeTriangle implements Shape {
	
	@Override
	public String toString() {
		return "triangle";
	}
	
	// Draw the shape at the given coordinates
	@Override
	public void displayGraphics(Graphics g, float x, float y) {
		g.drawLine(x + 5, y, x + 10, y + 10);
		g.drawLine(x + 10, y + 10, x , y + 10);
		g.drawLine(x, y + 10, x + 5, y);
	}

}
