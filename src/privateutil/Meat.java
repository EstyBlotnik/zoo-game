package privateutil;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.ILocatable;
import mobility.Point;
import plants.Cabbage;
import utilities.MessageUtility;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */

public class Meat implements IEdible,IDrawable{
	private static Meat meat_instance =null;

	private BufferedImage img= null;
	private ZooPanel pan;
	private Point location;
	private double weight;
	private double height;

	private Meat(ZooPanel pan) {
		Random rand = new Random();
		int x = 400;//rand.nextInt(30);
		int y = 300;//rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);

		//MessageUtility.logConstractor("Plant", "Plant");
		this.loadImages("");
		//this.drawObject(this.pan.getGraphics());
	}

	public static Meat getMeat(ZooPanel pan){
		if (meat_instance == null){
			synchronized(pan) {
				if(meat_instance == null)
					meat_instance = new Meat(pan);
			}
		}
		return meat_instance;
	}

	public BufferedImage getImage() {
		return this.img;
	}
	public EFoodType getFoodtype() {
		//MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.MEAT;
	}
	public void loadImages(String nm) {
		// TODO Auto-generated method stub
		try { this.img=ImageIO.read(new File(PICTURE_PATH+"\\"+"meat.gif")); }
		catch (IOException e) { System.out.println("Cannot load image"); }
	}
	@Override
	public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(this.img, this.location.getX(), this.location.getY(),50,50,pan);
	}
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	public Point getLocation() {
		return this.location;
	}
}
