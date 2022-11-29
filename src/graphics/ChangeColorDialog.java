package graphics;

import animals.Animal;
import mobility.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static java.lang.Math.min;


public class ChangeColorDialog extends JDialog implements ActionListener {


    private JButton natural, red, blue;

    private ArrayList<JButton> arrayButton ;

    private ArrayList<Animal> arrayList;
    private int result = -1;

    private JButton Change;
    private int selectedAnimal;
    final String [] colourOfAnimal = {"Red","Blue","Natural"};
    final String[] selectedColor = new String[1];
    private ZooPanel pan;

    public ChangeColorDialog(ArrayList<Animal> list, ZooPanel pan) {
        super();
        selectedAnimal = -1;
        this.pan = pan;
        this.arrayList = new ArrayList<Animal>();
        for (int i = 0; i < list.size(); i++) {
            this.arrayList.add(list.get(i));
        }
        //super(window, "Select An Animal", true);
        JPanel Change_color = new JPanel();
        JPanel selectAnimal = new JPanel();
        JPanel selectColor = new JPanel();

        this.setLayout(new GridLayout(3, 0));
        selectAnimal.setLayout(new GridLayout(1, arrayList.size() + 1));
        selectColor.setLayout(new GridLayout(1, 4));


        selectColor.add(new JLabel("Select color: "));
        natural = new JButton("Natural");
        natural.addActionListener(this);
        selectColor.add(natural);
        red = new JButton("Red");
        red.addActionListener(this);
        selectColor.add(red);
        blue = new JButton("Blue");
        blue.addActionListener(this);
        selectColor.add(blue);
        selectAnimal.add(new JLabel("Select An Animal  :"));
        arrayButton = new ArrayList<JButton>();
        for (int i = 0; i < min(arrayList.size(),ZooPanel.MAX_POOL_SIZE); ++i) {
            arrayButton.add(new JButton(arrayList.get(i).getAnimalName()));
            int finalI = i;
            arrayButton.get(i).addActionListener(this);
            selectAnimal.add(arrayButton.get(i));
        }


        Change = new JButton("Change");
        Change.addActionListener(this);
        Change_color.add(Change);
        this.add(selectAnimal);
        this.add(selectColor);
        this.add(Change_color);

    }

    public int showDialog() {
        setLocationRelativeTo(getParent());
        pack();
        setVisible(true);
        return result;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        //result = JOptionPane.OK_OPTION;
        for(int i=0; i< min(arrayList.size(),ZooPanel.MAX_POOL_SIZE);++i ){
            if (e.getSource() == arrayButton.get(i))
                selectedAnimal = i;
        }

        if (e.getSource() == red)
            selectedColor [0]= colourOfAnimal[0];
        if (e.getSource() == blue)
            selectedColor [0]= colourOfAnimal[1];
        if (e.getSource() == natural)
            selectedColor [0]= colourOfAnimal[2];



        if (e.getSource() == Change) {
            //result = JOptionPane.OK_OPTION;
            if(selectedAnimal>-1 && selectedColor[0] !=null){
                IDrawable colory = new ColorDecorator(arrayList.get(selectedAnimal),selectedColor[0]);
                (colory).loadImages(selectedColor[0]);
               //((ColorDecorator)colory).setColor(selectedColor[0]);
            }
            setVisible(false);
        }
        pan.manageZoo();

    }

}


