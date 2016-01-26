package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class AIStateEating implements AIState {

	@Override
	public void run(World world, Creature creature) {
		// If herbivore
		if (creature.getEatingBehavior().getLetter() == "H") {
			
		// If carnivore
		} else {
			
		}
	}

}
