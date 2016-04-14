package randomCreatures.Creature.Behaviors;

import randomCreatures.Food;
import randomCreatures.Plant;
import randomCreatures.World;

public class EatingHerbivore implements Eating {
	
	// Constructor
	public EatingHerbivore() {
		
	}
	
	public String toString() {
		return "herbivorous eating behavior";
	}

	// Returns a one-letter representation of the eating behavior
	public String getLetter() {
		return "H";
	}

	// Have a chance to find and get food from a random plant in the world
	@Override
	public Food findFood(World world) {
		
		return world.getFoodFromRandomPlant();
		
	}
	
	// Get a random plant from the world
	public Plant findPlant(World world) {
		return world.getPlant();
	}

}
