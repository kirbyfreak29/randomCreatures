package randomCreatures.Creature.Attributes;

import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.Graphics;

/**
 * A factory that generates randomly created Color objects
 * NOTE: Should eventually have ColorFactories generate specific RandomColors for different colors too
 * 
 * @author kirbyfreak29
 */
public class ColorFactory {
	
	/**
	 * Constructor
	 */
	public ColorFactory() { 
		
	}
	
	/**
	 * Return a new ColorRandom object with a random color
	 * 
	 * @return	Color, the randomly generated color
	 */
	public Color getRandomColor() {
		return new ColorRandom(ThreadLocalRandom.current().nextInt(100, 250), ThreadLocalRandom.current().nextInt(100, 250), 
				ThreadLocalRandom.current().nextInt(100, 250));
	}
	
}
