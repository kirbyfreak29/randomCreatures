package randomCreatures.Creature.Behaviors;

import randomCreatures.Food;
import randomCreatures.Plant;
import randomCreatures.World;

public class EatingHerbivore implements Eating {
	
	public EatingHerbivore() {
		
	}
	
	public String toString() {
		return "herbivorous eating behavior";
	}

	public String getLetter() {
		return "H";
	}

	@Override
	public Food findFood(World world) {
		
		return world.getFoodFromRandomPlant();
		
	}
	
	public Plant findPlant(World world) {
		return world.getPlant();
	}

}
