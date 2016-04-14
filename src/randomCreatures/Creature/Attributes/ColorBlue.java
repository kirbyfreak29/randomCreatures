package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

public class ColorBlue implements Color {
	
	@Override
	public String toString() {
		return "blue";
	}

	// Make sure the creature is drawn with its color
	@Override
	public void setColor(Graphics g, boolean currentlySelected) {
		if (currentlySelected) {
			g.setColor(new org.newdawn.slick.Color(250, 250, 250));
		} else {
			g.setColor(new org.newdawn.slick.Color(0, 157, 255));
		}
	}
	
}
