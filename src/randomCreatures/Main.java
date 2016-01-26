package randomCreatures;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) {
		
		try { 
		    AppGameContainer container = new AppGameContainer(new MyGame("Random Creatures")); 
		    container.setDisplayMode(800,600,false); 
		    container.start(); 
		} catch (SlickException e) { 
		    e.printStackTrace(); 
		}
		
//		World world = new World();
//		
//		for(int i = 0; i < 5; i++) {
//			world.addNewSpecies();
//		}
//		
//		world.populateWorld();
//		
//		//world.displaySpecies();
//		
//		// Should be limited to a specific amount of loops per second eventually (should the world "frames" and graphical "frames" be
//		// set at different amounts per second?)
//		while(true) {
//			world.run();
//			world.displayWorld();
//			//window.run();
//			try {
//				Thread.sleep(250);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

}
