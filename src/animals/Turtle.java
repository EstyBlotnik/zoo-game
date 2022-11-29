package animals;

import java.awt.Graphics;

import diet.*;
import food.EFoodType;
import graphics.ZooPanel;
import mobility.Point;
import privateutil.*;
import utilities.MessageUtility;

//import utilities.MessageUtility;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
public class Turtle extends Chewy{
   
   private int Age;
   /**
    * The constructor creates new object from requested class
//    * @param name -of animal
//    * @param Age-of animal
    */

   public Turtle(ZooPanel pan,int size,String col,int horSpeed,int verSpeed) {
      super(new Point(80,0),"Turtle",0.5*size,new Herbivore(),pan,size,col,horSpeed, verSpeed);
      //MessageUtility.logConstractor("Turtle",name );
      this.setAge(1);
   }

    
   /**
    * The constructor creates new object from requested class
    * @param name -of animal
    * @param location- of animal
    * @param Age-of animal
    */
// public Turtle(String name,Point location,int Age) {
//    super(location,name,1,new Herbivore());
//    MessageUtility.logConstractor("Turtle",name );
//    this.setAge(Age);
// }
// public Turtle(String name,double weight,Point location,int Age) {
//    super(location,name,weight,new Herbivore());
//    MessageUtility.logConstractor("Turtle",name );
//    this.setAge(Age);
// }
// public Turtle(String name,double weight,int Age) {
//    super(new Point(20,0),name,weight,new Herbivore());
//    MessageUtility.logConstractor("Turtle",name );
//    this.setAge(Age);
// }
   
   
   /**
    * This function set the age of the animal
    * @param Age-of animal
    * @return 
    * 
    */
   public boolean setAge(int Age) {
      boolean isSuccess = (Age<500 && Age>0);
      if(isSuccess)
         this.Age=Age;
      else
         this.Age=1;
      MessageUtility.logSetter(this.getClass().getSimpleName(), "setAge", Age, isSuccess);
   
      return isSuccess;
   }
   /** 
    * This function return the sound that the animal make
    */
   public String chewy() {
      return "Retracts its head in then eats quietly";
   }
   /**
    * This function editing the print shape
    * return string Ready-to-print 
    */
   public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
	   if(this.getX_dir()==1) // giraffe goes to the right side
	   g.drawImage(this.getImg1(), this.getLocation().getX()-this.getSize()/2, this.getLocation().getY()-this.getSize()/10, this.getSize(), this.getSize()/2, this.getPan());
	   else // giraffe goes to the left side
	   g.drawImage(this.getImg2(), this.getLocation().getX()-this.getSize()/2, this.getLocation().getY()-this.getSize()/10, this.getSize(), this.getSize()/2, this.getPan());
	   }
   public Object clone(){
	   Turtle newTurtl=new Turtle(this.getPan(),this.getSize(),this.getCol(),this.getHorSpeed(),this.getVerSpeed());
	   newTurtl.setX_dir(this.getX_dir());
	   newTurtl.setY_dir(this.getY_dir());
	   newTurtl.setLocation(this.getLocation());
	   return newTurtl;
    }
}