package graph;

import ilist.IList;

public class Map<A> {
	
	private IList<Node<A>> map;
	
	public Map(){
		
	}
	
	public Node<A> createNode(A nodeContent, IList<Node<A>> successors){
		Node<A> newNode = new Node<A>(nodeContent, successors);
		return newNode;
	}
	
	public void addNode(Node<A> node){
		map.append(node);
	}
	
}
