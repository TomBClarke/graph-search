package demo;

import java.awt.Point;

@SuppressWarnings("serial")
public class MyPoint extends Point {

		public MyPoint(int x, int y){
			super(x, y);
		}
		
		@Override
		public String toString(){
			return "(" + x + "," + y + ")";
		}
}
