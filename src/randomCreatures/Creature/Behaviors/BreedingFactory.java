package randomCreatures.Creature.Behaviors;

/**
 * A factory that generates different Breeding objects
 * 
 * @author kirbyfreak29
 */
public class BreedingFactory {
	
	// Variables
	int size = 1; // Should not include the null objects
	
	/**
	 * Constructor
	 */
	public BreedingFactory() {
		
	}
	
	/**
	 * Return a new Breeding object based upon what behavior is specified
	 * 
	 * @param behavior	String, a string specifying the behavior implementation wanted
	 * @return			Breeding, the breeding object
	 */
	public Breeding createBreeding(String behavior) {
		switch (behavior) {
			case "simple": 	
				return new BreedingSimple();
			default: 			
				return new BreedingNull();
		}
	}
	
	/**
	 * Return a new Breeding object based upon what the integer is
	 * (Intended to be used more for randomly choosing behavior)
	 * 
	 * @param behavior	int, an integer specifying the behavior implementation wanted
	 * @return			Breeding, the breeding object
	 */
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
