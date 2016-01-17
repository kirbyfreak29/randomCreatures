package randomCreatures.CreatureFactory;

import randomCreatures.Creature.Color;
import randomCreatures.Creature.Creature;
import randomCreatures.Creature.Shape;
import randomCreatures.Creature.Behaviors.*;

public class CreatureFactory {
	
	// Variables
	private int id;
	private Color color;
	private Shape shape;
	private float birthrate;
	private int maxAge;
	private int size;
	private Eating eatingBehavior;
	private Breeding breedingBehavior;
	
	// Constructor
	public CreatureFactory(int id, Shape shape, Color color, Eating eatingBehavior, Breeding breedingBehavior, float birthrate, int maxAge, int size) {
		this.id = id;
		this.shape = shape;
		this.color = color;
		this.eatingBehavior = eatingBehavior;
		this.breedingBehavior = breedingBehavior;
		this.birthrate = birthrate;
		this.maxAge = maxAge;
		this.size = size;
	}
	
	// creates and returns a new Creature based on the Factory
	public Creature createCreature() {
		return new Creature(id, shape, color, eatingBehavior, breedingBehavior, birthrate, maxAge, size);
	}
	
	public int getID() {
		return id;
	}

}
