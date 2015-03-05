package search;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Creates a node. It has content and can connect to other nodes in a garph.
 * 
 * @author Tom
 *
 * @param <A> The type of content stored in the node.
 */
public class Node<A> { 
	
	private A nodeContent; 
	private Set<Node<A>> successors;
	private Double f;
	private Double g;
	//f=g+h
	
	/**
	 * Creates node with content. The implementation for the successors is also defined here.
	 * 
	 * @param nodeContent The content of the node.
	 */
	public Node(A nodeContent){
		this.nodeContent = nodeContent;
		successors = new LinkedHashSet<Node<A>>();
		g = Double.MAX_VALUE;
	}
	
	public String toString(){
		return "Node: " + nodeContent.toString(); // + " Successors: " + successors.size();
	}
	
	/**
	 * Gets the node content.
	 * 
	 * @return The node content.
	 */
	public A getContent(){
		return nodeContent;
	}
	
	/**
	 * Gets the successors.
	 * 
	 * @return The successors.
	 */
	public Set<Node<A>> getSuccessors(){
		return successors;
	}
	
	public Double getF(){
		return f;
	}
	
	public Double getG(){
		return g;
	}
	
	public void setF(Double f){
		this.f = f;
	}
	
	public void setG(Double g){
		this.g = g;
	}
	
	/**
	 * Tests if two nodes are connected.
	 * 
	 * @param node The node that we want to test for a connection for.
	 * @return Whether this node is connected to another node.
	 */
	public boolean isConnected(Node<A> node){
		return successors.contains(node);
	}
	
	/**
	 * Adds a successor to the node.
	 * 
	 * @param node The node to add.
	 */
	public void addSuccessor(Node<A> node){
		successors.add(node);
	}
	
	/**
	 * Tests for if the node has equal contents to what it's being compared to.
	 * 
	 * @param c The input to be compared to.
	 * @return Whether the two are equal or not.
	 */
	public boolean contentsEquals(A c) {
		return nodeContent.equals(c);
	}
	
	/**
	 * Removes a successor from the successors.
	 * 
	 * @param node The node to remove.
	 */
	public void removeSuccessor(Node<A> node){
		successors.remove(node);
	}
}
