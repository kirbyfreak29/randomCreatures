package randomCreatures.Creature.Behaviors;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.World;

public class EatingHerbivore implements Eating {
	
	public EatingHerbivore() {
		
	}
	
	public String toString() {
		return "herbivorous eating behavior";
	}


	@Override
	public void findFood(World world) {
		if (ThreadLocalRandom.current().nextInt(0, 100) <= 20) {
			
		}
		
	}

}
