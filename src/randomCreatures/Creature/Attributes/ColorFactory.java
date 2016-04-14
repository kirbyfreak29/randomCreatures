package randomCreatures.Creature.Attributes;

import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.Graphics;

public class ColorFactory {
	
	// Constructor
	public ColorFactory() { 

	}
	
	// Return a new ColorRandom object with a random color
	public Color getRandomColor() {
		return new ColorRandom(ThreadLocalRandom.current().nextInt(100, 250), ThreadLocalRandom.current().nextInt(100, 250), 
				ThreadLocalRandom.current().nextInt(100, 250));
	}
	
}
