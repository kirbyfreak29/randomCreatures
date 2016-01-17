package randomCreatures.Creature.Behaviors;

import randomCreatures.Food;
import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class EatingNull implements Eating {
	
public EatingNull() {
		
	}

	public String toString() {
		return "null eating behavior";
	}


	@Override
	public Food findFood(World world) {
		return new Food(0);
	}

}
