package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

public class ColorRed implements Color {
	
	@Override
	public String toString() {
		return "red";
	}

	@Override
	public void setColor(Graphics g, boolean currentlySelected) {
		if (currentlySelected) {
			g.setColor(new org.newdawn.slick.Color(250, 250, 250));
		} else {
			g.setColor(new org.newdawn.slick.Color(255, 0, 64));
		}
	}
	
}
