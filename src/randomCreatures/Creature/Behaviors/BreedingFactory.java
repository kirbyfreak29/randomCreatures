package randomCreatures.Creature.Behaviors;

import randomCreatures.Creature.Creature;

public class BreedingFactory {
	
	int size = 1; // Should not include the null objects
	
	public BreedingFactory() {
		
	}
	
	public Breeding createBreeding(String behavior) {
		switch (behavior) {
			case "simple": 	
				return new BreedingSimple();
			default: 			
				return new BreedingNull();
		}
	}
	
	public Breeding createBreeding(int behavior) {
		switch (behavior) {
			case 0: 	
				return new BreedingSimple();
			default: 			
				return new BreedingNull();
		}
	}
	
	public int getSize() { return size; }

}
