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
 */


import diet.*;
import food.EFoodType;
import mobility.Point;
import privateutil.*;
import utilities.MessageUtility;

//import utilities.MessageUtility;

/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 */
public class Elephant extends Chewy{
   
   
   private double trunkLength;
    
   /**
    * The constructor creates new object from requested class
    * @param name- of animal
    * @param trunkLength- of elephant
    */
//   public Elephant(ZooPanel pan,double trunkLength,String col) {
//      super(new Point(50,90),"Elephant",500,new Herbivore(),pan,size,col );
//      //MessageUtility.logConstractor("Elephant" );
//      this.settrunkLength(trunkLength);   
//   }
   /**
    * The constructor creates new object from requested class
//    * @param name -of animal
//    * @param location- of animal
//    * @param trunkLength- of elephant
    */

   public Elephant(ZooPanel pan,int size,String col,int horSpeed,int verSpeed) {
      super(new Point(50,90),"Elephant",size*10,new Herbivore(),pan,size,col,horSpeed,verSpeed);
      //MessageUtility.logConstractor("Elephant",name );
      this.settrunkLength(2);
   }

//    public Elephant(Elephant elephant) {
//        super(elephant);
//        //MessageUtility.logConstractor("Elephant",name );
//        this.settrunkLength(elephant.trunkLength);
//    }
    public Object clone(){
    	Elephant newelephant=new Elephant(this.getPan(),this.getSize(),this.getCol(),this.getHorSpeed(),this.getVerSpeed());
    	newelephant.setX_dir(this.getX_dir());
    	newelephant.setY_dir(this.getY_dir());
    	newelephant.setLocation(this.getLocation());
    	return newelephant;
     }
    

// public Elephant(String name,double weight,Point location,double trunkLength) {
//    super(location,name,weight,new Herbivore());
//    MessageUtility.logConstractor("Elephant",name );
//    this.settrunkLength(trunkLength);
// }
// public Elephant(String name,double weight,double trunkLength) {
//    super(new Point(20,0),name,weight,new Herbivore());
//    MessageUtility.logConstractor("Elephant",name );
//    this.settrunkLength(trunkLength);
// }
   
   

   /** 
    * This function return the sound that the animal make
    */ 
   public String chewy() {
      return "Trumpets with joy while flapping its ears, then chews"; 
   }
   
   /**
    * This function set the length of the trunk
    * @param trunkLength-of animal
    * @return true if it is set, and false if not
    */
   
   public boolean settrunkLength(double trunkLength) {
      boolean isSuccess = (trunkLength<3 && trunkLength>0.5);
      if (isSuccess) {
         this.trunkLength=trunkLength;
      }
      MessageUtility.logSetter(this.getClass().getSimpleName(), "settrunkLength", trunkLength, isSuccess);
      return isSuccess;
   }
//@Override
//public void drawObject(Graphics g) {
//	// TODO Auto-generated method stub
//	
//}
   public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
	   if(this.getX_dir()==1) // giraffe goes to the right side
	   g.drawImage(this.getImg1(), this.getLocation().getX()-this.getSize()/2, this.getLocation().getY()-this.getSize()/10, this.getSize(), this.getSize()/2, this.getPan());
	   else // giraffe goes to the left side
	   g.drawImage(this.getImg2(), this.getLocation().getX()-this.getSize()/2, this.getLocation().getY()-this.getSize()/10, this.getSize(), this.getSize()/2, this.getPan());
	   }


    /**
    * The function editing the print shape
    * return string Ready-to-print 
    */
// public String toString(){//overriding the toString() method 
//    String str=super.toString();
//    str=str+"trunk Length: "+trunkLength+"\n";
//    return str;
//    }
}
    