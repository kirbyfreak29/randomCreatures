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

/**
 * Represents the world of the simulation
 * 
 * @author kirbyfreak29
 *
 */
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
	
	/**
	 * Constructor
	 */
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
	
	/**
	 * Code to be performed every step
	 */
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
	
	/**
	 * Adds a new randomly created Creature Factory to the list, creates a random amount of creatures, and then adds the id to the tree
	 * NOTE: Should I merge this together with populate world?
	 */
	public void addNewSpecies() {
		
		// Add id to the tree and get the new factory (the FoodChain makes the new factory and adding the id to the tree)
		CreatureFactory newFactory = foodChain.addSpecies();
		
		// Add the new factory to the hash map with its id as the key
		creatureFactories.put(newFactory.getID(), newFactory);
		
		// Add the a creature List for the new species
		creatureLists.put(newFactory.getID(), new ArrayList<Creature>());
	}
	
	/**
	 * Loops through the FoodChain and adds creatures for each node
	 */
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
	
	/**
	 * Adds the specified amount of creature instances
	 * 
	 * @param id		int, the id of the creature's species
	 * @param amount	int, the amount of creature's to add
	 * @param x			int, the x-coordinate to add the creature's at
	 * @param y			int, the y-coordinate to add the creature's at
	 */
	public void addCreature(int id, int amount, int x, int y) {
		for(int i = 0; i < amount; i++) {
			creatureLists.get(id).add(creatureFactories.get(id).createCreature(x, y));
		}
	}
	
	/**
	 * Destroys dead creatures from the world and removes them from the creature list
	 */
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
	
	/**
	 * Gets rid of plants that have no more food left
	 */
	public void clearDeadPlants() {
		for(int i = 0; i < plantList.size(); i++) {
			if (plantList.get(i).getDepleted()) {
				plantList.remove(i);
			}
		}
	}
	
	/**
	 * Gets some food from a random plant in the world
	 * 
	 * @return	Food, a Food object from the random plant
	 */
	public Food getFoodFromRandomPlant() {
		if (plantList.size() > 0) {
			
			// Get food from a random plant
			int randomPlant = ThreadLocalRandom.current().nextInt(0, plantList.size());
			return plantList.get(randomPlant).beEaten();
			
		} else {
			//System.out.println("returned blank food");
			return new Food(0);
		}
	}
	
	/**
	 * Gets food from a random plant
	 * NOTE: Uh, why do I have the same function twice with two different names?  I should look into this,
	 * I must have had SOME reason...  Stupidity is a likely one.
	 * 
	 * @return	Food, a Food object from the random plant
	 */
	public Plant getPlant() {
		if (plantList.size() > 0) {
			
			// Get food from a random plant
			int randomPlant = ThreadLocalRandom.current().nextInt(0, plantList.size());
			return plantList.get(randomPlant);
			
		}
		return null;
	}
	
	/**
	 * Adds a new plant at a random location with a random food value
	 */
	public void addPlant() {
		plantList.add(new Plant(ThreadLocalRandom.current().nextInt(0, WORLD_WIDTH), 
				ThreadLocalRandom.current().nextInt(0, WORLD_HEIGHT), ThreadLocalRandom.current().nextInt(10, 15),
				ThreadLocalRandom.current().nextInt(5, 25), TILE_SIZE));
	}
	
	/**
	 * Adds a random amount of plants to the world
	 * NOTE: Should change this so that the random numbers are controlled by the 2 parameters
	 */
	public void growMorePlants() {
		//plantAmount += ThreadLocalRandom.current().nextInt(300, 500);
		int toGrow = ThreadLocalRandom.current().nextInt(1, 3);
		while (plantList.size() <= plantCap && toGrow > 0) {
			addPlant();
			toGrow--;
		}
	}
	
	/**
	 * Adds the given amount of creatures at the given location to the world to the list of creatures to make
	 * 
	 * @param id		int, the id of the creature's species
	 * @param amount	int, the amount of creature's to add
	 * @param x			int, the x-coordinate to add the creature's at
	 * @param y			int, the y-coordinate to add the creature's at
	 */
	public void addCreatureToBirthList(int id, int amount, int x, int y) {
		creatureFactories.get(id).addCreatureToBirthList(amount, x, y);
	}
	
	/**
	 * Creates all the creatures that are waiting to be created
	 */
	public void birthCreatures() {
		for(int i = 0; i < creatureFactories.size(); i++) {
			int birthAmount = creatureFactories.get(i).getBirthList();
			for(int j = 0; j < birthAmount; j++) {
				creatureLists.get(i).add(creatureFactories.get(i).createCreatureFromBirthList());
			}
		}
	}
	
	/**
	 * Perform a click.  If a creature is under the mouse, select it.  Otherwise, unselect any selected creature.
	 * If multiple creatures are under the mouse, select a random one
	 * 
	 * @param clickX	int, the x-coordinate that was clicked
	 * @param clickY	int, the y-coordinate that was clicked
	 */
	public void clickCreature(int clickX, int clickY) {
		
		// Put all creatures in one list
		allCreatures = new ArrayList<Creature>();
		for(int i = 0; i < creatureLists.size(); i++) {
			allCreatures.addAll(creatureLists.get(i));
		}
		
		// Shuffle the list so that every creature has a chance to be the one selected if it shares a space with another creature
		Collections.shuffle(allCreatures);
		
		// Loop through all the creatures and see if any are under the mouse.  If there is, select it.
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
		
		// If no creature was selected, unselect and currently selected creatures
		if (selectedCreature != null) {
			selectedCreature.setCurrentlySelected(false);
		}
		selectedCreature = null;
	}
	
	/**
	 * Display the world textually
	 */
	public void displayWorld() {
		
		// Spacing in the console
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
	
	/**
	 * Display the world graphically
	 * 
	 * @param g	Graphics, the Graphics object to display to
	 */
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
		
		// Display selected creature's info and highlight it
		if (selectedCreature != null && !selectedCreature.getDead()) {
			selectedCreature.displayInfo(g, WORLD_HEIGHT, WORLD_WIDTH, TILE_SIZE);
			selectedCreature.highlightCreature(g, TILE_SIZE);
		}
		
	}
	
	/**
	 * Print out a text based summary of every species
	 */
	public void displaySpecies() {
		// Output strings of everything
		for(int i = 0; i < creatureLists.size(); i++) {
			if(creatureLists.get(i).size() > 0) {
				System.out.println("Species " + i + ":" + creatureLists.get(i).get(0));
			}
		}
	}
	
	/**
	 * Gets a random creature (currently used temporarily for finding a creature to eat)
	 * 
	 * @return	Creature, the random Creature
	 */
	public Creature getRandomCreature() {
		List<Creature> randomSpecies = creatureLists.get(ThreadLocalRandom.current().nextInt(0, creatureLists.size()));
		if (randomSpecies.size() > 0) {
			return randomSpecies.get(ThreadLocalRandom.current().nextInt(0, randomSpecies.size()));
		} else {
			return getRandomCreature();
		}
	}
	
	// Getters and Setters
	public int getWorldWidth() { return WORLD_WIDTH; }
	public int getWorldHeight() { return WORLD_HEIGHT; }

}