package randomCreatures;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * The GameContainer that runs the world logic every step
 * 
 * @author kirbyfreak29
 */
public class MyGame extends BasicGame {
	
	// Variables
	World world;
	int time = 0;
	int updates = 0;

	/**
	 * Constructor
	 * 
	 * @param title	String, the title to be displayed at the top of the window
	 */
	public MyGame(String title) {
		super(title);
	}

	@Override
	/**
	 * Run upon the creation of the GameContainer
	 */
	public void init(GameContainer gc) throws SlickException {

		 world = new World();
		
		for(int i = 0; i < 5; i++) {
			world.addNewSpecies();
		}
		
		world.populateWorld();
	}

	@Override
	/**
	 * Code to run every frame
	 */
	public void update(GameContainer gc, int delta) throws SlickException {
		time += delta;
		
		// Update ever .25 seconds
		if (time > 250) {
			time -= 250;
			world.run();
			updates++;
		}
	}
	
	@Override
	/**
	 * Update the graphics
	 */
	public void render(GameContainer gc, Graphics g) throws SlickException {
		world.displayWorldGraphics(g);
		g.setColor(new org.newdawn.slick.Color(255, 255, 255));
		g.drawString(Integer.toString(updates), 30, 30);
	}
	
	@Override
	/**
	 * When the mouse is pressed, pass the action onto the world
	 */
	public void mousePressed(int button, int x, int y) {
		world.clickCreature(x, y);
	}

}
