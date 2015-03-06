package stackqueue;

import search.Node;
import ilist.*;

public class MyQueue<A> implements StackQueue<A> {

	private IList<Node<A>> list;

	public MyQueue(){
		list = new Nil<Node<A>>();
	}
	
	public Node<A> pop() {
		Node<A> a = list.head();
		list = list.tail();
		return a;
	}

	public void push(Node<A> a) {
		list = list.append(a);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
		}

}
