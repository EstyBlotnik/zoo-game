package animals;

import java.awt.Graphics;
import java.util.Random;

import diet.*;
import utilities.*;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
//import lab2.IntLinkedList.Node;
import mobility.Point;
import privateutil.*;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
public class Lion extends Roary{
   private int scarCount;
   
   /**
    * The constructor creates new object from requested class

    */
   public Lion(ZooPanel pan,int size,String col,int horSpeed,int verSpeed) {
      super(new Point(20,0),"Lion",0.8*size,new Carnivore(),pan,size,col, horSpeed, verSpeed);
      //MessageUtility.logConstractor("Lion" );
      this.setscarCount(0);
   }
//   public Lion(Lion lion) {
//      super(lion);
//      //MessageUtility.logConstractor("Lion" );
//      this.setscarCount(lion.scarCount);
//   }
//   public Lion(String name,double weight,Point location,int size,String col) {
//      super(location,name,weight,new Carnivore(),size,col);
//      MessageUtility.logConstractor("Lion",name );
//      this.setscarCount(0);
//   }
//   public Lion(String name,double weight,int size,String col) {
//      super(new Point(20,0),name,weight,new Carnivore(),size,col);
//      MessageUtility.logConstractor("Lion",name );
//      this.setscarCount(0);
//   }
//   /**
//    * The constructor creates new object from requested class
//    * @param name -of animal
//    */
//   public Lion(String name,int size,String col) {
//      super(new Point(20,0),name,408.2,new Carnivore(),size,col);
//      MessageUtility.logConstractor("Lion",name );
//      this.setscarCount(0);
//   }
   /**
    * The function return the type of food (MEAT\ NOTFOOD \VEGETABLE)
    */
   public EFoodType getFoodtype() {
      MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodtype",EFoodType.NOTFOOD);
      return EFoodType.NOTFOOD;
   }
   
   /**
    * This function set the number of the scar
    * @param scarCount-of animal
    * @return true if it is set, and false if not
    */
   public boolean setscarCount(int scarCount){
      boolean isSuccess = true;
      if (isSuccess) {
         this.scarCount=scarCount;
      }
      MessageUtility.logSetter(this.getClass().getSimpleName(), "setscarCount", scarCount, isSuccess);
      return isSuccess;
   }
   /**
    * This function Checks whether the animal can eat the food 
    * if it can eat,so it can get a scar randomly
    * return true if it eat and false if not
    */
   
   public boolean eat(IEdible food) { 
      if(super.eat(food)) {
           Random rand = new Random();
           int scar = rand.nextInt(2);
           this.setscarCount(this.scarCount+scar);
           return true;
      }
      return false;
   }
   /** 
    * This function return the sound that the animal make
    */
   
   public String roary() {    
      return "Roars, then stretches and shakes its mane";
   }
   public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
	   if(this.getX_dir()==1) // giraffe goes to the right side
	   g.drawImage(this.getImg1(), this.getLocation().getX()-this.getSize()/2, this.getLocation().getY()-this.getSize()/10, this.getSize(), this.getSize()/2, this.getPan());
	   else // giraffe goes to the left side
	   g.drawImage(this.getImg2(), this.getLocation().getX()-this.getSize()/2, this.getLocation().getY()-this.getSize()/10, this.getSize(), this.getSize()/2, this.getPan());
	   }
   public Object clone(){
	   Lion newLion=new Lion(this.getPan(),this.getSize(),this.getCol(),this.getHorSpeed(),this.getVerSpeed());
	   newLion.setX_dir(this.getX_dir());
	   newLion.setY_dir(this.getY_dir());
	   newLion.setLocation(this.getLocation());
	   return newLion;
    }
   /**
    * This function editing the print shape
    * return string Ready-to-print 
    */
 
}
