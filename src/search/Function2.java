package search;

/**
 * Defines what the heuristic and distance functions must do.
 * 
 * @author Tom
 *
 * @param <A> The type of node.
 * @param <B> The return type.
 */
public interface Function2<A,B> {
	B apply(A a, A a2);

}