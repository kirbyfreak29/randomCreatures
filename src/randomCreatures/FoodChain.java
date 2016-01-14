package randomCreatures;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import randomCreatures.Creature.*;
import randomCreatures.CreatureFactory.CreatureFactory;
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
	
	// Constructor
	public FoodChain() {
		
		// Create the tree with a CreatureFactory as a root
		foodChainTree = new DefaultTreeModel(new DefaultMutableTreeNode(new CreatureFactory(0, new ShapeSquare(), new ColorBlue()), true));
		
		// Add some CreatureFactories as nodes
		((DefaultMutableTreeNode) foodChainTree.getRoot()).insert(new DefaultMutableTreeNode(new CreatureFactory(1, new ShapeTriangle(), new ColorBlue()), true), 0);
		((DefaultMutableTreeNode) foodChainTree.getRoot()).insert(new DefaultMutableTreeNode(new CreatureFactory(2, new ShapeSquare(), new ColorRed()), true), 1);
		
	}
	
	public DefaultTreeModel getFoodChain() {
		return foodChainTree;
	}
	
	// Will eventually be passed a CreatureFactoryFactory to use?
	public CreatureFactory addCreatureFactory() {
		
		// Make a creature factory here
		
		// Get the id from the new creature factory and add it to the tree
		foodChainTree.insertNodeInto(new DefaultMutableTreeNode(0, true), (MutableTreeNode) foodChainTree.getRoot(), 0);
		
		// Return the newly made creature factory
		return (CreatureFactory) ((DefaultMutableTreeNode) foodChainTree.getRoot()).getUserObject();
		
	}

}
