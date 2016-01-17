package randomCreatures;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.tree.DefaultMutableTreeNode;

import randomCreatures.Creature.*;
import randomCreatures.Creature.Behaviors.*;
import randomCreatures.CreatureFactory.CreatureFactory;
import randomCreatures.CreatureFactoryFactory.CreatureFactoryFactory;

public class World {
	
	// Variables
	private HashMap<Integer, List<Creature>> creatureLists;
	private HashMap<Integer, CreatureFactory> creatureFactories;
	private FoodChain foodChain;
	private CreatureFactoryFactory creatureFactoryFactory;
	
	// Creature Trait Lists
	private List<Color> colorList;
	private List<Shape> shapeList;
	
	// Constructor
	public World() {
		
		// Initialize lists of creature trait lists
		colorList = new ArrayList<Color>();
		colorList.add(new ColorBlue());
		colorList.add(new ColorRed());
		
		shapeList = new ArrayList<Shape>();
		shapeList.add(new ShapeSquare());
		shapeList.add(new ShapeTriangle());
		
		// Create the Factory for making CreatureFactories
		creatureFactoryFactory = new CreatureFactoryFactory(colorList, shapeList);
		
		// Create HashMap of Lists of Creatures
		creatureLists = new HashMap<Integer, List<Creature>>();
		creatureFactories = new HashMap<Integer, CreatureFactory>();
		
		foodChain = new FoodChain(creatureFactoryFactory);
	}
	
	// To be performed every step
	public void run() {
		
		// Run every creatures' run method
		for(int i = 0; i < creatureLists.size(); i++) {
			for(int j = 0; j < creatureLists.get(i).size(); j++) {
				creatureLists.get(i).get(j).run(this);
			}
		}
		
		clearDeadCreatures();
		
	}
	
	// Needs to add a new randomly created Creature Factory to the list, create a random amount of creatures, and then add the id to the tree
	// NOTE: Should I merge this together with populate world?
	public void addNewSpecies() {
		
		// Add id to the tree and get the new factory (the FoodChain makes the new factory and adding the id to the tree)
		CreatureFactory newFactory = foodChain.addSpecies();
		
		// Add the new factory to the hash map with its id as the key
		creatureFactories.put(newFactory.getID(), newFactory);
		
		// Add the a creature List for the new species
		creatureLists.put(newFactory.getID(), new ArrayList<Creature>());
	}
	
	// Loop through the FoodChain and add creatures for each node
	public void populateWorld() {
		
		// Make a depth-first enumeration of the food chain tree
		Enumeration e = ((DefaultMutableTreeNode) foodChain.getFoodChain().getRoot()).depthFirstEnumeration();
		
		// Loop through the enumeration and use the ids to populate each species
		while(e.hasMoreElements()) {
			// Gets the id from the current node creates a random amount of creatures of that species
			addCreature((int) ((DefaultMutableTreeNode) e.nextElement()).getUserObject(), ThreadLocalRandom.current().nextInt(1, 11));
		}
	}
	
	// Adds the specified amount of creature instances
	public void addCreature(int id, int amount) {
		for(int i = 0; i < amount; i++) {
			creatureLists.get(id).add(creatureFactories.get(id).createCreature());
		}
	}
	
	public void clearDeadCreatures() {
		
		// Run every creatures' run method
		for(int i = 0; i < creatureLists.size(); i++) {
			for(int j = 0; j < creatureLists.get(i).size(); j++) {
				if (creatureLists.get(i).get(j).getDead() == true) {
					creatureLists.get(i).get(j).destroy();
					creatureLists.get(i).remove(j);
				}
			}
		}
		
	}
	
	public void displayWorld() {
		
		for(int i = 0; i < creatureLists.size() + 1; i++) {
			System.out.println();
		}
		
		int creatureCount = 0;
		
		// Output strings of everything
		for(int i = 0; i < creatureLists.size(); i++) {
			System.out.println("Species " + i + ": " + creatureLists.get(i).size());
			for(int j = 0; j < creatureLists.get(i).size(); j++) {
				creatureCount++;
			}
		}
		
		System.out.println("Total amount of creatures is: " + creatureCount);

	}
	
	public void displaySpecies() {
		// Output strings of everything
		for(int i = 0; i < creatureLists.size(); i++) {
			if(creatureLists.get(i).size() > 0) {
				System.out.println("Species " + i + ": " + creatureLists.get(i).get(0));
			}
		}
	}

}
