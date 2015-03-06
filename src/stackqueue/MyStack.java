package stackqueue;

import search.Node;
import ilist.*;

public class MyStack<A> implements StackQueue<A> {

	private IList<Node<A>> list;
	
	public MyStack(){
		list = new Nil<Node<A>>();
	}

	public Node<A> pop() {
		Node<A> a = list.head();
		list = list.tail();
		return a;
	}

	public void push(Node<A> x) {
		list = list.reverse().append(x).reverse();
		
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

}
