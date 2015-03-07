package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

import search.Node;

public class MyQueue<A> implements StackQueue<A> {

	private Queue<Node<A>> frontier;

	public MyQueue(){
		frontier = new LinkedList<Node<A>>();
	}
	
	public Node<A> pop() {
		return frontier.poll();
	}

	public void push(Node<A> x) {
		frontier.add(x);
	}
	
	public boolean isEmpty() {
		return frontier.isEmpty();
	}

	public boolean contains(Node<A> x){
		return frontier.contains(x);
	}
	
	public void empty(){
		frontier = new LinkedList<Node<A>>();
	}
}
