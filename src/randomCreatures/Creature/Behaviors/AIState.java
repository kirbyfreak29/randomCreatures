package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

/**
 * Interface for AI states
 * 
 * @author kirbyfreak29
 */
public interface AIState {

	public void run(World world, Creature creature);
	public String toString();
	public String displayInfo();
	
}
