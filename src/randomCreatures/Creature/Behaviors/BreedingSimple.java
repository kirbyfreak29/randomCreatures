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
		if (ThreadLocalRandom.current().nextDouble(1.0) <= (creature.getBirthrate())) {
			world.addCreatureToBirthList(creature.getID(), creature.getLitterSize(), creature.getX(), creature.getY());
		}
	}

}
