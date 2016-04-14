package randomCreatures.Creature.Behaviors;

import randomCreatures.Food;
import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class EatingNull implements Eating {
	
	// Constructor
	public EatingNull() {
		
	}

	public String toString() {
		return "null eating behavior";
	}
	
	// Returns a one-letter representation of the eating behavior
	public String getLetter() {
		return "N";
	}

	// Get a Food object of zero value
	@Override
	public Food findFood(World world) {
		return new Food(0);
	}

}
