package plants;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {

	private static Cabbage cabbage_instance = null;

	private Cabbage(ZooPanel pan) {
		super(pan);
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}

	public static Cabbage getCabbage(ZooPanel pan){
		if (cabbage_instance == null){
			synchronized (Cabbage.class){
				if (cabbage_instance == null){
					cabbage_instance = new Cabbage(pan);
				}
			}
		}
		return cabbage_instance;
	}

	@Override
	public void loadImages(String nm) {
		// TODO Auto-generated method stub
		try { this.setImg(ImageIO.read(new File(PICTURE_PATH+"\\"+"cabbage.png"))); }
		catch (IOException e) { System.out.println("Cannot load image"); }
	}

	@Override
	public void drawObject(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(this.getImage(), this.getLocation().getX(), this.getLocation().getY(), 50, 50,super.getPan());
	}


	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

}
