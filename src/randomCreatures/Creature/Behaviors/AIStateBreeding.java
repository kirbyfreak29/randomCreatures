package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

/**
 * Represents the AI State of breeding
 * 
 * @author kirbyfreak29
 */
public class AIStateBreeding implements AIState {

	@Override
	/**
	 * Perform the breeding action according to what the creature's breeding type is
	 */
	public void run(World world, Creature creature) {
		
		// If hunger is high enough, breed
		if ((creature.getCurrentHunger() / (double) creature.getMaxHunger()) > 0.7) {
			creature.getBreedingBehavior().breed(world, creature);
		// If hunger is too low, start looking for food
		} else {
			creature.setState(creature.getHuntingState());
		}
		
	}
	
	/**
	 * Returns a string representation of the AI state
	 */
	public String toString() {
		return "Breeding";
	}
	
	/**
	 * Unsure why this is duplicated with toString...?
	 */
	public String displayInfo() {
		return "Breeding";
	}

}
