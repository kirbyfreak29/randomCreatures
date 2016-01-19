package randomCreatures.CreatureFactory;

import randomCreatures.Creature.Creature;
import randomCreatures.Creature.Attributes.Color;
import randomCreatures.Creature.Attributes.Shape;
import randomCreatures.Creature.Behaviors.*;

public class CreatureFactory {
	
	// Variables
	private int id;
	private Color color;
	private Shape shape;
	private double birthrate;
	private int maxAge;
	private int size;
	private Eating eatingBehavior;
	private Breeding breedingBehavior;
	private int litterSize;
	private int maxHunger;
	private int hungerLossRate;
	private int foodValue;
	
	private int toBeBirthed = 0;
	
	// Constructor
	public CreatureFactory(int id, Shape shape, Color color, Eating eatingBehavior, Breeding breedingBehavior, int litterSize, double birthrate, int maxAge, 
			int size, int maxHunger, int hungerLossRate, int foodValue) {
		this.id = id;
		this.shape = shape;
		this.color = color;
		this.eatingBehavior = eatingBehavior;
		this.breedingBehavior = breedingBehavior;
		this.litterSize = litterSize;
		this.birthrate = birthrate;
		this.maxAge = maxAge;
		this.size = size;
		this.maxHunger = maxHunger;
		this.hungerLossRate = hungerLossRate;
		this.foodValue = foodValue;
	}
	
	// creates and returns a new Creature based on the Factory
	public Creature createCreature() {
		return new Creature(id, shape, color, eatingBehavior, breedingBehavior, litterSize, birthrate, maxAge, size, maxHunger, hungerLossRate, foodValue);
	}
	
	public void addCreatureToBirthList(int amount) {
		toBeBirthed += amount;
	}
	
	public int getID() {
		return id;
	}
	
	public int getBirthList() {
		int birthList = toBeBirthed;
		toBeBirthed = 0;
		return birthList;
	}
	
	public String getEatingBehaviorLetter() {
		return eatingBehavior.getLetter();
	}

}
