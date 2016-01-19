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
	
	public String getLetter() {
		return "C";
	}

	@Override
	public Food findFood(World world) {
		if (ThreadLocalRandom.current().nextInt(0, 100) <= 0) {
			return world.getRandomCreature().beEaten();
		} else {
			return new Food(0);
		}
		
	}

}
