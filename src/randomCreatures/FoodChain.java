package randomCreatures;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import randomCreatures.Creature.*;
import randomCreatures.CreatureFactory.CreatureFactory;
import randomCreatures.CreatureFactoryFactory.CreatureFactoryFactory;
/*
 * A representation of the food chains of creatures using a tree data structure,
 * with CreatureFactories (or some form of Creature ID?) contained in the nodes.
 * 
 * This class will also function as the subject of an observer pattern, with all
 * Creature objects being the clients in order to keep 
 */
public class FoodChain {
	
	// NOTE: All creation of CreatureFactories in this class will eventually be handled by CreatureFactoryFactories
	
	// Variables
	private DefaultTreeModel foodChainTree;
	private int nextAvailableId = 0;
	private CreatureFactoryFactory creatureFactoryFactory;
	
	// Constructor
	public FoodChain(CreatureFactoryFactory creatureFactoryFactory) {
		
		this.creatureFactoryFactory = creatureFactoryFactory;
		
		// Create the tree with 0 as the root
		foodChainTree = new DefaultTreeModel(new DefaultMutableTreeNode(nextAvailableId, true));
		
	}
	
	public DefaultTreeModel getFoodChain() {
		return foodChainTree;
	}
	
	// Will eventually be passed a CreatureFactoryFactory to use?
	public CreatureFactory addSpecies() {
		
		// Change this so that it uses a creatureFactoryFactory instead
		CreatureFactory newCreatureFactory  = creatureFactoryFactory.createCreatureFactory(nextAvailableId);
		
		// Add id to the tree (unless this is the first species, then just increase the id since we already have one)
		if (nextAvailableId == 0) {
			nextAvailableId++;
		} else {
			// Get the id from the new creature factory and add it to the tree
			foodChainTree.insertNodeInto(new DefaultMutableTreeNode(nextAvailableId++, true), (MutableTreeNode) foodChainTree.getRoot(), 0);
		}
		
		// Return the newly made creature factory
		return newCreatureFactory;
		
	}

}
