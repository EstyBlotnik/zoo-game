package privateutil;

import animals.*;
import diet.Carnivore;
import diet.*;
import food.*;
import graphics.ZooPanel;
import plants.Cabbage;
import plants.Lettuce;

import javax.swing.*;

/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
public abstract class KindOfDiet implements IDiet ,AnimalFactory{

	public static KindOfDiet  selectFactory(ZooPanel pan) {

		int result = -1;
		while (result < 0) {
			String[] options = {"Carnivore", "Omnivore", "Herbivore"};
			result = JOptionPane.showOptionDialog(pan, "Please choose factory", "Factory",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);}

		switch (result) {
			case 0:
				return new Carnivore();
			case 1:
				return new Omnivore();
			case 2:
				return new Herbivore();

			}
		return null;
	}
	
	public KindOfDiet() {
	}
	
	/**
	 * This function Checks the type of food received 
	 * and returns the percentage of weight gain accordingly
	 * @param food-type of food (MEAT\ NOTFOOD\ VEGETABLE)
	 * @return the percentage of weight gain accordingly
	 */
	public double MakeFat(EFoodType food) {
		if(food==EFoodType.MEAT)
			return 0.1;
		if(food==EFoodType.VEGETABLE)
			return 0.07;
		return 0;
	}
	/**
	 * This function editing the print shape
	 * return string Ready-to-print 
	 */
	public String toString(){
		return "["+this.getClass().getSimpleName()+"]";
	}
	public abstract boolean canEat(EFoodType food);
	
	/**
	 *  This function Checks if the animal can eat the food 
	 *  and if it can-so return the Overweight
	 */
	public double eat(Animal animal,IEdible food) {
		EFoodType efood=food.getFoodtype();
		if(this.canEat(efood)) {
			return (animal.getWeight()*this.MakeFat(efood));
		}
		return 0;
	}
}