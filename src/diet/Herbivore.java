package diet;

//import animals.Animal;
import animals.*;
import food.*;
import graphics.AddAnimalDialog;
import graphics.ZooPanel;
import privateutil.*;

import java.util.ArrayList;

/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
public class Herbivore extends KindOfDiet implements AnimalFactory{
	final String [] kindOfAnimal={"Giraffe","Turtle","Elephant"};

	public void createAnimal(ArrayList<Animal> arrayList, ZooPanel pan) {
		new AddAnimalDialog(arrayList, pan, kindOfAnimal,3).showDialog();
	}

	public Herbivore() {
	}
	/**
	 * This function Checks whether the animal can eat the food 
	 * return true if can eat ,and false if not
	 */
	public boolean canEat(EFoodType food) {
		if (food==EFoodType.VEGETABLE)
			return true;
		return false;
	}

}
