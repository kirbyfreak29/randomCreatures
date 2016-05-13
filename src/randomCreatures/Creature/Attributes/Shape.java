package randomCreatures.Creature.Attributes;

import org.newdawn.slick.Graphics;

/**
 * Interface for shape classes to use
 * NOTE: Not sure if this is currently needed?
 * 
 * @author kirbyfreak29
 */
public interface Shape {
	
	public String toString();
	public void displayGraphics(Graphics g, float x, float y);

}
