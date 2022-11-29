package graphics;

import animals.Animal;

import java.awt.*;

public abstract class ChangeColorDecorator implements IDrawable{

    protected IDrawable animal;
    public ChangeColorDecorator(Animal animal){
        this.animal=animal;
    }
    public void drawObject(Graphics g) {
        animal.drawObject(g);
    }
}
