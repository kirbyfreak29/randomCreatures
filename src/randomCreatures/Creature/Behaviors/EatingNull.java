package randomCreatures.Creature.Behaviors;

import randomCreatures.Food;
import randomCreatures.World;
import randomCreatures.Creature.Creature;

/**
 * Represents the null eating implementation (i.e. can not eat)
 * 
 * @author kirbyfreak29
 */
public class EatingNull implements Eating {
	
	/**
	 * Constructor
	 */
	public EatingNull() {
		
	}
	
	/**
	 * Returns a string representation of the eating implementation
	 */
	public String toString() {
		return "null eating behavior";
	}
	
	/**
	 * Returns a one-letter representation of the eating behavior
	 */
	public String getLetter() {
		return "N";
	}

	@Override
	/**
	 * Get a Food object of zero value
	 */
	public Food findFood(World world) {
		return new Food(0);
	}

}
