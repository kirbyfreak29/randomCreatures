package randomCreatures.Creature.Behaviors;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.Food;
import randomCreatures.World;

public class EatingHerbivore implements Eating {
	
	public EatingHerbivore() {
		
	}
	
	public String toString() {
		return "herbivorous eating behavior";
	}


	@Override
	public Food findFood(World world) {
		
		if (ThreadLocalRandom.current().nextInt(0, 100) <= 20) {
			return new Food(ThreadLocalRandom.current().nextInt(5, 10));
		} else {
			return new Food(0);
		}
		
	}

}
