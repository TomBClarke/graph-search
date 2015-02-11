package graph;

import ilist.IList;
import ilist.Nil;

public class Node<A> { 
	
	private A nodeContent; 
	private IList<Node<A>> successors;
	
	public Node(A nodeContent, IList<Node<A>> successors){
		this.nodeContent = nodeContent;
		this.successors = successors;
	}
	
	public A getContent(){
		return nodeContent;
	}
	
	public IList<Node<A>> getSuccessors(){
		return successors;
	}
	
	public boolean isConnected(Node<A> node){
		return successors.has(node);
	}
	
	public void addSuccessor(Node<A> node){
		successors.append(node);
	}
	
	public void removeSuccessor(Node<A> node){
		//TODO - THIS METHOD
		
		/*
		if(successors.has(node)){
			IList<Node<A>> newSuccessors = new IList<Node<A>>(new Nil());
			
			successors = newSuccessors;
		}else{
			
		}
		*/
	}
}
