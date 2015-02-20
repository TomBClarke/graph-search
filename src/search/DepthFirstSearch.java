package search;

import graph.Coordinate;
import graph.Graph;
import graph.Node;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;

/**
 * Performs a search on a graph.
 * 
 * @author Tom
 *
 * @param <A>
 */
public class DepthFirstSearch<A> {

	/**
	 * Runs a depth first search on a graph.
	 * 
	 * @param graph The graph to perform a search on.
	 * @param sn The start node content.
	 * @param tg The end node content (used in the predicate).
	 */
	public DepthFirstSearch(Graph<A> graph, A sn, A tg) {
		Predicate<A> condition = new Predicate<A>() {
			@Override
			public boolean holds(A a) {
				return a.equals(tg);
			}
		};
		System.out.println(findNodeFrom(graph.getNodes().get(sn), condition));
	}

	/**
	 * Returns the target node if found.
	 * 
	 * @param x The start node.
	 * @param p The predicate the end node must satisfy.
	 * @return Returns the target node if found, or Nothing if not.
	 */
	Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p) {
		Stack<Node<A>> frontier = new Stack<Node<A>>();
		Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
		frontier.push(x);
		while (!frontier.empty()) {
			Node<A> y = frontier.pop();
			if (!visited.contains(y)) {
				if (p.holds(y.getContent())) {
					return new Just<Node<A>>(y);
				}
				visited.add(y);
				for(Node<A> n : y.getSuccessors()){
					frontier.push(n);
				}
			}
		}
		return new Nothing<Node<A>>();
	}

	/**
	 * Finds a path from a start node to a target one.
	 * 
	 * @param x The start node.
	 * @param p The predicate the end node must satisfy.
	 * @return The list of nodes to pass through to get to the target, or nothing if it can't be reached.
	 */
	Nothing<LinkedHashSet<Node<A>>> findPathFrom(Node<A> x, Predicate<A> p) {
		// TODO - This method.
		//Set<Node<A>>path = new LinkedHashSet<Node<A>>();
		return new Nothing<LinkedHashSet<Node<A>>>();
	}

	public static void main(String[] args) {
		int [] [] nick = {
			{0,0,1,0,0,1}, 
			{0,1,0,0,1,1,0,2}, 
			{0,2,0,3,0,1}, 
			{0,3,0,2,0,4}, 
			{0,4,0,3,0,5}, 
			{0,5,0,6,1,5,0,4}, 
			{0,6,1,6,0,5}, 
			{1,0,0,0,1,1,2,0}, 
			{1,1,1,2,2,1,1,0,0,1}, 
			{1,2,2,2,1,1,1,3}, 
			{1,3,1,2,1,4,2,3}, 
			{1,4,2,4,1,5,1,3}, 
			{1,5,1,4,2,5,1,6,0,5}, 
			{1,6,0,6,1,5,2,6}, 
			{2,0,3,0,2,1,1,0}, 
			{2,1,2,2,1,1,2,0,3,1}, 
			{2,2,1,2,2,1,2,3,3,2}, 
			{2,3,2,2,2,4,3,3,1,3}, 
			{2,4,1,4,2,5,2,3,3,4}, 
			{2,5,2,4,1,5,2,6,3,5}, 
			{2,6,3,6,2,5,1,6}, 
			{3,0,2,0,3,1}, 
			{3,1,3,0,4,1,2,1,3,2}, 
			{3,2,2,2,4,2,3,1}, 
			{3,3,2,3,3,4}, 
			{3,4,2,4,3,3}, 
			{3,5,3,6,2,5,4,5}, 
			{3,6,2,6,3,5}, 
			{4,0}, 
			{4,1,4,2,5,1,3,1}, 
			{4,2,4,1,5,2,3,2}, 
			{4,3}, 
			{4,4}, 
			{4,5,5,5,3,5}, 
			{4,6}, 
			{5,0}, 
			{5,1,4,1,5,2,6,1}, 
			{5,2,4,2,5,1,6,2}, 
			{5,3}, 
			{5,4}, 
			{5,5,4,5,6,5}, 
			{5,6}, 
			{6,0,7,0,6,1}, 
			{6,1,6,0,5,1,6,2,7,1}, 
			{6,2,5,2,6,1,7,2}, 
			{6,3,7,3,6,4}, 
			{6,4,6,3,7,4}, 
			{6,5,5,5,6,6,7,5}, 
			{6,6,7,6,6,5}, 
			{7,0,6,0,7,1,8,0}, 
			{7,1,8,1,7,0,6,1,7,2}, 
			{7,2,7,3,8,2,6,2,7,1}, 
			{7,3,6,3,7,2,7,4,8,3}, 
			{7,4,7,3,8,4,6,4,7,5}, 
			{7,5,8,5,7,6,7,4,6,5}, 
			{7,6,6,6,7,5,8,6}, 
			{8,0,8,1,7,0,9,0}, 
			{8,1,8,2,9,1,7,1,8,0}, 
			{8,2,8,1,7,2,8,3}, 
			{8,3,8,2,7,3,8,4}, 
			{8,4,8,5,8,3,7,4}, 
			{8,5,9,5,8,4,7,5,8,6}, 
			{8,6,8,5,7,6,9,6}, 
			{9,0,9,1,8,0}, 
			{9,1,8,1,9,2,9,0}, 
			{9,2,9,1,9,3}, 
			{9,3,9,2,9,4}, 
			{9,4,9,5,9,3}, 
			{9,5,8,5,9,4,9,6}, 
			{9,6,9,5,8,6} 
		};

		Graph<Coordinate> nicksGraph = new Graph<Coordinate>();

		for (int i = 0; i < nick.length; i++) {
			assert(nick[i].length >= 2);
			assert(nick[i].length % 2 == 0);

			int x = nick[i][0]; 
			int y = nick[i][1];
			
			Coordinate c = new Coordinate(x, y);

			Node<Coordinate> node = nicksGraph.nodeWith(c); 

			for (int j = 2; j < nick[i].length; j=j+2) {
				int sx = nick[i][j];   
				int sy = nick[i][j+1]; 
				Coordinate sc = new Coordinate(sx, sy);
				Node<Coordinate> s = nicksGraph.nodeWith(sc);
				node.addSuccessor(s);
			}
		}
		
		/*
		//Printing the map:
		for (Map.Entry<Coordinate,Node<Coordinate>> e : nicksGraph.getNodes().entrySet()) {
		      Coordinate c = e.getKey();
		      Node<Coordinate> node = e.getValue();
		      assert(c.equals(node.getContent()));
		      System.out.print("(" + c.x + "," + c.y + "): ");
		      for(Node<Coordinate> s : node.getSuccessors()) {
		    	  System.out.print("(" + s.getContent().x + "," + s.getContent().y + "), ");
		      }
		      System.out.println();
		}
		*/
		
		Coordinate sn = new Coordinate(1, 0);
		Coordinate tg = new Coordinate(4, 1);
		
		new BreadthFirstSearch<Coordinate>(nicksGraph, sn, tg);
	}

}
