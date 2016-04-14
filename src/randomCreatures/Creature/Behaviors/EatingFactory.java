package randomCreatures.Creature.Behaviors;

import randomCreatures.Creature.Creature;

public class EatingFactory {
	
	// Variables
	private int size = 2; // Should not include the null objects
	
	// Constructor
	public EatingFactory() {
		
	}
	
	// Return a new Eating object based upon what behavior is specified
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
	
	// Return a new Eating object based upon what the integer is
	// (Intended to be used more for randomly choosing behavior)
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
	
	// Getters and Setters
	public int getSize() { return size; }
	
}
