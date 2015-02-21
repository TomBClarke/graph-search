package graph;

import java.util.LinkedHashSet;
import java.util.Set;

import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;

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
	
	private Set<Node<A>> nodes;

	/**
	 * Creates a empty map, with chosen implementation.
	 */
	public Graph() {
		nodes = new LinkedHashSet<Node<A>>();
	}

	/**
	 * Creates or returns a node dependant upon if it already exsists.
	 * 
	 * @param c The node content/hash key.
	 * @return The node.
	 */
	public Node<A> nodeWith(A c) { 
		for (Node<A> node : nodes) {
		    if (node.contentsEquals(c)){
		    	return node;
		    }
	    }
		Node<A> node = new Node<A>(c);
	    nodes.add(node);
	    return node;
	}
	
	public Maybe<Node<A>> getNode(A a){
		for (Node<A> node : nodes) {
		    if (node.contentsEquals(a)){
		    	return new Just<Node<A>>(node);
		    }
	    }
		return new Nothing<Node<A>>();
	}

	/**
	 * Gives the map of nodes.
	 * 
	 * @return The nodes.
	 */
	public Set<Node<A>> getNodes() {
		return nodes;
	}
}
