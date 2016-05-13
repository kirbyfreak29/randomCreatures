package randomCreatures.Creature.Behaviors;

import randomCreatures.Food;
import randomCreatures.World;

/**
 * Interface for eating implementations
 * 
 * @author kirbyfreak29
 */
public interface Eating {
	public Food findFood(World world);
	public String toString();
	public String getLetter();
}
