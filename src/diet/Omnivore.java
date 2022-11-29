package diet;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
import animals.Animal;
import animals.Lion;
import graphics.AddAnimalDialog;
import graphics.ZooPanel;
import privateutil.*;
import food.*;

import java.util.ArrayList;

public class Omnivore extends KindOfDiet implements AnimalFactory{
	final String []kindOfAnimal = {"Bear"};
	public void createAnimal(ArrayList<Animal> arrayList, ZooPanel pan) {
		new AddAnimalDialog(arrayList, pan, kindOfAnimal,1).showDialog();

	}

	public Omnivore() {
	}
	/**
	 * This function Checks whether the animal can eat the food 
	 * return true if can eat ,and false if not
	 */
	public boolean canEat(EFoodType food) {
		if (food==EFoodType.NOTFOOD)
			return false;
		return true;
	}
}
