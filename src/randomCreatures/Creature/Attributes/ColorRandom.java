package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

/**
 * Represents a random color
 * 
 * @author kirbyfreak29
 */
public class ColorRandom implements Color {

	// Color Variables
	int rValue;
	int gValue;
	int bValue;
	
	/**
	 * Constructor
	 * 
	 * @param rv	int, the red value
	 * @param gv	int, the green value
	 * @param bv	int, the blue value
	 */
	public ColorRandom(int rv, int gv, int bv) {
		this.rValue = rv;
		this.gValue = gv;
		this.bValue = bv;
	}

	/**
	 * Make sure the creature is drawn with its color
	 */
	@Override
	public void setColor(Graphics g, boolean currentlySelected) {
		if (currentlySelected) {
			g.setColor(new org.newdawn.slick.Color(250, 250, 250));
		} else {
			g.setColor(new org.newdawn.slick.Color(rValue, gValue, bValue));
		}
	}
	
}
