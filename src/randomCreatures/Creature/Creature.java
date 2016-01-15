package randomCreatures.Creature;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.World;
import randomCreatures.Creature.Behaviors.Breeding;
import randomCreatures.Creature.Behaviors.BreedingSimple;

public class Creature {
	
	// Variables
	private int id;
	private Shape shape;
	private Color color;
	private Breeding breedingBehavior;
	private float birthrate;
	private int currentAge = 0;
	private int maxAge;
	private boolean dead = false;
	
	// Constructor
	public Creature(int id, Shape shape, Color color, float birthrate, int maxAge) {
		this.id = id;
		this.shape = shape;
		this.color = color;
		this.birthrate = birthrate;
		this.breedingBehavior = new BreedingSimple(this);
		this.maxAge = maxAge;
	}
	
	// "Destructor" (Get rid of all references to self)
	public void destroy() {
		breedingBehavior = null;
	}
	
	// To be performed every step
	// Unsure if giving the Creature access to the world is safe...
	public void run(World world) {
		
		// Use the current breeding behavior
		breedingBehavior.breed(world);
		
		// Aging
		if (currentAge == maxAge) {
			dead = true;
		}
		currentAge++;
		
	}
	
	@Override
	public String toString() {
		return "Creature with id of " + Integer.toString(id) + ", with a " + shape.toString() + " shape, the color of " + color.toString() + " and a birthrate of " + birthrate + ".";
	}
	
	// Getters and Setters //
	
	public int getID() { return id; }
	public float getBirthrate() { return birthrate; }
	public boolean getDead() { return dead; }
	
}
