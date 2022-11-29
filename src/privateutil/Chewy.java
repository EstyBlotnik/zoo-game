package privateutil;


import animals.Animal;
import diet.IDiet;
import food.EFoodType;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */

/**
 * 
 *This abstract class enable to create Animals that chew                      
 *
 */
public abstract class Chewy extends Animal{
   /**
    * The constructor creates new object from requested class
    * @param location -of animal
    * @param name- of animal
    * @param weight- of animal
    * @param diet- of animal
    */
   public Chewy(Point location,String name,double weight,IDiet diet,ZooPanel pan,int size,String col,int horSpeed,int verSpeed) {
      super(location,name,weight,diet,pan,size,col,horSpeed,verSpeed);
   }
//   public Chewy(Chewy chewy) {
//      super(chewy);
//   }
   /**
    * The function return the type of food (MEAT\ NOTFOOD \VEGETABLE)
    */
   public EFoodType getFoodtype() {
      MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodtype",EFoodType.MEAT);
      return EFoodType.MEAT;
   }
   public abstract String chewy();
   /**
    * This function operate "makeSound" according to the animal
    */
   public void makeSound(){
      MessageUtility.logSound(this.getName(),chewy());
   }
}

