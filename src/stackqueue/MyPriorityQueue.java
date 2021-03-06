package stackqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import search.Node;

public class MyPriorityQueue<A> implements StackQueue<A> {

	private Queue<Node<A>> frontier;
	private int n;
	private Comparator<Node<A>> comp;
	
	public MyPriorityQueue(int n, Comparator<Node<A>> comp) {
		this.n = n;
		this.comp = comp;
		frontier = new PriorityQueue<Node<A>>(n, comp);
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
		frontier = new PriorityQueue<Node<A>>(n, comp);
	}

}
