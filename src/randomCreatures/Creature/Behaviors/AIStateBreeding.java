package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class AIStateBreeding implements AIState {

	@Override
	public void run(World world, Creature creature) {
		if ((creature.getCurrentHunger() / (double) creature.getMaxHunger()) > 0.7) {
//			System.out.println(currentHunger / (double) maxHunger);
			creature.getBreedingBehavior().breed(world, creature);
		}
	}

}
