package randomCreatures.CreatureFactory;

import randomCreatures.Creature.Color;
import randomCreatures.Creature.Creature;
import randomCreatures.Creature.Shape;

public class CreatureFactory {
	
	// Variables
	private int id;
	private Color color;
	private Shape shape;
	private float birthrate;
	private int maxAge;
	
	// Constructor
	public CreatureFactory(int id, Shape shape, Color color, float birthrate, int maxAge) {
		this.id = id;
		this.shape = shape;
		this.color = color;
		this.birthrate = birthrate;
		this.maxAge = maxAge;
	}
	
	// creates and returns a new Creature based on the Factory
	public Creature createCreature() {
		return new Creature(id, shape, color, birthrate, maxAge);
	}
	
	public int getID() {
		return id;
	}

}
