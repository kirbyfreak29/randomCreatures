package randomCreatures.Creature.Behaviors;

import randomCreatures.Food;
import randomCreatures.World;

public interface Eating {
	public Food findFood(World world);
	public String toString();
}
