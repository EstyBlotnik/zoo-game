package graphics;

import java.awt.Graphics;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */

public interface IDrawable {
	public final static String PICTURE_PATH = "src/graphics/assignment2_pictures";
	public void loadImages(String nm);
	public void drawObject (Graphics g);
	public String getColor();
}
