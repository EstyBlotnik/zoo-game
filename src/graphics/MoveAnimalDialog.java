package graphics;

import java.awt.GridLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mobility.*;

import animals.*;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */


public class MoveAnimalDialog extends JDialog implements ActionListener {
	private final JTextField coordinateX;
    private final JTextField coordinateY;
    private JButton animal1,animal2,animal3,animal4,animal5,animal6,animal7,animal8,animal9,animal10;
    private ArrayList<Animal> arrayList;
    private int result = -1;
    private int x=0,y=0;
    private JButton Creat;
	private int selection;
    private int size;
    private ZooPanel pan;
    public MoveAnimalDialog(ArrayList<Animal> list,ZooPanel pan) {
        super();
        selection=0;
        this.pan=pan;
        this.arrayList=new ArrayList<Animal>();
        for(int i=0;i<list.size();i++)
        {
        	this.arrayList.add(list.get(i));
        }
        //super(window, "Select An Animal", true);
        JPanel selectAnimal = new JPanel();
        JPanel XCoordinate = new JPanel();
        JPanel YCoordinate = new JPanel();
        JPanel Move = new JPanel();
        //panelCreat.add(new JButton("Creat"));
		selectAnimal.setLayout(new GridLayout(1, arrayList.size()+1));
        XCoordinate.setLayout(new GridLayout(1, 2));
        YCoordinate.setLayout(new GridLayout(1, 2));
        //panelCreat.setLayout(new GridLayout(1,1));

        this.setLayout(new GridLayout(4, 0));

        selectAnimal.add(new JLabel("Select An Animal  :"));
        if(arrayList.size()>=1) {
        	animal1 = new JButton(arrayList.get(0).getAnimalName());
        	animal1.addActionListener(this);
        	selectAnimal.add(animal1);
        }
        if(arrayList.size()>=2) {
        	animal2 = new JButton(arrayList.get(1).getAnimalName());
        	animal2.addActionListener(this);
        	selectAnimal.add(animal2);
        }
        if(arrayList.size()>=3) {
        	animal3 = new JButton(arrayList.get(2).getAnimalName());
        	animal3.addActionListener(this);
        	selectAnimal.add(animal3);
        }
        if(arrayList.size()>=4) {
        	animal4 = new JButton(arrayList.get(3).getAnimalName());
        	animal4.addActionListener(this);
        	selectAnimal.add(animal4);
        }
        if(arrayList.size()>=5) {
        	animal5 = new JButton(arrayList.get(4).getAnimalName());
        	animal5.addActionListener(this);
        	selectAnimal.add(animal5);
        }
        if(arrayList.size()>=6) {
        	animal6 = new JButton(arrayList.get(5).getAnimalName());
        	animal6.addActionListener(this);
        	selectAnimal.add(animal6);
        }
        if(arrayList.size()>=7) {
        	animal7 = new JButton(arrayList.get(6).getAnimalName());
        	animal7.addActionListener(this);
        	selectAnimal.add(animal7);
        }
        if(arrayList.size()>=8) {
        	animal8 = new JButton(arrayList.get(7).getAnimalName());
        	animal8.addActionListener(this);
        	selectAnimal.add(animal8);
        }
        if(arrayList.size()>=9) {
        	animal9 = new JButton(arrayList.get(8).getAnimalName());
        	animal9.addActionListener(this);
        	selectAnimal.add(animal9);
        }
        if(arrayList.size()==10) {
        	animal10 = new JButton(arrayList.get(9).getAnimalName());
        	animal10.addActionListener(this);
        	selectAnimal.add(animal10);
        }
        XCoordinate.add(new JLabel("Cordynata X: "));

        XCoordinate.add(coordinateX = new JTextField());

        YCoordinate.add(new JLabel("Cordynata Y: "));

        YCoordinate.add(coordinateY = new JTextField());
        
        
        Creat = new JButton("Move");
        Creat.addActionListener(this);
        Move.add(Creat);
        this.add(selectAnimal);
        this.add(XCoordinate);
        this.add(YCoordinate);
        this.add(Move);



    }

    public int showDialog() {
    	setLocationRelativeTo(getParent());
    	pack();
    	setVisible(true);
    	return result;
    
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		result = JOptionPane.OK_OPTION;
		if(e.getSource()==animal1)
			selection=0;
		if(e.getSource()==animal2)
			selection=1;
		if(e.getSource()==animal3)
			selection=2;
		if(e.getSource()==animal4)
			selection=3;
		if(e.getSource()==animal5)
			selection=4;
		if(e.getSource()==animal6)
			selection=5;
		if(e.getSource()==animal7)
			selection=6;
		if(e.getSource()==animal8)
			selection=7;
		if(e.getSource()==animal9)
			selection=8;
		if(e.getSource()==animal10)
			selection=9;
		if(e.getSource()==Creat) {
			result = JOptionPane.OK_OPTION;
			String Xvalue = coordinateX.getText();
			String Yvalue = coordinateY.getText();
			try{
				x=Integer.parseInt(Xvalue);
				}
			catch(NumberFormatException ex){
				ex.printStackTrace();
			}
			try{
				y=Integer.parseInt(Yvalue);
				}
			catch(NumberFormatException ex){
				ex.printStackTrace();
				}
			if(x>=0&&x<=800&&y>=0&&y<=600) {
				arrayList.get(selection).move(new Point(x,y));
				arrayList.get(selection).setChanges(true);

			}
			System.out.println(size);
			pan.manageZoo();
			setVisible(false);
            }
		
		}
	
}
