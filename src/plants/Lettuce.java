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
public class Lettuce extends Plant {

	private static Lettuce lettuce_instance = null;

	private Lettuce(ZooPanel pan) {
		super(pan);
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}

	public static Lettuce getLettuce(ZooPanel pan){
		if (lettuce_instance == null){
			synchronized(pan) {
				if (lettuce_instance == null){
					lettuce_instance = new Lettuce(pan);
				}
			}
		}
		return lettuce_instance;
	}

	@Override
	public void loadImages(String nm) {
		// TODO Auto-generated method stub
		try { this.setImg(ImageIO.read(new File(PICTURE_PATH+"\\"+"lettuce.png"))); }
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
