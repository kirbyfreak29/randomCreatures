package randomCreatures.CreatureFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	private Stack<Integer> toBeBirthedX = new Stack<Integer>();
	private Stack<Integer> toBeBirthedY = new Stack<Integer>();
	
	// Constructor
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
	
	// creates and returns a new Creature based on the Factory
	public Creature createCreature(int x, int y) {
		return new Creature(id, x, y, shape, color, eatingBehavior, breedingBehavior, litterSize, birthrate, maxAge, size, 
				maxHunger, hungerLossRate, foodValue);
	}
	
	public Creature createCreatureFromBirthList() {
		return new Creature(id, toBeBirthedX.pop(), toBeBirthedY.pop(), shape, color, eatingBehavior, breedingBehavior, litterSize, birthrate, maxAge, size, 
				maxHunger, hungerLossRate, foodValue);
	}
	
	public void addCreatureToBirthList(int amount, int x, int y) {
		toBeBirthed += amount;
		toBeBirthedX.push(x);
		toBeBirthedY.push(y);
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
