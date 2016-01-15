package randomCreatures.Creature;

public class Creature {
	
	// Variables
	private int id;
	private Shape shape;
	private Color color;
	
	// Constructor
	public Creature(int id, Shape shape, Color color) {
		this.id = id;
		this.shape = shape;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Creature with id of " + Integer.toString(id) + ", with a " + shape.toString() + " shape and the color of " + color.toString() + ".";
	}
	
}
