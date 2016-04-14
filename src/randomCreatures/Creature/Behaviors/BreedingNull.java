package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class BreedingNull implements Breeding {
	
	// Constructor
	public BreedingNull() {
		
	}
	
	public String toString() {
		return "null breeding behavior";
	}
	
	// Breeds a new creature (does nothing for the null behavior)
	@Override
	public void breed(World world, Creature creature) {

	}

}
