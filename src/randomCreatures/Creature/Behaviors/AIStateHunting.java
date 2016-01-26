package randomCreatures.Creature.Behaviors;

import randomCreatures.Plant;
import randomCreatures.World;
import randomCreatures.Creature.Creature;

public class AIStateHunting implements AIState {

	@Override
	public void run(World world, Creature creature) {
		int targetX, targetY;
		boolean targetExists;
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
				targetX = plant.getX();
				targetY = plant.getY();
				targetExists = plant.doesPlantExist();
				
					
				// If the plant doesn't exist anymore, set to null and don't move
				if (!targetExists) {
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
				targetX = targetCreature.getX();
				targetY = targetCreature.getY();
				targetExists = !targetCreature.getDead();
				
					
				// If the creature doesn't exist anymore, set to null and don't move
				if (!targetExists) {
					creature.setCreatureToFind(null);
					shouldMove = false;
				}
			}
		}
		
		if (targetExists && shouldMove) {
			// Move into eating state if on target
			if (creature.getX() == targetX && creature.getY() == targetY) {
				creature.setState(creature.getEatingState());
				return;
			}
			
			// If not on target, move towards the target
			moveTowardsTarget(creature, targetX, targetY);
		}
	}
	
	private void moveTowardsTarget(Creature creature, int targetX, int targetY) {
		if (creature.getX() < targetX) {
			creature.shiftX(1);
		} else if (creature.getX() > targetX) {
			creature.shiftX(-1);
		}
		
		if (creature.getY() < targetX) {
			creature.shiftY(1);
		} else if (creature.getY() > targetX) {
			creature.shiftY(-1);
		}
	}

}
