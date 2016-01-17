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
	private int maxHunger;
	private int hungerLossRate;
	
	// Constructor
	public CreatureFactory(int id, Shape shape, Color color, Eating eatingBehavior, Breeding breedingBehavior, float birthrate, int maxAge, 
			int size, int maxHunger, int hungerLossRate) {
		this.id = id;
		this.shape = shape;
		this.color = color;
		this.eatingBehavior = eatingBehavior;
		this.breedingBehavior = breedingBehavior;
		this.birthrate = birthrate;
		this.maxAge = maxAge;
		this.size = size;
		this.maxHunger = maxHunger;
		this.hungerLossRate = hungerLossRate;
	}
	
	// creates and returns a new Creature based on the Factory
	public Creature createCreature() {
		return new Creature(id, shape, color, eatingBehavior, breedingBehavior, birthrate, maxAge, size, maxHunger, hungerLossRate);
	}
	
	public int getID() {
		return id;
	}

}
