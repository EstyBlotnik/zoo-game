package graphics;

import javax.swing.*;

import animals.*;
import mobility.Point;
//import privateutil.LoginDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */


public class AddAnimalDialog extends JDialog {
    private final JTextField tbSize,tbHSpeed,tbVSpeed;
    private int result = -1;
    private int size;
  //  JLabel lbUsername;
   // private Animal animal;

    //private Animal[] animalArr;
    //private int sizeOfArr;
    public AddAnimalDialog(ArrayList<Animal> arrayList,ZooPanel pan,final String[]  kindOfAnimal,int sizeOfArr) {
        super();
        //super(window, "Select An Animal", true);

        //final String []kindOfAnimal={"Lion","Bear","Elephant","Giraffe","Turtle"};
        final String[] kindAnimal = new String[1];
        final String [] colourOfAnimal = {"Red","Blue","Natural"};
        final String[] colourAnimal = new String[1];
        int size = 0 ;
        kindAnimal[0]=null;
        colourAnimal[0]="Natural";

        JPanel panelAnimal = new JPanel();
        JPanel panelcolour = new JPanel();
        JPanel panelSize = new JPanel();
        JPanel panelHSpeed = new JPanel();
        JPanel panelVSpeed = new JPanel();

        JPanel panelCreat = new JPanel();
        panelAnimal.setLayout(new GridLayout(1, sizeOfArr+1));
        panelcolour.setLayout(new GridLayout(1, 5));
        panelSize.setLayout(new GridLayout(1, 2));
        panelHSpeed.setLayout(new GridLayout(1, 2));
        panelVSpeed.setLayout(new GridLayout(1, 2));

        //panelCreat.setLayout(new GridLayout(1,1));
        this.setLayout(new GridLayout(6, 0));
        panelAnimal.add(new JLabel("Select An Animal  :"));
        panelcolour.add(new JLabel("Select a colour:"));
        panelSize.add(new JLabel("Size: "));
        panelSize.add(tbSize = new JTextField());
        panelHSpeed.add(new JLabel("Horizontal speed: "));
        panelHSpeed.add(tbHSpeed = new JTextField());
        panelVSpeed.add(new JLabel("Vertical speed: "));
        panelVSpeed.add(tbVSpeed = new JTextField());
        JButton Creat = new JButton("Creat");
        Creat.addActionListener(new ActionListener() {
            private int size;
            private int horSpeed;
            private int verSpeed;

			@Override
            public void actionPerformed(ActionEvent e) {
            	 result = JOptionPane.OK_OPTION;
            	 String values = tbSize.getText();
                 try{
                     this.size=Integer.parseInt(values);
                 }
                 catch(NumberFormatException ex){
                     ex.printStackTrace();
                 }
                 if(size<50||size>300)
                     JOptionPane.showMessageDialog(pan, "Size should be between 50 and 300");
                     //size=100;
                values = tbHSpeed.getText();
                try{
                    this.horSpeed=Integer.parseInt(values);
                }
                catch(NumberFormatException ex){
                    ex.printStackTrace();
                }

                if(horSpeed>10||horSpeed<1){
                    //horSpeed=5;
                    JOptionPane.showMessageDialog(pan, "HorSpeed should be between 1 and 10");
                }

                values = tbVSpeed.getText();
                try{
                    this.verSpeed=Integer.parseInt(values);
                }
                catch(NumberFormatException ex){
                    ex.printStackTrace();
                }

                if(verSpeed>10||verSpeed<1) {
                    //verSpeed = 5;
                    JOptionPane.showMessageDialog(pan, "VerSpeed should be between 1 and 10");
                }
                if(!(  size<50||size>300 || horSpeed>10||horSpeed<1 || verSpeed>10||verSpeed<1)){
                    Animal animal = null;
                    synchronized ( pan.getthreadPool()){
                        synchronized (pan){
                            switch (kindAnimal[0]) {
                                case "Lion":
                                    animal = new Lion(pan, size, colourAnimal[0], horSpeed, verSpeed);
                                    break;
                                case "Bear":
                                    animal = new Bear(pan, size, colourAnimal[0], horSpeed, verSpeed);
                                    break;
                                case "Elephant":
                                    animal = new Elephant(pan, size, colourAnimal[0], horSpeed, verSpeed);
                                    break;
                                case "Giraffe":
                                    animal = new Giraffe(pan, size, colourAnimal[0], horSpeed, verSpeed);
                                    break;
                                case "Turtle":
                                    animal = new Turtle(pan, size, colourAnimal[0], horSpeed, verSpeed);
                                    break;
                                default:
                                    break;
                            }
                            if(animal!=null){
                                arrayList.add(animal);
                                if(arrayList.size()<=10){
                                    pan.getthreadPool().execute(animal);
                                }
                            }

                        }

                    }

                    // System.out.println(tbSize);
                    //result = JOptionPane.CLOSED_OPTION;
                    //pan.manageZoo();
                    setVisible(false);
                }
            }
        });
        panelCreat.add(Creat);

        ArrayList<JButton> arry = new ArrayList<JButton> ();

        for(int i=0;i <sizeOfArr;++i) {
            arry.add(new JButton(kindOfAnimal[i]));
            int finalI = i;
            arry.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    kindAnimal[0] =kindOfAnimal[finalI];
                }
            });
            panelAnimal.add(arry.get(i));

        }

//        JButton Lion = new JButton("Lion");
//        Lion.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kindAnimal[0] =kindOfAnimal[0];
//            }
//        });
//        //panelAnimal.add(Lion);
//
//
//        JButton Bear = new JButton("Bear");
//        Bear.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kindAnimal[0] =kindOfAnimal[1];
//                //System.out.println(tbSize);
//            }
//        });
//        //panelAnimal.add(Bear);
//
//        JButton Elephant = new JButton("Elephant");
//        Elephant.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kindAnimal[0] =kindOfAnimal[2];
//                //result = JOptionPane.CLOSED_OPTION;
//                //setVisible(false);
//            }
//        });
//        //panelAnimal.add(Elephant);
//
//        JButton Giraffe = new JButton("Giraffe");
//        Giraffe.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kindAnimal[0] =kindOfAnimal[3];
//                //result = JOptionPane.CLOSED_OPTION;
//                //setVisible(false);
//            }
//        });
//        //panelAnimal.add(Giraffe);
//
//        JButton Turtle = new JButton("Turtle");
//        Turtle.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kindAnimal[0] =kindOfAnimal[4];
//            }
//        });
//        //panelAnimal.add(Turtle);
//

        JButton Red = new JButton("Red");
        Red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colourAnimal[0] =colourOfAnimal[0];
            }
        });
        panelcolour.add(Red);



        JButton Blue = new JButton("Blue");
        Blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colourAnimal[0] =colourOfAnimal[1];
            }
        });
        panelcolour.add(Blue);

        JButton Natural = new JButton("Natural");
        Natural.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colourAnimal[0] = colourOfAnimal[2];
            }
        });

        panelcolour.add(Natural);

        this.add(panelAnimal);
        this.add(panelcolour);
        this.add(panelSize);
        this.add(panelHSpeed);
        this.add(panelVSpeed);
        this.add(panelCreat);



    }


    public int showDialog() {
    	setLocationRelativeTo(getParent());
    	pack();
    	setVisible(true);
    	return result;
    
    }
}
