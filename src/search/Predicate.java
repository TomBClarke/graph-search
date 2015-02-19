package search;

public interface Predicate<A> {
	boolean holds(A a);
}
