package animals;

import java.awt.Graphics;

import diet.Carnivore;
import diet.Omnivore;
import food.EFoodType;
import graphics.ZooPanel;
import mobility.Point;
import privateutil.Roary;
import utilities.MessageUtility;


import diet.Carnivore;
import diet.Omnivore;
import food.EFoodType;
import mobility.Point;
import privateutil.Roary;
import utilities.MessageUtility;

/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
public class Bear extends Roary{
   private String furColor;
   
   
   /**
    * The constructor creates new object from requested class

    */
   public Bear(ZooPanel pan,int size,String col,int horSpeed,int verSpeed) {
      
      super(new Point(100,5),"Bear",1.5*size,new Omnivore(),pan,size,col, horSpeed, verSpeed);
      //MessageUtility.logConstractor("Bear",name);
      this.setFurColor("GRAY");
      
      }
   
   public Object clone(){
	   Bear newbear=new Bear(this.getPan(),this.getSize(),this.getCol(),this.getHorSpeed(),this.getVerSpeed());
	   newbear.setX_dir(this.getX_dir());
	   newbear.setY_dir(this.getY_dir());
	   newbear.setLocation(this.getLocation());
	   return newbear;
    }
   
// public Bear(String name,double weight,Point location,String color) {
//    super(location,name,weight,new Omnivore());
//    MessageUtility.logConstractor("Bear",name );
//    this.setFurColor(color);
// }
// public Bear(String name,double weight,String color) {
//    super(new Point(20,0),name,weight,new Omnivore());
//    MessageUtility.logConstractor("Bear",name );
//    this.setFurColor(color);
// }
   
   /**
    * The constructor creates new object from requested class
    * @param name of animal
    * @param location of animal
    * @param color of fur
    */
// public Bear(String name,Point location,String color) {
//    super(location,name,308.2,new Carnivore());
//    MessageUtility.logConstractor("Bear",name );
//    this.setFurColor(color);
// }
   
   /**
    * The function return the type of food (MEAT\ NOTFOOD \VEGETABLE)
    */
   public EFoodType getFoodtype() {
      MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodtype",EFoodType.MEAT);
      return EFoodType.MEAT;     
   }
    
   
   /**
    * This function set the color of the fur
    * @param color of fur
    * @return true if it is set, and false if not
    */
   public boolean setFurColor(String color) {
         boolean isSuccess = (color.equals("BLACK")||color.equals("WHITE")||color.equals("GRAY"));
         if (isSuccess) {
            this.furColor=color;
         }
         else
            this.furColor="GRAY";
         MessageUtility.logSetter(this.getClass().getSimpleName(), "setFurColor", color, isSuccess);
         return isSuccess;
   }
   
   /** 
    * This function return the sound that the animal make
    */
   public String roary() {
      return "Stands on its hind legs, roars and scratches its belly";    
   }
   /**
    * This function editing the print shape
    * return string Ready-to-print 
    */
// public String toString(){//overriding the toString() method 
//    String str=super.toString();
//    str=str+"furColor: "+furColor+"\n";
//    return str;
//    }

//@Override
//public void drawObject(Graphics g) {
//	// TODO Auto-generated method stub
//	super.paintComponent(g) ;
//	 
//	 if(img1!=null)
//		 g.drawImage(this.img1,0,0,getWidth(),getHeight(), this);
//}
   public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
	   if(this.getX_dir()==1) // giraffe goes to the right side
	   g.drawImage(this.getImg1(), this.getLocation().getX()-this.getSize()/2, this.getLocation().getY()-this.getSize()/10, this.getSize(), this.getSize()/2, this.getPan());
	   else // giraffe goes to the left side
	   g.drawImage(this.getImg2(), this.getLocation().getX()-this.getSize()/2, this.getLocation().getY()-this.getSize()/10, this.getSize(), this.getSize()/2, this.getPan());
	   }

}
