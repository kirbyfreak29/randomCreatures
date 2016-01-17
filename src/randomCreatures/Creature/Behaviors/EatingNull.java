package randomCreatures.Creature.Behaviors;

import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class EatingNull implements Eating {
	
public EatingNull() {
		
	}

	public String toString() {
		return "null eating behavior";
	}


	@Override
	public void findFood(World world) {
		
	}

}
