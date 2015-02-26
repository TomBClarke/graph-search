package search;

import ilist.IList;
import maybe.Maybe;

public interface Search<A> {

	public void search(Graph<A> graph, A sn, A tg);
	public Maybe<IList<Node<A>>> findPathSimple(Graph<A> graph, A sn, A tg);
	public Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p);
	public Maybe<IList<Node<A>>> findPathFrom(Node<A> x, Predicate<A> p);
	public Maybe<Node<A>> findNodeSimple(Graph<A> graph, A sn, A tg);
	
}
