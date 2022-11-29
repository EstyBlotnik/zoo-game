package mobility;

import utilities.MessageUtility;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */

/**
 * This class enable to create a point that describes a location and consists of 2 coordinates
 *
 */
public class Point {
	
	private int x;
	private int y;
	private static final int MAX_X=800;
	private static final int MAX_Y=600;
	private static final int MIN_X=0;
	private static final int MIN_Y=0;
	public Point(int x,int y)
	{
		this.setX(x);
		this.setY(y);
	}
	/**
	 * @param pointToCheck-point To Check
	 * @return true If it's in range, and false if not
	 */
	public static boolean cheackBounderies(Point pointToCheck) {
		return(pointToCheck.x>=MIN_X && pointToCheck.x<=MAX_X && pointToCheck.y>=MIN_Y && pointToCheck.y<=MAX_Y);
	}
	/**
	 * @param p-Point To equalization
	 * @return  true If it's equals, and false if not
	 */
	public boolean equals(Point p){
		if(this.x==p.x&&this.y==p.y)
			return true;
		return false;
	}
	/**
	 * @param x-number
	 * @return true If it's set, and false if not
	 */
	public boolean setX(int x){
		this.x=x;
		//MessageUtility.logSetter(this.getClass().getSimpleName(), "setX",x, isSuccess);
		//this.x=0;
		return true;
	}
	/**
	 * @param y-number
	 * @return true If it's set, and false if not
	 */
	public boolean setY(int y){
		this.y=y;
		//this.y=0;
		//MessageUtility.logSetter(this.getClass().getSimpleName(), "setY",y, isSuccess);
		return true;
	}
		
	/**
	 * @return x
	 */
	public int getX() {
		//MessageUtility.logGetter(this.getClass().getSimpleName(), "getX",this.x);
		return this.x;
	}
	/**
	 * @return y
	 */
	public int getY() {
		//MessageUtility.logGetter(this.getClass().getSimpleName(), "getY",this.y);
		return this.y;
	}
	/**
	 * This function editing the print shape
	 * return string Ready-to-print 
	 */
	public String toString(){//overriding the toString() method 
		return "("+this.x+","+this.y+")";
		}
	//getLocation
}
