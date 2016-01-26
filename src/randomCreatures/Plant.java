package randomCreatures;

import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.Graphics;

public class Plant {
	
	private int x, y, foodValue, foodAmount, tileOffsetX, tileOffsetY;
	
	public Plant(int x, int y, int foodValue, int foodAmount, int tileSize) {
		this.x = x;
		this.y = y;
		this.foodValue = foodValue;
		this.foodAmount = foodAmount;
		this.tileOffsetX = ThreadLocalRandom.current().nextInt(0, tileSize + 1);
		this.tileOffsetY = ThreadLocalRandom.current().nextInt(0, tileSize + 1);
	}
	
	public void displayGraphics(Graphics g, int tileSize) {
		g.setColor(new org.newdawn.slick.Color(0, 251, 21));
		g.drawRect(x * tileSize + tileOffsetX , y * tileSize + tileOffsetY, 1, 1);
	}
	
	public Food getEaten() {
		foodAmount--;
		return new Food(foodValue);
	}
	
	public int getFoodAmount() { return foodAmount; }
	
}
