package search;

import graph.Map;
import graph.Node;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;

public class DepthFirstSearch<A> {

	public DepthFirstSearch(ArrayList<Node<A>> map) {
		Predicate<A> condition = new Predicate<A>() {
			public boolean holds(A a) {
				return a.equals(new Point(9, 0));
			}
		};
		System.out.println(findNodeFrom(map.get(calIndexInList(0, 0)), condition));
	}

	/**
	 * Only meant for grids.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int calIndexInList(int x, int y) {
		int a = 0;
		boolean repeat = true;
		while (repeat) {
			if (x > 0) {
				a += 7;
				x--;
			} else {
				repeat = false;
			}
		}
		a = a + y;
		return a;
	}

	Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p) {
		Stack<Node<A>> stack = new Stack<Node<A>>();
		ArrayList<Node<A>> visited = new ArrayList<Node<A>>();
		stack.push(x);
		while (!stack.empty()) {
			Node<A> y = stack.pop();
			if (!visited.contains(y)) {
				if (p.holds(y.getContent())) {
					return new Just<Node<A>>(y);
				}
				visited.add(y);
				for (int i = 0; i < y.getSuccessors().size(); i++) {
					stack.push(y.getSuccessors().get(i));
				}
			}
		}
		return new Nothing<Node<A>>();
	}

	Maybe<ArrayList<Node<A>>> findPathFrom(Node<A> x, Predicate<A> p) {
		// TODO - This method.
		ArrayList<Node<A>>path = new ArrayList<Node<A>>();
		return new Nothing<ArrayList<Node<A>>>();
	}

	public static void main(String[] args) {
		Map mapObj = new Map();
		new DepthFirstSearch<Point>(mapObj.getMap());
	}

}
