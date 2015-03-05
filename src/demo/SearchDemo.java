package demo;

import java.util.Map;

import search.*;

public class SearchDemo {
	
	public static void main(String args[]){
		int [] [] nick = {
			{0,0,1,0,0,1}, 
			{0,1,0,0,1,1,0,2}, 
			{0,2,0,3,0,1}, 
			{0,3,0,2,0,4}, 
			{0,4,0,3,0,5}, 
			{0,5,0,6,1,5,0,4}, 
			{0,6,1,6,0,5}, 
			{1,0,0,0,1,1,2,0}, 
			{1,1,1,2,2,1,1,0,0,1}, 
			{1,2,2,2,1,1,1,3}, 
			{1,3,1,2,1,4,2,3}, 
			{1,4,2,4,1,5,1,3}, 
			{1,5,1,4,2,5,1,6,0,5}, 
			{1,6,0,6,1,5,2,6}, 
			{2,0,3,0,2,1,1,0}, 
			{2,1,2,2,1,1,2,0,3,1}, 
			{2,2,1,2,2,1,2,3,3,2}, 
			{2,3,2,2,2,4,3,3,1,3}, 
			{2,4,1,4,2,5,2,3,3,4}, 
			{2,5,2,4,1,5,2,6,3,5}, 
			{2,6,3,6,2,5,1,6}, 
			{3,0,2,0,3,1}, 
			{3,1,3,0,4,1,2,1,3,2}, 
			{3,2,2,2,4,2,3,1}, 
			{3,3,2,3,3,4}, 
			{3,4,2,4,3,3}, 
			{3,5,3,6,2,5,4,5}, 
			{3,6,2,6,3,5}, 
			{4,0}, 
			{4,1,4,2,5,1,3,1}, 
			{4,2,4,1,5,2,3,2}, 
			{4,3}, 
			{4,4}, 
			{4,5,5,5,3,5}, 
			{4,6}, 
			{5,0}, 
			{5,1,4,1,5,2,6,1}, 
			{5,2,4,2,5,1,6,2}, 
			{5,3}, 
			{5,4}, 
			{5,5,4,5,6,5}, 
			{5,6}, 
			{6,0,7,0,6,1}, 
			{6,1,6,0,5,1,6,2,7,1}, 
			{6,2,5,2,6,1,7,2}, 
			{6,3,7,3,6,4}, 
			{6,4,6,3,7,4}, 
			{6,5,5,5,6,6,7,5}, 
			{6,6,7,6,6,5}, 
			{7,0,6,0,7,1,8,0}, 
			{7,1,8,1,7,0,6,1,7,2}, 
			{7,2,7,3,8,2,6,2,7,1}, 
			{7,3,6,3,7,2,7,4,8,3}, 
			{7,4,7,3,8,4,6,4,7,5}, 
			{7,5,8,5,7,6,7,4,6,5}, 
			{7,6,6,6,7,5,8,6}, 
			{8,0,8,1,7,0,9,0}, 
			{8,1,8,2,9,1,7,1,8,0}, 
			{8,2,8,1,7,2,8,3}, 
			{8,3,8,2,7,3,8,4}, 
			{8,4,8,5,8,3,7,4}, 
			{8,5,9,5,8,4,7,5,8,6}, 
			{8,6,8,5,7,6,9,6}, 
			{9,0,9,1,8,0}, 
			{9,1,8,1,9,2,9,0}, 
			{9,2,9,1,9,3}, 
			{9,3,9,2,9,4}, 
			{9,4,9,5,9,3}, 
			{9,5,8,5,9,4,9,6}, 
			{9,6,9,5,8,6} 
		};
		
		Graph<MyPoint> nicksGraph = new Graph<MyPoint>();
	
		for (int i = 0; i < nick.length; i++) {
			assert(nick[i].length >= 2);
			assert(nick[i].length % 2 == 0);
	
			int x = nick[i][0]; 
			int y = nick[i][1];
			
			MyPoint c = new MyPoint(x, y);
	
			Node<MyPoint> node = nicksGraph.nodeWith(c); 
	
			for (int j = 2; j < nick[i].length; j=j+2) {
				int sx = nick[i][j];   
				int sy = nick[i][j+1]; 
				MyPoint sc = new MyPoint(sx, sy);
				Node<MyPoint> s = nicksGraph.nodeWith(sc);
				node.addSuccessor(s);
			}
		}
		
		/*
		//Printing the map:
		for (Map.Entry<MyPoint,Node<MyPoint>> e : nicksGraph.getNodes().entrySet()) {
			MyPoint c = e.getKey();
		    Node<MyPoint> node = e.getValue();
		    assert(c.equals(node.getContent()));
		    System.out.print("(" + c.x + "," + c.y + "): ");
		    for(Node<MyPoint> s : node.getSuccessors()) {
		    	System.out.print("(" + s.getContent().x + "," + s.getContent().y + "), ");
		    }
		    System.out.println();
		}
		*/
		
		MyPoint sn = new MyPoint(0, 0);
		MyPoint tg = new MyPoint(9, 1);
		
		DepthFirstSearch<MyPoint> dfs = new DepthFirstSearch<MyPoint>();
		BreadthFirstSearch<MyPoint> bfs = new BreadthFirstSearch<MyPoint>();
		AStarSearch<MyPoint> astar = new AStarSearch<MyPoint>();
		
		System.out.println("Depth first search:");
		dfs.search(nicksGraph, sn, tg);
		System.out.println("Breadth first search:");
		bfs.search(nicksGraph, sn, tg);
		
		
		
		System.out.println("A Star Search");
		//astar.search(origin, destination, new Function<MyPoint,Double>(), d);
	}

}
