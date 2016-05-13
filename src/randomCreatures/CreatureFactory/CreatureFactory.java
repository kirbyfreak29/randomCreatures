package randomCreatures.CreatureFactory;

import java.util.Stack;

import randomCreatures.Creature.Creature;
import randomCreatures.Creature.Attributes.Color;
import randomCreatures.Creature.Attributes.Shape;
import randomCreatures.Creature.Behaviors.*;

/**
 * A factory that generates Creature objects
 * 
 * @author kirbyfreak29
 */
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
	private Stack<Integer> toBeBirthedX = new Stack<Integer>();
	private Stack<Integer> toBeBirthedY = new Stack<Integer>();
	
	/**
	 * Constructor
	 * 
	 * @param id				int, the id of the creature's species
	 * @param shape				Shape, the shape of the creature
	 * @param color				Color, the color of the creature
	 * @param eatingBehavior	Eating, the eating behavior the creature uses
	 * @param breedingBehavior	Breeding, the breeding behavior the creature uses
	 * @param litterSize		int, the size of the creature's litter
	 * @param birthrate			double, how easily the creature can give birth
	 * @param maxAge			int, the age a creature dies at
	 * @param size				int, the size of the creature (higher = larger)
	 * @param maxHunger			int, the amount of food a creature can hold
	 * @param hungerLossRate	int, how fast a creature uses up stored food
	 * @param foodValue			int, how much food the creature gives if eaten	
	 */
	public CreatureFactory(int id, Shape shape, Color color, Eating eatingBehavior, Breeding breedingBehavior, int litterSize, 
			double birthrate, int maxAge, int size, int maxHunger, int hungerLossRate, int foodValue) {
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
	
	/**
	 * Creates and returns a new Creature based on the Factory
	 * NOTE: Check if this this used anymore
	 * 
	 * @param x	int, the x-coordinate the creature should be created at
	 * @param y	int, the y-coordinate the creature should be created at
	 * @return	Creature, the creature that was created
	 */
	public Creature createCreature(int x, int y) {
		return new Creature(id, x, y, shape, color, eatingBehavior, breedingBehavior, litterSize, birthrate, maxAge, size, 
				maxHunger, hungerLossRate, foodValue);
	}
	
	/**
	 * Make a new creature using info from the the birthing list and return it
	 * 
	 * @return	Creature, the created creature
	 */
	public Creature createCreatureFromBirthList() {
		return new Creature(id, toBeBirthedX.pop(), toBeBirthedY.pop(), shape, color, eatingBehavior, breedingBehavior, litterSize, birthrate, maxAge, size, 
				maxHunger, hungerLossRate, foodValue);
	}
	
	/**
	 * Add necessary info to the birthing lists to prepare for a new creature to be born
	 * 
	 * @param amount	int, the amount of creatures to create
	 * @param x			int, the x-coordinate to create the creatures at
	 * @param y			int, the y-coordinate to create the creatures at
	 */
	public void addCreatureToBirthList(int amount, int x, int y) {
		toBeBirthed += amount;
		for (int i = 0; i < amount; i++) {
			toBeBirthedX.push(x);
			toBeBirthedY.push(y);
		}
	}
	
	// Getters and Setters
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
