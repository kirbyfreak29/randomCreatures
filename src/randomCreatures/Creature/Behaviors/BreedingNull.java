package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

/**
 * Represents the null breeding implementation (i.e. can not breed)
 * 
 * @author kirbyfreak29
 */
public class BreedingNull implements Breeding {
	
	/**
	 * Constructor
	 */
	public BreedingNull() {
		
	}
	
	/**
	 * Returns a string representation of the breeding implementation
	 */
	public String toString() {
		return "null breeding behavior";
	}
	
	
	@Override
	/**
	 * Breeds a new creature (does nothing for the null behavior)
	 */
	public void breed(World world, Creature creature) {

	}

}
