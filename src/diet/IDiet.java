package diet;

import food.*;
import animals.*;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
public interface IDiet {
	public boolean canEat(EFoodType food);
	public double eat(Animal animal, IEdible food);
}

