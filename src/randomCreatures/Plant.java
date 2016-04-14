package randomCreatures;

import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.Graphics;

public class Plant {
	
	// Variables
	private int x, y, foodValue, foodAmount, tileOffsetX, tileOffsetY;
	private boolean isDepleted = false;
	
	// Constructor
	public Plant(int x, int y, int foodValue, int foodAmount, int tileSize) {
		this.x = x;
		this.y = y;
		this.foodValue = foodValue;
		this.foodAmount = foodAmount;
		this.tileOffsetX = ThreadLocalRandom.current().nextInt(0, tileSize + 1);
		this.tileOffsetY = ThreadLocalRandom.current().nextInt(0, tileSize + 1);
	}
	
	// Draw the plant at its location in the given graphics window
	public void displayGraphics(Graphics g, int tileSize) {
		g.setColor(new org.newdawn.slick.Color(0, 251, 21));
		g.drawRect(x * tileSize + tileOffsetX , y * tileSize + tileOffsetY, 1, 1);
	}
	
	// Take a food from the remaining food stock and return a food object
	public Food beEaten() {
		foodAmount--;
		if (foodAmount <= 0) {
			isDepleted = true;
		}
		return new Food(foodValue);
	}
	
	// Check if the plant exists (does it have any food left?)
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
