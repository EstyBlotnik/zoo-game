package mobility;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
import food.EFoodType;
import java.util.Observable;


/**
 *  This abstract class implements the interface ILocatable
 *
 */
public abstract class Mobile extends Observable implements ILocatable{
	protected Point location;
	private double totalDistance;

//	public void setChanged(){
//
//	}

	/**
	 * The constructor creates new object from requested class
	 * @param location
	 */
	public Mobile(Point location) {
		this.location=location;
		this.settotalDistance(0);

	}
	/**
	 * This function add the Current Distance to the Total Distance
	 * @param distance-distance the animal has traveled
	 */
	public void addTotalDistance(double distance) {
		this.settotalDistance(this.totalDistance+distance);
	}
	/**
	 * This function Calculates the distance the animal has traveled
	 * @param p-Point describing location
	 * @return distance-distance the animal has traveled
	 */
	public double calcDistance(Point p) {
		return Math.sqrt (Math.pow ((this.location.getX()-p.getX()) , 2 )+Math.pow((this.location.getY()-p.getY()),2));
	}
	/**
	 * @return total Distance
	 */
	public double getDistance() {
		//MessageUtility.logGetter(this.getClass().getSimpleName(), "getDistance",this.totalDistance);
		return this.totalDistance;
	}
	/**
	 * @return location
	 */
	public Point getLocation() {
		//MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation",this.location);
		return this.location;
		}
	/**
	 * This function editing the print shape
	 * return string Ready-to-print 
	 */
	public String toString(){//overriding the toString() method 
		return "location"+this.location+"\t";
		}
	/**
	 * @return true If it's set, and false if not
	 */
	public boolean setLocation(Point p) {
		boolean isSuccess =Point.cheackBounderies(p)&&!(this.location.equals(p));
		//boolean isSuccess = !(this.location.equals(p));
		this.location=p;
		//MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", p, isSuccess);
		return isSuccess;
		}
	
	/**
	 * @param totalDistance-totalDistance
	 * @return true If it's set, and false if not
	 */
	public boolean settotalDistance(double totalDistance) {
		boolean isSuccess=(totalDistance>=0);
		this.totalDistance=totalDistance;
		//MessageUtility.logSetter(this.getClass().getSimpleName(), "settotalDistance",totalDistance, isSuccess);
		return isSuccess;
	}
	
	public abstract double move(Point p);
//		this.location=p;
//		this.totalDistance=this.totalDistance+calcDistance(p);
//		return calcDistance(p);
	
//	public static void main(String[] args) {
//		Point p=new Point(5,12);
//		System.out.println(m.calcDistance(new Point(0,0)));
//		System.out.println(p.getY());
//	}
}
