package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class BreedingNull implements Breeding {
	
	public BreedingNull() {
		
	}
	
	public String toString() {
		return "null breeding behavior";
	}
	
	@Override
	public void breed(World world, Creature creature) {

	}

}
