package demo;

import java.util.Map;
import java.util.Scanner;

import search.*;
import stackqueue.*;

/**
 * Used to demonstrate the graph search exercise.
 * 
 * 
 * @author Tom
 *
 */
public class SearchDemo<A> {
	
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
		
		//DepthFirstSearch<MyPoint> dfs = new DepthFirstSearch<MyPoint>();
		//BreadthFirstSearch<MyPoint> bfs = new BreadthFirstSearch<MyPoint>();
		//AStarSearch<MyPoint> astar = new AStarSearch<MyPoint>();		
		
		/*
		int[] points1 = getPoints();
		MyPoint sn1 = new MyPoint(points1[0], points1[1]);
		MyPoint tg1 = new MyPoint(points1[2], points1[3]);
		
		Predicate<MyPoint> condition = new Predicate<MyPoint>() {
			@Override
			public boolean holds(MyPoint a) {
				return a.equals(tg1);
			}
		};
		
		System.out.println("Node found: " + bfs.findNodeFrom(nicksGraph.getNode(sn1).fromMaybe(), condition).fromMaybe());
		System.out.println("Path found: " + bfs.findPathFrom(nicksGraph.getNode(sn1).fromMaybe(), condition).fromMaybe());
		*/
		
		
		
		
		
		
		
		
		
		Search<MyPoint> search = new Search<MyPoint>();
		
		SearchDemo<MyPoint> demo = new SearchDemo<MyPoint>();
		
		while(true) {
			Scanner input = new Scanner(System.in);
			String cmd = input.nextLine();
			if(cmd.equals("dfs")) {
				System.out.println("Using depth-first search:");
				StackQueue<MyPoint> frontier = new MyStack<MyPoint>();
				demo.searchDFSBFS(search, nicksGraph, frontier);
			} else if (cmd.equals("bfs")) {
				System.out.println("Using breadth-first search:");				
				StackQueue<MyPoint> frontier = new MyQueue<MyPoint>();
				demo.searchDFSBFS(search, nicksGraph, frontier);
			} else if (cmd.equals("astar")) {
				System.out.println("Using A* search:");
				
				int[] points = getPoints();
				MyPoint sn = new MyPoint(points[0], points[1]);
				MyPoint tg = new MyPoint(points[2], points[3]);
				
				Function2<MyPoint,Double> h = new Function2<MyPoint,Double>(){
					@Override
					public Double apply(MyPoint a, MyPoint b) {
						//Manhattan distance.
						return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
					}
				}; 
				
				Function2<MyPoint,Double> d = new Function2<MyPoint,Double>(){
					@Override
					public Double apply(MyPoint a, MyPoint b) {
						return 1.0;
					}
				
				};
				
				StackQueue<MyPoint> frontier = new MyPriorityQueue<MyPoint>(11, new NodeComparator<MyPoint>());
				
				System.out.println("Node found: " + search.findNodeFrom(nicksGraph.getNode(sn).fromMaybe(), nicksGraph.getNode(tg).fromMaybe(), h, d, frontier).fromMaybe());
				System.out.println("Path found: " + search.findPathFrom(nicksGraph.getNode(sn).fromMaybe(), nicksGraph.getNode(tg).fromMaybe(), h, d, frontier).fromMaybe());
			} else if (cmd.equals("map")) {
				System.out.println("Printing map...");
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
			} else if (cmd.equals("exit")) {
				System.out.println("Goodbye");
				System.exit(0);
			} else if (cmd.equals("help")) {				
				System.out.println("Commands:");
				System.out.println("dfs - Perform a depth-first search.");
				System.out.println("bfs - Perform a breadth-first search.");
				System.out.println("astar - Perform an A* search.");
				System.out.println("map - Display the map.");
				System.out.println("exit - Exit the program.");
			} else {
				System.out.println("Please enter a valid command. Type help for a list of commands.");
			}
		}
	}
	
	/**
	 * Searches using generalisation in BFS and DFS.
	 * 
	 * @param search The search object.
	 * @param graph The graph of nodes.
	 * @param frontier The type of frontier, which defines the type of search.
	 */
	public void searchDFSBFS(Search<MyPoint> search, Graph<MyPoint> graph, StackQueue<MyPoint> frontier){
		int[] points = getPoints();
		MyPoint sn = new MyPoint(points[0], points[1]);
		MyPoint tg = new MyPoint(points[2], points[3]);
		
		Predicate<MyPoint> condition = new Predicate<MyPoint>() {
			@Override
			public boolean holds(MyPoint a) {
				return a.equals(tg);
			}
		};
		
		System.out.println("Node found: " + search.findNodeFrom(graph.getNode(sn).fromMaybe(), condition, frontier).fromMaybe());
		System.out.println("Path found: " + search.findPathFrom(graph.getNode(sn).fromMaybe(), condition, frontier).fromMaybe());
	}
	
	/**
	 * Used to get the coordinates used in all three types of search.
	 * 
	 * @return An array of numbes which will form the coordinates.
	 */
	private static int[] getPoints(){
		System.out.println("Please enter the cooridnates 1-by-1, in the order x1, y1, x2, y2.");
		Scanner input = new Scanner(System.in);
		int[] points = new int[4];
		for(int i = 0; i < 4; i++){
			int p = input.nextInt(); input.nextLine();
			points[i] = p;
		}
		return points;
	}

}
