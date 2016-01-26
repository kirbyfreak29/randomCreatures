package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

public class ColorRed implements Color {
	
	@Override
	public String toString() {
		return "red";
	}

	@Override
	public void setColor(Graphics g) {
		g.setColor(new org.newdawn.slick.Color(255, 0, 64));
	}
	
}
