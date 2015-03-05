package search;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import ilist.*;
import maybe.*;

public class AStarSearch<A> {
	
	public void search(Node<A> origin, Node<A> destination, Function2<A,Double> h, Function2<A,Double> d){
		System.out.println("Node found: " + findNodeFrom(origin, destination, h, d).fromMaybe());
		System.out.println("Path found: " + findPathFrom(origin, destination, h, d).fromMaybe());
	}
	
	public Maybe<Node<A>> findNodeFrom(Node<A> origin, Node<A> destination, Function2<A,Double> h, Function2<A,Double> d){
		Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
		Queue<Node<A>> frontier = new PriorityQueue<Node<A>>(11, new NodeComparator());
		
		origin.setG(0.0);
		origin.setF(h.apply(origin.getContent(), destination.getContent()));
				
		while(!frontier.isEmpty()){
			Node<A> n = frontier.poll();
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
						frontier.add(s);
					}
				}
			}
		}
		return new Nothing<Node<A>>();		
	}
	
	public Maybe<IList<Node<A>>> findPathFrom(Node<A> origin, Node<A> destination, Function2<A,Double> h, Function2<A,Double> d){
		Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
		Queue<Node<A>> frontier = new PriorityQueue<Node<A>>(11, new NodeComparator());
		Map<Node<A>,Node<A>> pred = new LinkedHashMap<Node<A>,Node<A>>(); 
		
		origin.setG(0.0);
		origin.setF(h.apply(origin.getContent(), destination.getContent()));
				
		while(!frontier.isEmpty()){
			Node<A> n = frontier.poll();
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
						frontier.add(s);
					}
				}
			}
		}

		return new Nothing<IList<Node<A>>>();
	}
}
