package search;

import java.util.Comparator;

/**
 * Used to order the priority queue in the search.
 * 
 * 
 * @author Tom
 *
 */
public class NodeComparator<A> implements Comparator<Node<A>> {

	public int compare(Node<A> x, Node<A> y) {
		if(x.getF() > y.getF()){
			return 1;
		} else if (y.getF() > x.getF()) {
			return -1;
		} else {
			return 0;
		}
	}

}
