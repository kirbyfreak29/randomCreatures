package randomCreatures;

public class Main {

	public static void main(String[] args) {
		
		World world = new World();
		
		for(int i = 0; i < 5; i++) {
			world.addNewSpecies();
		}
		
		world.populateWorld();
		
		//world.displaySpecies();
		
		// Should be limited to a specific amount of loops per second eventually (should the world "frames" and graphical "frames" be
		// set at different amounts per second?)
		while(true) {
			world.run();
			world.displayWorld();
			//window.run();
		}
//		
	}

}
