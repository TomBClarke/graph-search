package graph;

import java.util.ArrayList;

public class Map<A> {
	
	private ArrayList<Node<Integer>> map;
	
	public Map(){
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(6);
		Node<Integer> node7 = new Node<Integer>(7);
		Node<Integer> node8 = new Node<Integer>(8);
		Node<Integer> node9 = new Node<Integer>(9);
		
		node1.addSuccessor(node2);
		node1.addSuccessor(node4);
		node2.addSuccessor(node1);
		node2.addSuccessor(node3);
		node2.addSuccessor(node5);
		node3.addSuccessor(node2);
		node4.addSuccessor(node1);
		node4.addSuccessor(node5);
		node4.addSuccessor(node6);
		node5.addSuccessor(node4);
		node5.addSuccessor(node2);
		node5.addSuccessor(node8);
		node6.addSuccessor(node4);
		node6.addSuccessor(node7);
		node7.addSuccessor(node6);
		node7.addSuccessor(node9);
		node8.addSuccessor(node5);
		node8.addSuccessor(node9);
		node9.addSuccessor(node7);
		node9.addSuccessor(node8);
		
		map.add(node1);
		map.add(node2);
		map.add(node3);
		map.add(node4);
		map.add(node5);
		map.add(node6);
		map.add(node7);
		map.add(node8);
		map.add(node9);
	}
}
