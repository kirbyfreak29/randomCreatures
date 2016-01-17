package randomCreatures.CreatureFactoryFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.Creature.Color;
import randomCreatures.Creature.Shape;
import randomCreatures.Creature.Behaviors.*;
import randomCreatures.CreatureFactory.CreatureFactory;

public class CreatureFactoryFactory {
	
	private List<Color> colorList;
	private List<Shape> shapeList;
	private BreedingFactory breedingFactory = new BreedingFactory();
	private EatingFactory eatingFactory = new EatingFactory();
	
	public CreatureFactoryFactory(List<Color> colorList, List<Shape> shapeList) {
		this.colorList = colorList;
		this.shapeList = shapeList;
	}
	
	public CreatureFactory createCreatureFactory(int id) {
		int randomColor = getRandomIndex(colorList);
		int randomShape = getRandomIndex(shapeList);
		Eating eatingBehavior = eatingFactory.createEating(getRandomInt(0, eatingFactory.getSize()));
		Breeding breedingBehavior = breedingFactory.createBreeding(getRandomInt(0, breedingFactory.getSize()));
		float birthrate = (float) getRandomDouble(.01, .05);
		int maxAge = getRandomInt(500, 1500);
		int size = getRandomInt(1, 5);
		
		return new CreatureFactory(id, shapeList.get(randomShape), colorList.get(randomColor), eatingBehavior, breedingBehavior, birthrate, maxAge, size);
	}
	
	// Get a random index for the given list according to its size
	public int getRandomIndex(List list) {
		return getRandomInt(0, list.size());
	}
	
	// Get random double between the two numbers given
	public double getRandomDouble(double low, double high) {
		return ThreadLocalRandom.current().nextDouble(low, high);
	}
	
	// Get random int between the two numbers given
	public int getRandomInt(int low, int high) {
		return ThreadLocalRandom.current().nextInt(low, high);
	}

}
