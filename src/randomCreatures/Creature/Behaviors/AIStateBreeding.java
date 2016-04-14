package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class AIStateBreeding implements AIState {

	// Perform the breeding action according to what the creature's breeding type is
	@Override
	public void run(World world, Creature creature) {
		// If hunger is high enough, breed
		if ((creature.getCurrentHunger() / (double) creature.getMaxHunger()) > 0.7) {
			creature.getBreedingBehavior().breed(world, creature);
		// If hunger is too low, start looking for food
		} else {
			creature.setState(creature.getHuntingState());
		}
	}
	
	public String toString() {
		return "Breeding";
	}
	
	// Unsure why this is duplicated with toString...?
	public String displayInfo() {
		return "Breeding";
	}

}
