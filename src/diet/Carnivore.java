package diet;

//import animals.Animal;
import animals.Animal;
import food.*;
import graphics.AddAnimalDialog;
import graphics.ZooPanel;
import privateutil.*;
import animals.*;

import java.util.ArrayList;

/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
public class Carnivore extends KindOfDiet implements AnimalFactory {
	final String [] kindOfAnimal={"Lion"};

	public  void createAnimal(ArrayList<Animal> arrayList, ZooPanel pan) {
		new AddAnimalDialog(arrayList, pan, kindOfAnimal,1).showDialog();
	}

	public Carnivore() {
//		super();
	}
	/**
	 * This function Checks whether the animal can eat the food 
	 * return true if can eat ,and false if not
	 */
	public boolean canEat(EFoodType food){
		if (food==EFoodType.MEAT)
			return true;
		return false;
	}
}
