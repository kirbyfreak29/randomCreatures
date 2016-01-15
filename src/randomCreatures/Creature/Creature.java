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
	
	// Constructor
	public Creature(int id, Shape shape, Color color, float birthrate) {
		this.id = id;
		this.shape = shape;
		this.color = color;
		this.birthrate = birthrate;
		this.breedingBehavior = new BreedingSimple(this);
	}
	
	// To be performed every step
	// Unsure if giving the Creature access to the world is safe...
	public void run(World world) {
		
		// Use the current breeding behavior
		breedingBehavior.breed(world);
		
	}
	
	@Override
	public String toString() {
		return "Creature with id of " + Integer.toString(id) + ", with a " + shape.toString() + " shape, the color of " + color.toString() + " and a birthrate of " + birthrate + ".";
	}
	
	// Getters and Setters //
	
	public int getID() { return id; }
	public float getBirthrate() { return birthrate; }
	
}
