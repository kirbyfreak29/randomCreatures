package randomCreatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.tree.DefaultMutableTreeNode;

import org.newdawn.slick.Graphics;

import randomCreatures.Creature.*;
import randomCreatures.Creature.Attributes.Color;
import randomCreatures.Creature.Attributes.ColorBlue;
import randomCreatures.Creature.Attributes.ColorRed;
import randomCreatures.Creature.Attributes.Shape;
import randomCreatures.Creature.Attributes.ShapeSquare;
import randomCreatures.Creature.Attributes.ShapeTriangle;
import randomCreatures.Creature.Behaviors.*;
import randomCreatures.CreatureFactory.CreatureFactory;
import randomCreatures.CreatureFactoryFactory.CreatureFactoryFactory;

public class World {
	
	// Variables
	private HashMap<Integer, List<Creature>> creatureLists;
	private HashMap<Integer, CreatureFactory> creatureFactories;
	private List<Creature> allCreatures;
	private FoodChain foodChain;
	//private int plantAmount;
	private List<Plant> plantList;
	private int plantCap;
	private CreatureFactoryFactory creatureFactoryFactory;
	
	private final int WORLD_WIDTH = 80;
	private final int WORLD_HEIGHT = 60;
	private final int TILE_SIZE = 10;
	
	// Creature Trait Lists
	private List<Color> colorList;
	private List<Shape> shapeList;
	
	// Selected Creature
	 Creature selectedCreature = null;
	
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
		
		//plantAmount = ThreadLocalRandom.current().nextInt(500, 1000);
//		plantAmount = 1000; //ThreadLocalRandom.current().nextInt(50, 100);
		plantList = new ArrayList<Plant>();
		plantCap = 1000;
		
		for(int i = 0; i < 100; i++) {
			addPlant();
		}
		
	}
	
	// To be performed every step
	public void run() {
		
		// Run every creatures' run method
		allCreatures = new ArrayList<Creature>();
		for(int i = 0; i < creatureLists.size(); i++) {
			allCreatures.addAll(creatureLists.get(i));
		}
		
		Collections.shuffle(allCreatures);
		
		for(int i = 0; i < allCreatures.size(); i++) {
			allCreatures.get(i).run(this);
		}
		
//		for(int i = 0; i < creatureLists.size(); i++) {
//			for(int j = 0; j < creatureLists.get(i).size(); j++) {
//				creatureLists.get(i).get(j).run(this);
//			}
//		}
		
		// Update World
		clearDeadCreatures();
		clearDeadPlants();
		birthCreatures();
		growMorePlants();
		
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
			//addCreature((int) ((DefaultMutableTreeNode) e.nextElement()).getUserObject(), ThreadLocalRandom.current().nextInt(50, 300));
			addCreature((int) ((DefaultMutableTreeNode) e.nextElement()).getUserObject(), 25, 
					ThreadLocalRandom.current().nextInt(0, WORLD_WIDTH + 1), ThreadLocalRandom.current().nextInt(0, WORLD_HEIGHT + 1));
		}
	}
	
	// Adds the specified amount of creature instances
	public void addCreature(int id, int amount, int x, int y) {
		for(int i = 0; i < amount; i++) {
			creatureLists.get(id).add(creatureFactories.get(id).createCreature(x, y));
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
	
	public void clearDeadPlants() {
		for(int i = 0; i < plantList.size(); i++) {
			if (plantList.get(i).getDepleted()) {
				plantList.remove(i);
			}
		}
	}
	
	public Food getFoodFromRandomPlant() {
		if (plantList.size() > 0) {
			
			// Get food from a random plant
			int randomPlant = ThreadLocalRandom.current().nextInt(0, plantList.size());
			return plantList.get(randomPlant).getEaten();
			
		} else {
			//System.out.println("returned blank food");
			return new Food(0);
		}
	}
	
	public Plant getPlant() {
		if (plantList.size() > 0) {
			
			// Get food from a random plant
			int randomPlant = ThreadLocalRandom.current().nextInt(0, plantList.size());
			return plantList.get(randomPlant);
			
		}
		return null;
	}
	
	public void addPlant() {
		plantList.add(new Plant(ThreadLocalRandom.current().nextInt(0, WORLD_WIDTH), 
				ThreadLocalRandom.current().nextInt(0, WORLD_HEIGHT), ThreadLocalRandom.current().nextInt(10, 15),
				ThreadLocalRandom.current().nextInt(5, 25), TILE_SIZE));
	}
	
	public void growMorePlants() {
		//plantAmount += ThreadLocalRandom.current().nextInt(300, 500);
		int toGrow = ThreadLocalRandom.current().nextInt(1, 3);
		while (plantList.size() <= plantCap && toGrow > 0) {
			addPlant();
			toGrow--;
		}
	}
	
	public void addCreatureToBirthList(int id, int amount, int x, int y) {
		creatureFactories.get(id).addCreatureToBirthList(amount, x, y);
	}
	
	public void birthCreatures() {
		for(int i = 0; i < creatureFactories.size(); i++) {
			int birthAmount = creatureFactories.get(i).getBirthList();
			for(int j = 0; j < birthAmount; j++) {
				creatureLists.get(i).add(creatureFactories.get(i).createCreatureFromBirthList());
			}
		}
	}
	
	public void clickCreature(int clickX, int clickY) {
		// Run every creatures' run method
		allCreatures = new ArrayList<Creature>();
		for(int i = 0; i < creatureLists.size(); i++) {
			allCreatures.addAll(creatureLists.get(i));
		}
		
		Collections.shuffle(allCreatures);
		
		for(int i = 0; i < allCreatures.size(); i++) {
			if (allCreatures.get(i).coordsInsideCreature(clickX, clickY, TILE_SIZE)) {
				if (selectedCreature != null) {
					selectedCreature.setCurrentlySelected(false);
				}
				selectedCreature = allCreatures.get(i);
				selectedCreature.setCurrentlySelected(true);
				return;
			}
		}
		
		// If no creature was selected
		if (selectedCreature != null) {
			selectedCreature.setCurrentlySelected(false);
		}
		selectedCreature = null;
	}
	
	public void displayWorld() {
		
		for(int i = 0; i < creatureLists.size() + 1; i++) {
			System.out.println();
		}
		
		int creatureCount = 0;
		
		// Output strings of everything
		for(int i = 0; i < creatureLists.size(); i++) {
			System.out.println("Species " + i + " (" + creatureFactories.get(i).getEatingBehaviorLetter() + "): " + creatureLists.get(i).size());
			for(int j = 0; j < creatureLists.get(i).size(); j++) {
				creatureCount++;
			}
		}
		
		System.out.println("Total amount of creatures is: " + creatureCount);
		//System.out.println("Plant amount: " + plantAmount);

	}
	
	public void displayWorldGraphics(Graphics g) {
		int creatureCount = 0;
		
		// Display creatures
		for(int i = 0; i < creatureLists.size(); i++) {
			for(int j = 0; j < creatureLists.get(i).size(); j++) {
				creatureCount++;
				creatureLists.get(i).get(j).displayGraphics(g, TILE_SIZE);
			}
		}
		
		// Display plants
		for(int i = 0; i < plantList.size(); i++) {
			plantList.get(i).displayGraphics(g, TILE_SIZE);;
		}
		
		// Display selected creature's info
		if (selectedCreature != null) {
			selectedCreature.displayInfo(g, WORLD_HEIGHT, WORLD_WIDTH, TILE_SIZE);
		}
		
	}
	
	public void displaySpecies() {
		// Output strings of everything
		for(int i = 0; i < creatureLists.size(); i++) {
			if(creatureLists.get(i).size() > 0) {
				System.out.println("Species " + i + ":" + creatureLists.get(i).get(0));
			}
		}
	}
	
	// Gets a random creature (currently used temporarily for finding a creature to eat)
	public Creature getRandomCreature() {
		List<Creature> randomSpecies = creatureLists.get(ThreadLocalRandom.current().nextInt(0, creatureLists.size()));
		if (randomSpecies.size() > 0) {
			return randomSpecies.get(ThreadLocalRandom.current().nextInt(0, randomSpecies.size()));
		} else {
			return getRandomCreature();
		}
	}
	
	public int getWorldWidth() { return WORLD_WIDTH; }
	public int getWorldHeight() { return WORLD_HEIGHT; }

}
