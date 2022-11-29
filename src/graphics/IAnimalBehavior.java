package graphics;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */

public interface IAnimalBehavior {
	public String getAnimalName();
	public int getSize();
	public void eatInc();
	public int getEatCount();
	public boolean getChanges ();
	public void setChanges (boolean state);
	public void setSuspended();
	public void setResumed();
}
