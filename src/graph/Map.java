package graph;

import java.awt.Point;
import java.util.ArrayList;

public class Map{
	
	private ArrayList<Node<Point>> map;
	
	public Map(){			
		Node<Point> node00 = new Node<Point>(new Point(0,0));
		Node<Point> node01 = new Node<Point>(new Point(0,1));
		Node<Point> node02 = new Node<Point>(new Point(0,2));
		Node<Point> node03 = new Node<Point>(new Point(0,3));
		Node<Point> node04 = new Node<Point>(new Point(0,4));
		Node<Point> node05 = new Node<Point>(new Point(0,5));
		Node<Point> node06 = new Node<Point>(new Point(0,6));
		Node<Point> node10 = new Node<Point>(new Point(1,0));
		Node<Point> node11 = new Node<Point>(new Point(1,1));
		Node<Point> node12 = new Node<Point>(new Point(1,2));
		Node<Point> node13 = new Node<Point>(new Point(1,3));
		Node<Point> node14 = new Node<Point>(new Point(1,4));
		Node<Point> node15 = new Node<Point>(new Point(1,5));
		Node<Point> node16 = new Node<Point>(new Point(1,6));
		Node<Point> node20 = new Node<Point>(new Point(2,0));
		Node<Point> node21 = new Node<Point>(new Point(2,1));
		Node<Point> node22 = new Node<Point>(new Point(2,2));
		Node<Point> node23 = new Node<Point>(new Point(2,3));
		Node<Point> node24 = new Node<Point>(new Point(2,4));
		Node<Point> node25 = new Node<Point>(new Point(2,5));
		Node<Point> node26 = new Node<Point>(new Point(2,6));
		Node<Point> node30 = new Node<Point>(new Point(3,0));
		Node<Point> node31 = new Node<Point>(new Point(3,1));
		Node<Point> node32 = new Node<Point>(new Point(3,2));
		Node<Point> node33 = new Node<Point>(new Point(3,3));
		Node<Point> node34 = new Node<Point>(new Point(3,4));
		Node<Point> node35 = new Node<Point>(new Point(3,5));
		Node<Point> node36 = new Node<Point>(new Point(3,6));
		Node<Point> node40 = new Node<Point>(new Point(4,0));
		Node<Point> node41 = new Node<Point>(new Point(4,1));
		Node<Point> node42 = new Node<Point>(new Point(4,2));
		
		node00.addSuccessor(node10);
		node00.addSuccessor(node01);
		node01.addSuccessor(node00);
		node01.addSuccessor(node11);
		node01.addSuccessor(node02);
		node02.addSuccessor(node03);
		node02.addSuccessor(node01);
		node03.addSuccessor(node02);
		node03.addSuccessor(node04);
		node04.addSuccessor(node03);
		node04.addSuccessor(node05);
		node05.addSuccessor(node06);
		node05.addSuccessor(node15);
		node05.addSuccessor(node04);
		node06.addSuccessor(node16);
		node06.addSuccessor(node05);
		node10.addSuccessor(node00);
		node10.addSuccessor(node11);
		node10.addSuccessor(node20);
		node11.addSuccessor(node12);
		node11.addSuccessor(node21);
		node11.addSuccessor(node10);
		node11.addSuccessor(node01);
		node12.addSuccessor(node22);
		node12.addSuccessor(node11);
		node12.addSuccessor(node13);
		node13.addSuccessor(node12);
		node13.addSuccessor(node14);
		node13.addSuccessor(node23);
		node14.addSuccessor(node24);
		node14.addSuccessor(node15);
		node14.addSuccessor(node23);
		node15.addSuccessor(node14);
		node15.addSuccessor(node25);
		node15.addSuccessor(node16);
		node15.addSuccessor(node05);
		node16.addSuccessor(node06);
		node16.addSuccessor(node15);
		node16.addSuccessor(node26);
		node20.addSuccessor(node30);
		node20.addSuccessor(node21);
		node20.addSuccessor(node10);
		node21.addSuccessor(node22);
		node21.addSuccessor(node11);
		node21.addSuccessor(node20);
		node21.addSuccessor(node31);
		node22.addSuccessor(node12);
		node22.addSuccessor(node21);
		node22.addSuccessor(node23);
		node22.addSuccessor(node32);
		node23.addSuccessor(node22);
		node23.addSuccessor(node24);
		node23.addSuccessor(node33);
		node23.addSuccessor(node13);
		node24.addSuccessor(node14);
		node24.addSuccessor(node25);
		node24.addSuccessor(node23);
		node24.addSuccessor(node34);
		node25.addSuccessor(node24);
		node25.addSuccessor(node15);
		node25.addSuccessor(node26);
		node25.addSuccessor(node35);
		node26.addSuccessor(node36);
		node26.addSuccessor(node25);
		node26.addSuccessor(node16);
		node30.addSuccessor(node20);
		node30.addSuccessor(node31);
		node31.addSuccessor(node30);
		node31.addSuccessor(node41);
		node31.addSuccessor(node21);
		node31.addSuccessor(node32);
		node32.addSuccessor(node22);
		node32.addSuccessor(node42);
		node32.addSuccessor(node31);
		node33.addSuccessor(node23);
		node33.addSuccessor(node34);
		node34.addSuccessor(node24);
		node34.addSuccessor(node33);
		node35.addSuccessor(node25);
		node36.addSuccessor(node26);
		node41.addSuccessor(node31);
		node42.addSuccessor(node32);
		
		map = new ArrayList<Node<Point>>();
		
		map.add(node00);//0
		map.add(node01);
		map.add(node02);
		map.add(node03);
		map.add(node04);
		map.add(node05);
		map.add(node06);
		map.add(node10);//7
		map.add(node11);
		map.add(node12);
		map.add(node13);
		map.add(node14);
		map.add(node15);
		map.add(node16);
		map.add(node20);//14
		map.add(node21);
		map.add(node22);
		map.add(node23);
		map.add(node24);
		map.add(node25);
		map.add(node26);//20
		map.add(node30);
		map.add(node31);
		map.add(node32);
		map.add(node33);
		map.add(node34);
		map.add(node35);
		map.add(node36);
		map.add(node40);//28
		map.add(node41);
		map.add(node42);
		
		/*
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(6);
		Node<Integer> node7 = new Node<Integer>(7);
		Node<Integer> node8 = new Node<Integer>(8);
		Node<Integer> node9 = new Node<Integer>(9);
		
		node1.addSuccessor(node2);
		node1.addSuccessor(node4);
		node2.addSuccessor(node1);
		node2.addSuccessor(node3);
		node2.addSuccessor(node5);
		node3.addSuccessor(node2);
		node4.addSuccessor(node1);
		node4.addSuccessor(node5);
		node4.addSuccessor(node6);
		node5.addSuccessor(node4);
		node5.addSuccessor(node2);
		node5.addSuccessor(node8);
		node6.addSuccessor(node4);
		node6.addSuccessor(node7);
		node7.addSuccessor(node6);
		node7.addSuccessor(node9);
		node8.addSuccessor(node5);
		node8.addSuccessor(node9);
		node9.addSuccessor(node7);
		node9.addSuccessor(node8);
		
		map.add(node1);
		map.add(node2);
		map.add(node3);
		map.add(node4);
		map.add(node5);
		map.add(node6);
		map.add(node7);
		map.add(node8);
		map.add(node9);
		*/
	}
	
	public ArrayList<Node<Point>> getMap(){
		return map;
	}
}
