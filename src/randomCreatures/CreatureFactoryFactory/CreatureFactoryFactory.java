package randomCreatures.CreatureFactoryFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.Creature.Color;
import randomCreatures.Creature.Shape;
import randomCreatures.CreatureFactory.CreatureFactory;

public class CreatureFactoryFactory {
	
	private List<Color> colorList;
	private List<Shape> shapeList;
	
	public CreatureFactoryFactory(List<Color> colorList, List<Shape> shapeList) {
		this.colorList = colorList;
		this.shapeList = shapeList;
	}
	
	public CreatureFactory createCreatureFactory(int id) {
		int randomColor = getRandomIndex(colorList);
		int randomShape = getRandomIndex(shapeList);
		float birthrate = getRandomBirthrate();
		
		return new CreatureFactory(id, shapeList.get(randomShape), colorList.get(randomColor), birthrate);
	}
	
	// Get a random index for the given list according to its size
	public int getRandomIndex(List list) {
		return ThreadLocalRandom.current().nextInt(0, list.size());
	}
	
	public float getRandomBirthrate() {
		return (float) ThreadLocalRandom.current().nextDouble(.5);
	}

}
