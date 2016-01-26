package randomCreatures.Creature.Behaviors;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.Food;
import randomCreatures.World;
import randomCreatures.Creature.Creature;

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
		if (ThreadLocalRandom.current().nextInt(0, 100) <= 10) {
			return world.getRandomCreature().beEaten();
		} else {
			return new Food(0);
		}
		
	}
	
	public Creature findCreature(World world) {
		return world.getRandomCreature();
	}

}
