package graph;

/**
 * A coordinate system used in a graph.
 * 
 * @author Tom
 *
 */
public class Coordinate {
	
	public int x, y;
	
	/**
	 * A coordinate used in Nick's graph.
	 * 
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 */
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "X = " + x + ", Y = " + y;
	}
	
	@Override
	public boolean equals(Object o){
		Coordinate c = (Coordinate)o;
		return x == c.x && y == c.y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
}
