package graphics;

import animals.Animal;

public class ColorDecorator extends ChangeColorDecorator{
    private String color;


    public ColorDecorator(Animal animal,String color) {
        super(animal);
        this.setColor(color);
    }

    public void setColor(String color) {
        this.color = color;
        ((Animal)animal).setCol(color);
    }

    @Override
    public void loadImages(String nm) {
        animal.loadImages(this.getColor());
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
