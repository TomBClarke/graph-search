package search;

import java.util.ArrayList;
import java.util.Stack;
import java.util.function.Predicate;

import graph.Node;
import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;

public class DepthFirstSearch<A> {

	private ArrayList<Node<A>> visited;
	private ArrayList<Node<A>> path;
	
	Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p){		
		Stack<Node<A>> stack = new Stack<Node<A>>();
		stack.push(x);
		while(!stack.empty()){
			Node<A> y = stack.pop();
			if(visited.contains(y)){
				if(y.equals(p)){
					return new Just<Node<A>>(y);
				}
				visited.add(y);
				for(int i = 0; i < y.getSuccessors().size(); i++){
					stack.push(y.getSuccessors().get(i));
				}
			}
		}
		return new Nothing<Node<A>>();
	}
	
	Maybe<ArrayList<Node<A>>> findPathFrom(Node<A> x, Predicate<A> p){
		//TODO - This method.
		return new Nothing<ArrayList<Node<A>>>();
	}
	
	public static void main(String[] args) {
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
		
		DepthFirstSearch<Integer> dfs = new DepthFirstSearch<Integer>();
		
		dfs.findNodeFrom(node1, 9);
	}

}
