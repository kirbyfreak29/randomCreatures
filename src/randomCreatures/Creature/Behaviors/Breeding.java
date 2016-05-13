package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

/**
 * Interface for breeding implementations
 * 
 * @author kirbyfreak29
 */
public interface Breeding {
	public void breed(World world, Creature creature);
	public String toString();
}
