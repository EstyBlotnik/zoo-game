package privateutil;

import animals.*;
import diet.IDiet;
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
 *This abstract class enable to create Roaring animals
 */
public abstract class Roary extends Animal {
   /**
    * The constructor creates new object from requested class
    * @param location- of animal
    * @param name- of animal
    * @param weight- of animal
    * @param diet- of animal
    */
   public Roary(Point location,String name,double weight,IDiet diet,ZooPanel pan,int size,String col,int horSpeed,int verSpeed) {
      super(location,name,weight,diet,pan,size,col, horSpeed,verSpeed);
   }
//   public Roary(Roary roary) {
//      super(roary);
//   }
   public abstract String roary();
   /**
    * This function operate "makeSound" according to the animal
    */
   public void makeSound(){
      MessageUtility.logSound(this.getName(),roary());
   }
}