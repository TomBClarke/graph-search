package graph;

import java.util.ArrayList;

public class Node<A> { 
	
	private A nodeContent; 
	private ArrayList<Node<A>> successors;
	
	public Node(A nodeContent){
		this.nodeContent = nodeContent;
		this.successors = new ArrayList<Node<A>>();
	}
	
	public Node(A nodeContent, ArrayList<Node<A>> successors){
		this.nodeContent = nodeContent;
		this.successors = successors;
	}
	
	public String toString(){
		return "Node " + nodeContent.toString();
	}
	
	public A getContent(){
		return nodeContent;
	}
	
	public ArrayList<Node<A>> getSuccessors(){
		return successors;
	}
	
	public boolean isConnected(Node<A> node){
		return successors.contains(node);
	}
	
	public void addSuccessor(Node<A> node){
		successors.add(node);
	}
	
	public void removeSuccessor(Node<A> node){
		successors.remove(node);
	}
}
