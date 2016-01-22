package randomCreatures.Creature;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.Food;
import randomCreatures.World;
import randomCreatures.Creature.Attributes.Color;
import randomCreatures.Creature.Attributes.Shape;
import randomCreatures.Creature.Behaviors.*;

public class Creature {
	
	// Variables
	private int id;
	private Shape shape;
	private Color color;
	private Breeding breedingBehavior;
	private Eating eatingBehavior;
	
	private double birthrate;
	private int litterSize;
	private int currentAge = 0;
	private int maxAge;
	private boolean dead = false;
	private int size;
	private int maxHunger, currentHunger, hungerLossRate, foodValue;
	private int x, y;
	
	// Constructor
	public Creature(int id, int x, int y, Shape shape, Color color, Eating eatingBehavior, Breeding breedingBehavior, int litterSize, double birthrate, int maxAge, 
			int size, int maxHunger, int hungerLossRate, int foodValue) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.shape = shape;
		this.color = color;
		this.breedingBehavior = breedingBehavior;
		this.eatingBehavior = eatingBehavior;
		this.litterSize = litterSize;
		this.birthrate = birthrate;
		this.maxAge = maxAge;
		this.size = size;
		this.maxHunger = this.currentHunger = maxHunger;
		this.hungerLossRate = hungerLossRate;
		this.foodValue = foodValue;
	}
	
	// "Destructor" (Get rid of all references to self)
	public void destroy() {
		shape = null;
		color = null;
		breedingBehavior = null;
		eatingBehavior = null;
	}
	
	// To be performed every step
	// Unsure if giving the Creature access to the world is safe...
	public void run(World world) {
		
		// Use the current breeding behavior
		if ((currentHunger / (double) maxHunger) > 0.7) {
//			System.out.println(currentHunger / (double) maxHunger);
			breedingBehavior.breed(world, this);
		}
		
		// Aging
		if (currentAge == maxAge) {
			dead = true;
		}
		currentAge++;
		
		// Hunger
		if (!dead) {
			currentHunger -= hungerLossRate;
			if (currentHunger > 0) {
				if (ThreadLocalRandom.current().nextInt(0, 100) < 70) {
					currentHunger += eatingBehavior.findFood(world).getFoodValue();
				}
				if (currentHunger > maxHunger) {
					currentHunger = maxHunger;
				}
			} else {
				dead = true;
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "Creature with id of " + Integer.toString(id) + ", with a " + shape.toString() + " shape, the color of " + color.toString() + 
				" a birthrate of " + birthrate + ", and a max age of " + maxAge + ".\n\t" + "It has a " + breedingBehavior + " and a " + 
				eatingBehavior + "." + "\n\t It's current hunger is " + currentHunger + " out of " + maxHunger + ".";
				
	}
	
	public String getEatingBehaviorLetter() {
		return eatingBehavior.getLetter();
	}
	
	public Food beEaten() {
		if (!dead) {
			dead = true;
			return new Food(foodValue);
		} else {
			return new Food(0);
		}
	}
	
	// Getters and Setters //
	
	public int getID() { return id; }
	public double getBirthrate() { return birthrate; }
	public int getLitterSize() { return litterSize; }
	public boolean getDead() { return dead; }
	public int getX() { return x; }
	public int getY() { return y; }
	
}
