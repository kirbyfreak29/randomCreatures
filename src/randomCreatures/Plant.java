package randomCreatures;

import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.Graphics;

/**
 * A Plant that has a limited amount of times it can be eaten for Food
 * 
 * @author kirbyfreak29
 */
public class Plant {
	
	// Variables
	private int x, y, foodValue, foodAmount, tileOffsetX, tileOffsetY;
	private boolean isDepleted = false;
	
	/**
	 * Constructor
	 * 
	 * @param x				int, the x-coordinate of the plant
	 * @param y				int, the y-coordinate of the plant
	 * @param foodValue		int, the food value of the plant
	 * @param foodAmount	int, the amount of times the plant can be eaten
	 * @param tileSize		int, the size of the tile the plant is in (based on (x,y))
	 */
	public Plant(int x, int y, int foodValue, int foodAmount, int tileSize) {
		this.x = x;
		this.y = y;
		this.foodValue = foodValue;
		this.foodAmount = foodAmount;
		this.tileOffsetX = ThreadLocalRandom.current().nextInt(0, tileSize + 1);
		this.tileOffsetY = ThreadLocalRandom.current().nextInt(0, tileSize + 1);
	}
	
	/**
	 * Draw the plant at its location in the given graphics window
	 * 
	 * @param g			Graphics, the Graphics object
	 * @param tileSize	int, the size of the tile the plant is in
	 */
	public void displayGraphics(Graphics g, int tileSize) {
		g.setColor(new org.newdawn.slick.Color(0, 251, 21));
		g.drawRect(x * tileSize + tileOffsetX , y * tileSize + tileOffsetY, 1, 1);
	}
	
	/**
	 * Take a food from the remaining food stock and return a food object
	 * 
	 * @return	Food, the food object created from the plant
	 */
	public Food beEaten() {
		foodAmount--;
		if (foodAmount <= 0) {
			isDepleted = true;
		}
		return new Food(foodValue);
	}
	
	/**
	 * Check if the plant exists (does it have any food left?)
	 * 
	 * @return	boolean, true if the plant exists
	 */
	public boolean doesPlantExist() {
		if (foodAmount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Getters and Setters
	public int getFoodAmount() { return foodAmount; }
	public int getX() { return x; }
	public int getY() { return y; }
	public boolean getDepleted() { return isDepleted; }
	
}
