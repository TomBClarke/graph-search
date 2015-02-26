package search;

import java.util.LinkedHashMap;
import java.util.Map;

import maybe.*;

//We represent a graph as table of pairs (contents, node with that contents).
//This assumes that each node has a unique contents.
//This is a minimal class so that a graph can be created.

/**
 * A graph used in searching.
 * 
 * @author Tom
 *
 * @param <A>
 */
public class Graph<A> {
	
	private Map<A,Node<A>> nodes;

	/**
	 * Creates a empty map, with chosen implementation.
	 */
	public Graph() {
		nodes = new LinkedHashMap<A,Node<A>>();
	}

	/**
	 * Creates or returns a node dependant upon if it already exsists.
	 * 
	 * @param c The node content/hash key.
	 * @return The node.
	 */
	public Node<A> nodeWith(A c) { 
		Node<A> node;
		
	    if (nodes.containsKey(c)) {
	      node = nodes.get(c);
	    } else {
	      node = new Node<A>(c);
	      nodes.put(c,node);
	    }
	    
	    return node;
	}
	
	public Maybe<Node<A>> getNode(A c){
	    if (nodes.containsKey(c)){
	    	return new Just<Node<A>>(nodes.get(c));
	    }
		return new Nothing<Node<A>>();
	}

	/**
	 * Gives the map of nodes.
	 * 
	 * @return The nodes.
	 */
	public Map<A,Node<A>> getNodes() {
		return nodes;
	}
}
