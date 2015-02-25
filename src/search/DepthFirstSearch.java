package search;

import ilist.*;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import maybe.*;

/**
 * Performs a search on a graph.
 * 
 * @author Tom
 *
 * @param <A>
 */
public class DepthFirstSearch<A> implements Search<A> {

	/**
	 * Creates  a depth first search object.
	 */
	public DepthFirstSearch() {
		
	}
	
	/**
	 * Runs a depth first search on a graph.
	 * 
	 * @param graph The graph to perform a search on.
	 * @param sn The start node content.
	 * @param tg The end node content (used in the predicate).
	 */
	public void search(Graph<A> graph, A sn, A tg){
		Predicate<A> condition = new Predicate<A>() {
			@Override
			public boolean holds(A a) {
				return a.equals(tg);
			}
		};
		
		System.out.println("Node found: " + findNodeFrom(graph.getNode(sn).fromMaybe(), condition).fromMaybe());
		//System.out.println("Path found: " + findPathFrom(graph.getNode(sn).fromMaybe(), condition).fromMaybe());
	}

	/**
	 * Runs a search to find a node on a graph where the predicate is generated.
	 * 
	 * @param graph The graph to perform a search on.
	 * @param sn The start node content.
	 * @param tg The end node content (used in the predicate).
	 */
	public Maybe<Node<A>> findNodeSimple(Graph<A> graph, A sn, A tg) {
		Predicate<A> condition = new Predicate<A>() {
			@Override
			public boolean holds(A a) {
				return a.equals(tg);
			}
		};
		return findNodeFrom(graph.getNode(sn).fromMaybe(), condition);
	}
	
	/**
	 * Runs a search to find a path to node on a graph where the predicate is generated.
	 * 
	 * @param graph The graph to perform a search on.
	 * @param sn The start node content.
	 * @param tg The end node content (used in the predicate).
	 */
	public Maybe<IList<Node<A>>> findPathSimple(Graph<A> graph, A sn, A tg) {
		Predicate<A> condition = new Predicate<A>() {
			@Override
			public boolean holds(A a) {
				return a.equals(tg);
			}
		};
		return findPathFrom(graph.getNode(sn).fromMaybe(), condition);
	}
	
	/**
	 * Returns the target node if found.
	 * 
	 * @param x The start node.
	 * @param p The predicate the end node must satisfy.
	 * @return Returns the target node if found, or Nothing if not.
	 */
	public Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p) {
		Stack<Node<A>> frontier = new Stack<Node<A>>();
		Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
		
		frontier.push(x);
		while (!frontier.empty()) {
			Node<A> y = frontier.pop();
			//System.out.println("Using node: " + y);
			if (!visited.contains(y)) {
				if (p.holds(y.getContent())) {
					return new Just<Node<A>>(y);
				}
				visited.add(y);
				if(!y.getSuccessors().isEmpty()){
					for(Node<A> n : y.getSuccessors()){
						if(!visited.contains(n)){
							frontier.push(n);
						}
					}
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
	public Maybe<IList<Node<A>>> findPathFrom(Node<A> x, Predicate<A> p) {
		Stack<Node<A>> frontier = new Stack<Node<A>>();
		Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
		Map<Node<A>,Node<A>> path = new LinkedHashMap<Node<A>,Node<A>>();
		
		frontier.push(x);
		while (!frontier.empty()) {
			Node<A> y = frontier.pop();
			if (!visited.contains(y)) {
				if (p.holds(y.getContent())) {
					IList<Node<A>> pathList = new Cons<Node<A>>(y, new Nil<Node<A>>());
					while(!path.get(y).equals(x)){
						pathList = pathList.append(path.get(y));
						y = path.get(y);
					}
					pathList = pathList.append(x);
					pathList = pathList.reverse();
					return new Just<IList<Node<A>>>(pathList);
				}
				visited.add(y);
				if(!y.getSuccessors().isEmpty()){
					for(Node<A> n : y.getSuccessors()){
						if(!visited.contains(n)){
							frontier.push(n);
							path.put(n, y);
						}
					}
				} else {
					path.remove(y);
				}
			}
		}
		
		return new Nothing<IList<Node<A>>>();
	}

}
