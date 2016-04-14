package randomCreatures.Creature.Behaviors;

import randomCreatures.Creature.Creature;

public class BreedingFactory {
	
	// Variables
	int size = 1; // Should not include the null objects
	
	// Constructor
	public BreedingFactory() {
		
	}
	
	// Return a new Breeding object based upon what behavior is specified
	public Breeding createBreeding(String behavior) {
		switch (behavior) {
			case "simple": 	
				return new BreedingSimple();
			default: 			
				return new BreedingNull();
		}
	}
	
	// Return a new Breeding object based upon what the integer is
	// (Intended to be used more for randomly choosing behavior)
	public Breeding createBreeding(int behavior) {
		switch (behavior) {
			case 0: 	
				return new BreedingSimple();
			default: 			
				return new BreedingNull();
		}
	}
	
	// Getters and Setters
	public int getSize() { return size; }

}
