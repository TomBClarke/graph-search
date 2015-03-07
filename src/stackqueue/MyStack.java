package stackqueue;

import java.util.Stack;

import search.Node;

public class MyStack<A> implements StackQueue<A> {

	private Stack<Node<A>> frontier;
	
	public MyStack(){
		frontier = new Stack<Node<A>>();
	}

	public Node<A> pop() {
		return frontier.pop();
	}

	public void push(Node<A> x) {
		frontier.push(x);
	}

	public boolean isEmpty() {
		return frontier.isEmpty();
	}

	public boolean contains(Node<A> x){
		return frontier.contains(x);
	}
}
