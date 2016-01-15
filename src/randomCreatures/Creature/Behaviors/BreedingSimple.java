package randomCreatures.Creature.Behaviors;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class BreedingSimple implements Breeding {
	
	private Creature creature;
	
	public BreedingSimple(Creature creature) {
		this.creature = creature;
	}

	@Override
	public void breed(World world) {
		if ((float) ThreadLocalRandom.current().nextDouble(1) <= (.1)) {
			if ((float) ThreadLocalRandom.current().nextDouble(1) <= (creature.getBirthrate())) {
				world.addCreature(creature.getID(), 1);
				//System.out.println("Creature with id of " + creature.getID() + " was born.");
			}
		}
	}

}
