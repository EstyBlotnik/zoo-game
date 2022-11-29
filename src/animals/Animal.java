package animals;
//import java.*;

import diet.IDiet; //import javax.swing.*;
import food.EFoodType;
import food.IEdible;
import graphics.Controller;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Mobile;
import mobility.Point;
import privateutil.KindOfDiet;
import utilities.MessageUtility;
import java.lang.Cloneable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.math.*;
import java.util.Observable;

import javax.imageio.ImageIO;

/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */

/**
 * This class enable to create an Animal
 *
 */
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior,Runnable,Cloneable{
	protected Thread thread;
	protected boolean threadSuspended;
	private boolean threadExit;
	private Controller controller;
	private String name;
	private double weight;
	private IDiet diet;
	public static int TotalEatCount=0;
	private final int EAT_DISTANCE = 10;
	private int size;
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged;

	private int x_dir;
	private int y_dir;
	private int eatCount;
	private ZooPanel pan;
	private BufferedImage img1= null, img2= null;
	/**
	 * The constructor creates new object from requested class
//	 * @param location of animal
//	 * @param name of animal
//	 * @param weight of animal
//	 * @param diet of animal
	 * @return 
	 */
	public Animal(Point location,String name,double weight,IDiet diet,ZooPanel pan,int size,String col,int horSpeed,int verSpeed){
		super(location);
		controller = Controller.getController();
		MessageUtility.logConstractor("Animal",name );
		this.setName(name);
		this.setWeight(weight);
		this.setIDiet(diet);
		this.threadExit=false;
		if(size>300 || size<50)
			this.size=100;//?????? ?? ??????
		else
			this.size=size;

		this.col=col;
		this.horSpeed=horSpeed;
		this.verSpeed=verSpeed;
		this.coordChanged=true;
		this.x_dir=1;
		this.y_dir=1;
		this.eatCount=0;
		this.pan = pan;
		this.loadImages(col);
	}

	public void notifyObservers(){
		controller.update(this,getPan());
	}
	public void setCol(String color){
		this.col = color;
	}

	public void run(){
		while (threadExit==false) {
			int new_x = this.getLocation().getX() + this.horSpeed * getX_dir();
			int new_y = this.getLocation().getY() + this.verSpeed * getY_dir();

			this.move(new Point(new_x,new_y));
			this.setChanges(true);
			//pan.manageZoo();
			synchronized (this){
				if (new_x >= pan.getWidth() || new_x <= 0) {
					x_dir = x_dir * (-1);
					this.loadImages(this.col);
				}
				if (new_y >= 600 || new_y <= 0){
					y_dir = y_dir *(-1) ;
				}

			}
			pan.repaint();

			if (this.threadSuspended==true) {
				synchronized (this){
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public int getEAT_DISTANCE(){
		return EAT_DISTANCE;
	}

	public Thread getThread() {return thread;}

	public boolean getThreadSuspended() {return threadSuspended;}
	public boolean getThreadExit() {return threadExit;}

	public void setThreadExit(boolean threadExit) {this.threadExit=threadExit;}

	public synchronized void  setSuspended() {
		synchronized (this){
			this.threadSuspended = true;
		}
	}

	public void setResumed(){
		synchronized (this){
			this.threadSuspended=false;
			this.notifyAll();
		}
		///////////////////// ����� ���� ������ ������ ���� ���
	}
	public void setX_dir(int x_dir) {this.x_dir = x_dir;}
	public void setY_dir(int y_dir) {this.y_dir = y_dir;}

	/**
	 * This function set the diet
	 * @param diet :kind of animal divided by its diet
	 * @return true if it is set, and false if not
	 */
	public boolean setIDiet(IDiet diet) {
		boolean isSuccess = ((KindOfDiet)diet!=null);
		if(isSuccess )
			this.diet=diet;
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setIDiet",diet, isSuccess);
		return isSuccess;
	}
	/**
	 * This function set the new weight
	 * @param weight
	 * @return true if it is set, and false if not
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight=weight;
		}
		//double numberBefore = 1.23456;
		String numberAfter = String.format("%.2f", weight);
		//System.out.println(numberAfter);
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", numberAfter, isSuccess);
		return isSuccess;
	}
	public boolean isChange(){
		return coordChanged;
	}
	/**
	 * @return name of animal
	 */
	public String getName() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getName", this.name);
		return name;
	}
	public int getHorSpeed()
	{
		return this.horSpeed;
	}
	public int getVerSpeed()
	{
		return this.verSpeed;
	}
	public BufferedImage getImg1() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getImg1", this.img1);
		return img1;
	}
	public BufferedImage getImg2() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getImg2", this.img2);
		return img2;
	}
	//???? ??? ?? ?????
	public String getCol(){
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getCol", this.col);
		return col;
	}

	public ZooPanel getPan() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getPan", this.pan);
		return pan;
	}
	public int getX_dir() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getX_dir", this.x_dir);
		return x_dir;
	}

	public int getY_dir() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getY_dir", this.y_dir);
		return y_dir;
	}
	/**
	 * @return weight of animal
	 */
	public double getWeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
		return weight;
	}
	/**
	 * @return diet of animal
	 */
	public IDiet getIDiet() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getIDiet", this.diet);
		return diet;
	}
	/**
	 * @param name of animal
	 * @return true if it is set, and false if not
	 */
	public boolean setName( String name) {
		boolean isSuccess = (name!=null);
		if (isSuccess) {
			this.name=name;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setName", name, isSuccess);
		return isSuccess;
	}

	/**

	 * This function changes the location of the animal to the resulting location
	 *  and changes its weight according to the formula
	 * @return the distance
	 */

	public double move(Point p) {
		double distance=this.calcDistance(p);
		boolean isSuccess =Point.cheackBounderies(p)&&distance!=0;
		//????? ?????? ??????
		addTotalDistance(distance);
		this.setLocation(p);
		double tweight=this.getWeight();
		this.setWeight(tweight-(tweight*distance*0.00025));
		MessageUtility.logBooleanFunction(this.name, "move", p, isSuccess);
		return distance;
	}

	/**
	 *  This function Checks whether the animal can eat the food
	 *  it received if it eats it and changes the weight accordingly
	 *   And even makes a sound accordingly
	 *
	 * @param food: type of food (MEAT\ NOTFOOD\ VEGETABLE)
	 * @return true if it is done, and false if not
	 */
	public boolean eat(IEdible food) {
		EFoodType efood=food.getFoodtype();
		boolean isSuccess=this.diet.canEat(efood);
		if(isSuccess) {
			this.setWeight(this.weight+this.diet.eat(this,food));
			this.makeSound();
		}
		MessageUtility.logBooleanFunction(this.name, "eat", food, isSuccess);
		this.eatInc();
		TotalEatCount=TotalEatCount+1;
		return isSuccess;
	}
	/**
	 * The function editing the print shape
	 * return string Ready-to-print
	 */
	public String toString(){
		String str="["+this.getClass().getSimpleName()+"]:  "+ this.name;
		return str;
	}

	public String getAnimalName(){
		return this.name;
	}
	public int getSize(){
		return this.size;
	}
	public void eatInc(){
		this.eatCount=this.eatCount+1;
	}

	public int getEatCount(){
		return this.eatCount;
	}
	public boolean getChanges (){
		return this.coordChanged;
	}

	public void setChanges (boolean state){
		this.coordChanged=state;
		//Controller.update(this,getPan());
		notifyObservers();
	}

	public void loadImages(String color){
		String animalName = null,color1=null,color2=null;
		switch(this.getClass().getSimpleName()) {
			case "Lion":
				animalName="lio";
				break;
			case "Bear":
				animalName="bea";
				break;
			case "Elephant":
				animalName="elf";
				break;
			case "Giraffe":
				animalName="grf";
				break;
			case "Turtle":
				animalName="trt";
				break;
		}
		switch(color) {
			case "Red":
				color1="_r_1.png";
				color2="_r_2.png";
				break;
			//"Blue","Natural"
			case "Blue":
				color1="_b_1.png";
				color2="_b_2.png";
				break;
			case "Natural":
				color1="_n_1.png";
				color2="_n_2.png";
				break;
		}
		try { img1 = ImageIO.read(new File(PICTURE_PATH+"\\"+animalName+color1)); }
		catch (IOException e) { System.out.println("Cannot load image"); }
		try { img2 = ImageIO.read(new File(PICTURE_PATH+"\\"+animalName+color2)); }
		catch (IOException e) { System.out.println("Cannot load image"); }
	}

	public String getColor(){
		return this.col;
	}

	public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
		if(x_dir==1) //  goes to the right side
			g.drawImage(this.img1, this.getLocation().getX()-size, this.getLocation().getY()-size/10, size/2, size, pan);
		else // goes to the left side
			g.drawImage(img2, this.getLocation().getX(), this.getLocation().getY()-size/10, size/2, size, pan);
	}
	public abstract void makeSound();
	public abstract EFoodType getFoodtype();
	public Object clone() {
		return this;	
	}
}