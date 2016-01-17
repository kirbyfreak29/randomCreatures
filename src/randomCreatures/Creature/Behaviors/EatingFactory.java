package randomCreatures.Creature.Behaviors;

import randomCreatures.Creature.Creature;

public class EatingFactory {
	
	private int size = 2; // Should not include the null objects
	
	public EatingFactory() {
		
	}
	
	public Eating createEating(String behavior) {
		switch (behavior) {
			case "herbivore": 	
				return new EatingHerbivore();
			case "carnivore": 	
				return new EatingCarnivore();
			default: 			
				return new EatingNull();
		}
	}
	
	public Eating createEating(int behavior) {
		switch (behavior) {
			case 0: 	
				return new EatingHerbivore();
			case 1: 	
				return new EatingCarnivore();
			default: 			
				return new EatingNull();
		}
	}
	
	public int getSize() { return size; }
	
}
