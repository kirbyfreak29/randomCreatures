package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

public class ColorBlue implements Color {
	
	@Override
	public String toString() {
		return "blue";
	}

	@Override
	public void setColor(Graphics g) {
		g.setColor(new org.newdawn.slick.Color(0, 157, 255));
	}
	
}
