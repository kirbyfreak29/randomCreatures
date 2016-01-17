package randomCreatures.Creature;

import randomCreatures.World;
import randomCreatures.Creature.Behaviors.*;

public class Creature {
	
	// Variables
	private int id;
	private Shape shape;
	private Color color;
	private Breeding breedingBehavior;
	private Eating eatingBehavior;
	private float birthrate;
	private int currentAge = 0;
	private int maxAge;
	private boolean dead = false;
	private int size;
	private int maxHunger;
	private int currentHunger;
	private int hungerLossRate;
	
	// Constructor
	public Creature(int id, Shape shape, Color color, Eating eatingBehavior, Breeding breedingBehavior, float birthrate, int maxAge, 
			int size, int maxHunger, int hungerLossRate) {
		this.id = id;
		this.shape = shape;
		this.color = color;
		this.breedingBehavior = breedingBehavior;
		this.eatingBehavior = eatingBehavior;
		this.birthrate = birthrate;
		this.maxAge = maxAge;
		this.size = size;
		this.maxHunger = this.currentHunger = maxHunger;
		this.hungerLossRate = hungerLossRate;
	}
	
	// "Destructor" (Get rid of all references to self)
	public void destroy() {
		shape = null;
		color = null;
		breedingBehavior = null;
		eatingBehavior = null;
	}
	
	// To be performed every step
	// Unsure if giving the Creature access to the world is safe...
	public void run(World world) {
		
		// Use the current breeding behavior
		breedingBehavior.breed(world, this);
		
		// Aging
		if (currentAge == maxAge) {
			dead = true;
		}
		currentAge++;
		
		// Hunger
		if (currentHunger > 0) {
			currentHunger += eatingBehavior.findFood(world).getFoodValue();
			if (currentHunger > maxHunger) {
				currentHunger = maxHunger;
			}
			currentHunger -= hungerLossRate;
		} else {
			dead = true;
		}
		
	}
	
	@Override
	public String toString() {
		return "Creature with id of " + Integer.toString(id) + ", with a " + shape.toString() + " shape, the color of " + color.toString() + 
				" a birthrate of " + birthrate + ", and a max age of " + maxAge + ".\n\t" + "It has a " + breedingBehavior + " and a " + 
				eatingBehavior + ".";
				
	}
	
	// Getters and Setters //
	
	public int getID() { return id; }
	public float getBirthrate() { return birthrate; }
	public boolean getDead() { return dead; }
	
}
