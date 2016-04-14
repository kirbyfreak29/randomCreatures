package randomCreatures.Creature.Behaviors;

import java.util.concurrent.ThreadLocalRandom;

import randomCreatures.Plant;
import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class AIStateEating implements AIState {

	// Perform the eating action according to what the creature's eating type is
	@Override
	public void run(World world, Creature creature) {
		// If herbivore
		if (creature.getEatingBehavior().getLetter() == "H") {
			Plant plant = creature.getPlantToFind();
			// Set plant target to null if current plant is depleted
			if (plant.getDepleted()) {
				creature.setPlantToFind(null);
			}
			
			// If plant is gone, start hunting again
			if (creature.getPlantToFind() == null) {
				creature.setState(creature.getHuntingState());
				return;
			}
			
			// If plant is still there, eat the plant
			creature.creatureEat(plant.beEaten());
		// If carnivore
		} else {
			Creature targetCreature = creature.getCreatureToFind();
			// Set creature target to null if current plant is depleted
			if (targetCreature.getDead()) {
				creature.setCreatureToFind(null);
			}
			
			// If creature is gone, start hunting again
			if (creature.getCreatureToFind() == null) {
				creature.setState(creature.getHuntingState());
				return;
			}
			
			// If creature is still there, eat the creature
			creature.creatureEat(targetCreature.beEaten());
		}
		
		// If hunger is high enough, have a chance to go into breeding mode
		if ((creature.getCurrentHunger() / (double) creature.getMaxHunger()) > 0.7 && ThreadLocalRandom.current().nextInt(0, 100) < 60) {
			creature.setState(creature.getBreedingState());
		}
	}
	
	public String toString() {
		return "Eating";
	}
	
	// Unsure why this is duplicated with toString...?
	public String displayInfo() {
		return "Eating";
	}

}
