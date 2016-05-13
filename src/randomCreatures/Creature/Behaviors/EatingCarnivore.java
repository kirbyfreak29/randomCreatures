package randomCreatures.Creature.Behaviors;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.Food;
import randomCreatures.World;
import randomCreatures.Creature.Creature;

/**
 * Represents the carnivore eating implementation
 * 
 * @author kirbyfreak29
 */
public class EatingCarnivore implements Eating {
	
	/**
	 * Constructor
	 */
	public EatingCarnivore() {
		
	}
	
	/**
	 * Returns a string representation of the eating implementation
	 */
	public String toString() {
		return "carnivorous eating behavior";
	}
	
	/**
	 * Returns a one-letter representation of the eating behavior
	 */
	public String getLetter() {
		return "C";
	}

	@Override
	/**
	 * Have a chance to find and eat a random creature in the world
	 */
	public Food findFood(World world) {
		if (ThreadLocalRandom.current().nextInt(0, 100) <= 10) {
			return world.getRandomCreature().beEaten();
		} else {
			return new Food(0);
		}
		
	}
	
	/**
	 * Get a random creature from the world
	 * 
	 * @param world	World, the world to get the creature from
	 * @return		Creature, the random creature
	 */
	public Creature findCreature(World world) {
		return world.getRandomCreature();
	}

}
