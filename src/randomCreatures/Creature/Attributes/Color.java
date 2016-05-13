package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

/**
 * Interface for color classes to use
 * NOTE: Not sure if this is currently needed?
 * 
 * @author kirbyfreak29
 */
public interface Color {
	
	public String toString();
	public void setColor(Graphics g, boolean currentlySelected);

}
