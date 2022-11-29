package mobility;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */

/**
 * Interface that describes location functionality
 */
public interface ILocatable {
	/**
	 * @return Location
	 */
	public Point getLocation();
	/**
	 * @param p-Point
	 * @return true If it's set, and false if not
	 */
	public boolean setLocation(Point p);
}
