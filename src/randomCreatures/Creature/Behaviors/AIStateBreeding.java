package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class AIStateBreeding implements AIState {

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

}
