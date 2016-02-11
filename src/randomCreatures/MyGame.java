package randomCreatures;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MyGame extends BasicGame {
	
	World world;
	int time = 0;
	int updates = 0;

	public MyGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc) throws SlickException {

		 world = new World();
		
		for(int i = 0; i < 5; i++) {
			world.addNewSpecies();
		}
		
		world.populateWorld();
	}

	@Override
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
	public void render(GameContainer gc, Graphics g) throws SlickException {
		world.displayWorldGraphics(g);
		g.setColor(new org.newdawn.slick.Color(255, 255, 255));
		g.drawString(Integer.toString(updates), 30, 30);
	}
	
	@Override
	public void mousePressed(int button, int x, int y) {
		world.clickCreature(x, y);
	}

}
