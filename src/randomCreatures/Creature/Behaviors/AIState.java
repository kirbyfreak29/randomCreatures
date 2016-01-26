package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public interface AIState {

	public void run(World world, Creature creature);
	
}
