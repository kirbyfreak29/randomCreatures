package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

/**
 * Represents the color blue
 * NOTE: Should eventually have ColorFactories generate specific RandomColors for different colors instead
 * 
 * @author kirbyfreak29
 */
public class ColorBlue implements Color {
	
	@Override
	/**
	 * Returns a String representation of the color
	 */
	public String toString() {
		return "blue";
	}

	@Override
	/**
	 * Make sure the creature is drawn with its color
	 */
	public void setColor(Graphics g, boolean currentlySelected) {
		if (currentlySelected) {
			g.setColor(new org.newdawn.slick.Color(250, 250, 250));
		} else {
			g.setColor(new org.newdawn.slick.Color(0, 157, 255));
		}
	}
	
}
