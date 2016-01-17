package randomCreatures.Creature.Behaviors;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class BreedingSimple implements Breeding {
	
	public BreedingSimple() {

	}
	
	public String toString() {
		return "simple breeding behavior";
	}

	@Override
	public void breed(World world, Creature creature) {
		if ((float) ThreadLocalRandom.current().nextDouble(1) <= (.1)) {
			if ((float) ThreadLocalRandom.current().nextDouble(1) <= (creature.getBirthrate())) {
				world.addCreature(creature.getID(), 1);
			}
		}
	}

}
