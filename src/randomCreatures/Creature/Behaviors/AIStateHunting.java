package randomCreatures.Creature.Behaviors;

import randomCreatures.Plant;
import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class AIStateHunting implements AIState {

	// Perform the hunting action according to what the creature's eating type is
	@Override
	public void run(World world, Creature creature) {
		boolean shouldMove = true;
		
		// If herbivore
		if (creature.getEatingBehavior().getLetter() == "H") {
			// Get plant if there's not target
			if (creature.getPlantToFind() == null) {
				creature.setPlantToFind(world.getPlant());
				return;
			// If there is a target plant
			} else {
				// Set up target variables using the plant
				Plant plant = creature.getPlantToFind();
				creature.setTargetX(plant.getX());
				creature.setTargetY(plant.getY());
				creature.setTargetExists(plant.doesPlantExist());
				
					
				// If the plant doesn't exist anymore, set to null and don't move
				if (!creature.getTargetExists()) {
					creature.setPlantToFind(null);
					shouldMove = false;
				}
			}
		// If carnivore
		} else {
			// Get creature if there's not target
			if (creature.getCreatureToFind() == null) {
				creature.setCreatureToFind(world.getRandomCreature());
				return;
			// If there is a target creature
			} else {
				// Set up target variables using the creature
				Creature targetCreature = creature.getCreatureToFind();
				creature.setTargetX(targetCreature.getX());
				creature.setTargetY(targetCreature.getY());
				creature.setTargetExists(!targetCreature.getDead());	
					
				// If the creature doesn't exist anymore, set to null and don't move
				if (!creature.getTargetExists()) {
					creature.setCreatureToFind(null);
					shouldMove = false;
				}
			}
		}
		
		if (creature.getTargetExists() && shouldMove) {
			// Move into eating state if on target
			if (creature.getX() == creature.getTargetX() && creature.getY() == creature.getTargetY()) {
				creature.setState(creature.getEatingState());
				return;
			}
			
			// If not on target, move towards the target
			moveTowardsTarget(creature, creature.getX(), creature.getY(), creature.getTargetX(), creature.getTargetY());
		}
	}
	
	// Shift the target's current position by 1 on a cardinal direction towards the target's current position
	private void moveTowardsTarget(Creature creature, int x, int y, int targetX, int targetY) {
		if (x < targetX) {
			creature.shiftX(1);
		} else if (x > targetX) {
			creature.shiftX(-1);
		}
		
		if (y < targetY) {
			creature.shiftY(1);
		} else if (y > targetY) {
			creature.shiftY(-1);
		}
	}
	
	public String toString() {
		return "Hunting";
	}
	
	// Unsure why this is duplicated with toString...?
	public String displayInfo() {
		return "Hunting";
	}

}
