package stackqueue;

import search.Node;

/**
 * Define the methods required for a stack or queue to be implemented and then used in graph search.
 * 
 * @author Tom
 *
 * @param <A>
 */
public interface StackQueue<A> {

		/**
		 * Returns the top first element, and returns it. 
		 * 
		 * @return The first node.
		 */
		public Node<A> pop();
		
		/**
		 * Adds a node to the stack/queue.
		 * 
		 * @param x The node to add.
		 */
		public void push(Node<A> x);
				
		/**
		 * Checks to see if the stack/queue is empty.
		 * 
		 * @return Whether the stack/queue is empty.
		 */
		public boolean isEmpty();
		
		/**
		 * Returns if a node is in the stack/queue.
		 * 
		 * @param x The node to check for.
		 * @return If the node is round.
		 */
		public boolean contains(Node<A> x);
		
		/**
		 * Empties the stack/queue by assigning a new empty stack/queue to it.
		 */
		public void empty();
}
