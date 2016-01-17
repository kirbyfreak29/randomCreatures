package randomCreatures.Creature.Behaviors;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.Food;
import randomCreatures.World;

public class EatingCarnivore implements Eating {
	
	public EatingCarnivore() {
		
	}
	
	public String toString() {
		return "carnivorous eating behavior";
	}

	@Override
	public Food findFood(World world) {
		
		if (ThreadLocalRandom.current().nextInt(0, 100) <= 5) {
			return new Food(ThreadLocalRandom.current().nextInt(20, 30));
		} else {
			return new Food(0);
		}
		
	}

}
