package randomCreatures.Creature.Behaviors;

/**
 * A factory that generates different Eating objects
 * 
 * @author kirbyfreak29
 */
public class EatingFactory {
	
	// Variables
	private int size = 2; // How many options there are; should not include the null implementation
	
	/**
	 * Constructor
	 */
	public EatingFactory() {
		
	}
	
	/**
	 * Return a new Eating object based upon what behavior is specified
	 * 
	 * @param behavior	String, a string specifying the behavior implementation wanted
	 * @return			Eating, the eating object
	 */
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
	
	/**
	 * Return a new Eating object based upon what the integer is
	 * (Intended to be used more for randomly choosing behavior)
	 * 
	 * @param behavior	int, an integer specifying the behavior implementation wanted
	 * @return			Eating, the eating object
	 */
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
