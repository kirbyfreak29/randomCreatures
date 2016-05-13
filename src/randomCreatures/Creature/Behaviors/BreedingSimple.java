package randomCreatures.Creature.Behaviors;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

/**
 * Represents the simple breeding implementation
 * 
 * @author kirbyfreak29
 */
public class BreedingSimple implements Breeding {
	
	/**
	 * Constructor
	 */
	public BreedingSimple() {

	}
	
	/**
	 * Returns a string representation of the breeding implementation
	 */
	public String toString() {
		return "simple breeding behavior";
	}

	@Override
	/**
	 * Creates a new creature depending on the creature's birthrate and add's it to the birthing list
	 * (Eventually this will depend on actual mating, and possible preganancy)
	 */
	public void breed(World world, Creature creature) {
		
		// Possibly give birth to babies (depends on the mother creature's birth rate)
		if (ThreadLocalRandom.current().nextDouble(1.0) <= (creature.getBirthrate())) {
			
			// Add a random amount of new creatures to the birthing list at the position of the creature who's giving birth
			world.addCreatureToBirthList(creature.getID(), ThreadLocalRandom.current().nextInt(1, creature.getLitterSize() + 1), 
					creature.getX(), creature.getY());
			
		}
		
	}

}
