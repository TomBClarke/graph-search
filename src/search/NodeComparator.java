package search;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	public int compare(Node x, Node y) {
		if(x.getF() > y.getF()){
			return 1;
		} else if (y.getF() > x.getF()) {
			return -1;
		} else {
			return 0;
		}
	}

}
