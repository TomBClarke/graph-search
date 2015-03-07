package search;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import ilist.*;
import maybe.*;
import stackqueue.*;

public class Search<A> {
	
	//BFS & DFS:
	
	/**
	 * Returns the target node if found.
	 * 
	 * @param x The start node.
	 * @param p The predicate the end node must satisfy.
	 * @return Returns the target node if found, or Nothing if not.
	 */
	public Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p, StackQueue<A> frontier) {
		Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
		frontier.push(x);
		while (!frontier.isEmpty()) {
			Node<A> y = frontier.pop();
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
	public Maybe<IList<Node<A>>> findPathFrom(Node<A> x, Predicate<A> p, StackQueue<A> frontier) {
		Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
		Map<Node<A>,Node<A>> path = new LinkedHashMap<Node<A>,Node<A>>();
		
		frontier.push(x);
		while (!frontier.isEmpty()) {
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
	
	//A*:
	
	/**
	 * Performs a search on a graph.
	 * 
	 * @param origin The start node.
	 * @param destination The end node.
	 * @param h The heuristic function.
	 * @param d The distance between two nodes function.
	 * @return The node found.
	 */
	public Maybe<Node<A>> findNodeFrom(Node<A> origin, Node<A> destination, Function2<A,Double> h, Function2<A,Double> d, StackQueue<A> frontier){
		Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
		
		frontier.push(origin);
		origin.setG(0.0);
		origin.setF(h.apply(origin.getContent(), destination.getContent()));
				
		while(!frontier.isEmpty()){
			Node<A> n = frontier.pop();
			if(n.equals(destination)) { 
				return new Just<Node<A>>(n);
			}
			visited.add(n);
			for(Node<A> s : n.getSuccessors()){
				Double cost = n.getG() + d.apply(n.getContent(), s.getContent());
				if(!visited.contains(s) || cost < s.getG()){
					s.setG(cost);
					s.setF(s.getG() + h.apply(s.getContent(), destination.getContent()));
					if(!frontier.contains(s)){
						frontier.push(s);
					}
				}
			}
		}
		return new Nothing<Node<A>>();		
	}	
	
	/**
	 * Performs a search on a graph.
	 * 
	 * @param origin The start node.
	 * @param destination The end node.
	 * @param h The heuristic function.
	 * @param d The distance between two nodes function.
	 * @return The path to the destination node.
	 */
	public Maybe<IList<Node<A>>> findPathFrom(Node<A> origin, Node<A> destination, Function2<A,Double> h, Function2<A,Double> d, StackQueue<A> frontier){
		Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
		Map<Node<A>,Node<A>> pred = new LinkedHashMap<Node<A>,Node<A>>(); 
		
		frontier.push(origin);
		origin.setG(0.0);
		origin.setF(h.apply(origin.getContent(), destination.getContent()));

		while(!frontier.isEmpty()){
			Node<A> n = frontier.pop();
			if(n.equals(destination)) {
				IList<Node<A>> pathList = new Cons<Node<A>>(destination, new Nil<Node<A>>());
				while(!pred.get(destination).equals(origin)){
					pathList = pathList.append(pred.get(destination));
					destination = pred.get(destination);
				}
				pathList = pathList.append(origin);
				pathList = pathList.reverse();
				return new Just<IList<Node<A>>>(pathList);
			}
			visited.add(n);
			for(Node<A> s : n.getSuccessors()){
				Double cost = n.getG() + d.apply(n.getContent(), s.getContent());
				if(!visited.contains(s) || cost < s.getG()){
					pred.put(s, n);
					s.setG(cost);
					s.setF(s.getG() + h.apply(s.getContent(), destination.getContent()));
					if(!frontier.contains(s)){
						frontier.push(s);
					}
				}
			}
		}

		return new Nothing<IList<Node<A>>>();
	}
}
