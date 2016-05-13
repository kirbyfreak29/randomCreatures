package randomCreatures.Creature.Behaviors;

import randomCreatures.Food;
import randomCreatures.Plant;
import randomCreatures.World;

/**
 * Represents the herbivore eating implementation
 * 
 * @author kirbyfreak29
 */
public class EatingHerbivore implements Eating {
	
	/**
	 * Constructor
	 */
	public EatingHerbivore() {
		
	}
	
	/**
	 * Returns a string representation of the eating implementation
	 */
	public String toString() {
		return "herbivorous eating behavior";
	}

	/**
	 * Returns a one-letter representation of the eating behavior
	 */
	public String getLetter() {
		return "H";
	}

	@Override
	/**
	 * Have a chance to find and get food from a random plant in the world
	 */
	public Food findFood(World world) {
		
		return world.getFoodFromRandomPlant();
		
	}
	
	/**
	 * Get a random plant from the world
	 * 
	 * @param world	World, the world to get the plant from
	 * @return		Creature, the random plant
	 */
	public Plant findPlant(World world) {
		return world.getPlant();
	}

}
