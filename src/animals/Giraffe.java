package animals;


import diet.*;
import food.EFoodType;
import graphics.ZooPanel;
import mobility.Point;
import privateutil.*;
import utilities.MessageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;

//import utilities.MessageUtility;

/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */
public class Giraffe extends Chewy{
   private double neckLenghth;
   /**
    * The constructor creates new object from requested class
//    * @param name -of animal
//    * @param neckLenghth-of animal
    */
   public Giraffe(ZooPanel pan,int size,String col,int horSpeed,int verSpeed) {
      super(new Point(50,0),"Giraffe",size*2.2,new Herbivore(),pan,size,col,horSpeed, verSpeed);
      //MessageUtility.logConstractor("Giraffe",name );
      this.setNeckLength(2.5);
      }    

    /**
       * This function set the length of the neck
       * @param neckLenghth-of animal
       * @return true if it is set, and false if not
       */
    public boolean setNeckLength(double length) {
      boolean isSuccess = (length<2.5 && length>1);
      if (isSuccess) {
         this.neckLenghth=length;
      }
      else
         this.neckLenghth=1.5;
      MessageUtility.logSetter(this.getClass().getSimpleName(), "setNeckLength", length, isSuccess);
      return isSuccess;
      }
    /** 
       * This function return the sound that the animal make
       */
    public String chewy() {
       return "Bleats and Stomps its legs, then chews";
       }
    /**
       * The function editing the print shape
       * return string Ready-to-print 
       */

//  public String toString(){ 
//     String str=super.toString();
//     str=str+"neck Length: "+ neckLenghth+"\n";
//     return str;
//     }

   public void drawObject (Graphics g)
   {
      //g.setColor(this.getColor());//�� ���� �����?

      if(this.getX_dir()==1) // giraffe goes to the right side
         g.drawImage(this.getImg1(), this.getLocation().getX()-this.getSize()/2,
               this.getLocation().getY()-this.getSize()/10, this.getSize()/2, this.getSize(), this.getPan());
      else // giraffe goes to the left side
         g.drawImage(this.getImg2(), this.getLocation().getX(),
               this.getLocation().getY()-this.getSize()/10, this.getSize()/2, this.getSize(), this.getPan());
   }
   public Object clone(){
	   Giraffe newGiraffe=new Giraffe(this.getPan(),this.getSize(),this.getCol(),this.getHorSpeed(),this.getVerSpeed());
	   newGiraffe.setX_dir(this.getX_dir());
	   newGiraffe.setY_dir(this.getY_dir());
	   newGiraffe.setLocation(this.getLocation());
	   return newGiraffe;
    }
}