package diet;

import animals.Animal;
import graphics.ZooPanel;

import java.awt.*;
import java.util.ArrayList;

public interface AnimalFactory {
    public  void createAnimal(ArrayList<Animal> arrayList, ZooPanel pan) ;

}
