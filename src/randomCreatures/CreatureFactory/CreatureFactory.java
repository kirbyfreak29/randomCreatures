package randomCreatures.CreatureFactory;

import randomCreatures.Creature.Color;
import randomCreatures.Creature.Creature;
import randomCreatures.Creature.Shape;

public class CreatureFactory {
	
	// Variables
	private int id;
	private Color color;
	private Shape shape;
	
	// Constructor
	public CreatureFactory(int id, Shape shape, Color color) {
		this.id = id;
		this.shape = shape;
		this.color = color;
	}
	
	// creates and returns a new Creature based on the Factory
	public Creature createCreature() {
		return new Creature(id, shape, color);
	}
	
	public int getID() {
		return id;
	}

}
