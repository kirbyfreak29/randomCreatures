package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public interface Breeding {
	public void breed(World world, Creature creature);
	public String toString();
}
