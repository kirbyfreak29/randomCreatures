package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

public class ColorRandom implements Color {

	// Color Variables
	int rValue;
	int gValue;
	int bValue;
	
	// Constructor
	public ColorRandom(int rv, int gv, int bv) {
		this.rValue = rv;
		this.gValue = gv;
		this.bValue = bv;
	}

	// Make sure the creature is drawn with its color
	@Override
	public void setColor(Graphics g, boolean currentlySelected) {
		if (currentlySelected) {
			g.setColor(new org.newdawn.slick.Color(250, 250, 250));
		} else {
			g.setColor(new org.newdawn.slick.Color(rValue, gValue, bValue));
		}
	}
	
}
