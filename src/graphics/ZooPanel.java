package graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import animals.Animal;
import food.EFoodType;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;
import privateutil.KindOfDiet;
import privateutil.Meat;


import static java.lang.Thread.State.WAITING;
import static java.lang.Math.min;


/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */


@SuppressWarnings("serial")
public class ZooPanel extends JPanel implements ActionListener ,Cloneable{
	static JFrame f;
	
	private Executor threadPoolExecutor;
	public static int MAX_POOL_SIZE = 10;
	private static ZooPanel pan_instance=null;

	private ArrayList<Animal> arrayList;
	private Plant plant;
	private Meat steak;
	private BufferedImage img = null;
	private JButton addAnimal,Change_color,Save_status,Restore_status, Sleep, Wake_up, Clear, Food, Info, Exit;
	//private Thread controller;
	private GridLayout myGridLayout ;
	private JPanel SouthPanel ;
	
	@SuppressWarnings("unused")
	private class panelState implements Memento{
		private ArrayList<Animal> arrayList;
		private Plant plant;
		private Meat steak;
		private Executor threadPoolExecutor;
		private int totalEatCount;
		private BufferedImage img = null;
		private panelState(ArrayList<Animal> arrayList,Plant plant,Meat steak,Executor threadPoolExecutor,int totalEatCount,BufferedImage img) {
			this.arrayList=new ArrayList<Animal>();
			for(int i=0;i<arrayList.size();i++)
			{
				Animal animal=arrayList.get(i);
				this.arrayList.add((Animal) animal.clone());
			}
			this.plant=plant;
			this.steak=steak;
			this.threadPoolExecutor=threadPoolExecutor;
			this.totalEatCount=totalEatCount;
			this.img = img;
		}
	}
	public Memento save() {
		return new panelState(arrayList,plant,steak,threadPoolExecutor,Animal.TotalEatCount,img);
		}
	public void restore(Memento state) {
		int size=arrayList.size();
		for(int i=0;i<size;i++) {
			this.arrayList.get(0).setThreadExit(true);
			this.arrayList.remove(0);
		}
		for(int i=0;i<((panelState)state).arrayList.size();i++) {
			this.arrayList.add(((panelState)state).arrayList.get(i));
			if(i<10)
			{
				this.getthreadPool().execute(((panelState)state).arrayList.get(i));
			}
		}
		this.plant=((panelState)state).plant;
		this.steak=((panelState)state).steak;
		this.threadPoolExecutor=((panelState)state).threadPoolExecutor;
		Animal.TotalEatCount=((panelState)state).totalEatCount;
		this.img=((panelState)state).img;
		//currentText = new StringBuilder(((TextWindowState)state).getText());
		}
	private ZooPanel() {
		super();
		//controller = new Thread(this);
		threadPoolExecutor = Executors.newFixedThreadPool(MAX_POOL_SIZE);
		this.arrayList = new ArrayList<Animal>();
		this.plant = null;
		this.steak = null;
		addAnimal = new JButton("Add Animal");
		addAnimal.addActionListener(this);
		Change_color = new JButton("Change color");
		Change_color.addActionListener(this);
		Save_status = new JButton("Save status");
		Save_status.addActionListener(this);
		Restore_status = new JButton("Restore status");
		Restore_status.addActionListener(this);
		//moveAnimal=new JButton("Move Animal");
		//moveAnimal.addActionListener(this);
		Sleep = new JButton("Sleep");
		Sleep.addActionListener(this);
		Wake_up = new JButton("Wake up");
		Wake_up.addActionListener(this);
		Clear = new JButton("Clear");
		Clear.addActionListener(this);
		Food = new JButton("Food");
		Food.addActionListener(this);
		Info = new JButton("Info");
		Info.addActionListener(this);
		Exit = new JButton("Exit");
		Exit.addActionListener(this);


		myGridLayout = new GridLayout(1, 10);
		SouthPanel = new JPanel();
		SouthPanel.setLayout(myGridLayout);
		SouthPanel.add(addAnimal);
		SouthPanel.add(Change_color);
		SouthPanel.add(Save_status);
		SouthPanel.add(Restore_status);
		//SouthPanel.add(moveAnimal);
		SouthPanel.add(Sleep);
		SouthPanel.add(Wake_up);
		SouthPanel.add(Clear);
		SouthPanel.add(Food);
		SouthPanel.add(Info);
		SouthPanel.add(Exit);

		this.setLayout(new BorderLayout());
		this.add(SouthPanel, BorderLayout.SOUTH);
		//this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		this.setSize(800, 600);
		//this.setBackground(Color.GRAY);		
	}

	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}
	public Executor getthreadPool(){
		return this.threadPoolExecutor;
	}

//	public int min(int size, int i) {
//		if (size>i)
//			return i;
//		return size;
//	}


	public static ZooPanel getPan(){
		if (pan_instance == null){
			pan_instance = new ZooPanel();
		}

		return pan_instance;
	}

//	public Thread getController() {
//		return controller;
//	}

	public void setImage() {
		try {
			img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\savanna.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}

	public void setImg() {
		this.img = null;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Graphics2D g2d=(Graphics2D) g;
		if (img != null)
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		for (int i = 0; i < min(arrayList.size(),MAX_POOL_SIZE); ++i)
			arrayList.get(i).drawObject(this.getGraphics());
		if (plant != null)
			plant.drawObject(this.getGraphics());
		if (steak != null)
			steak.drawObject(this.getGraphics());
	}

	@SuppressWarnings("null")
	public void manageZoo() {
		if (plant != null) {
			for (int i=0 ; i< min(arrayList.size(),MAX_POOL_SIZE);++i) {
				synchronized (arrayList.get(i)) {
					synchronized (plant) {

						if (arrayList.get(i) != null && plant != null /*&& arrayList.get(i).getThread().getState()!=WAITING*/) {

							//����� ��� ���� ����� ����� �� ��� ����� ����� ���
							if (arrayList.get(i).getIDiet().canEat(plant.getFoodtype())) {
								//����� ����� ���� x
								if (arrayList.get(i).getLocation().getX() > plant.getLocation().getX())
									arrayList.get(i).setX_dir(-1);
								else
									arrayList.get(i).setX_dir(1);
								//����� ����� ���� y
								if (arrayList.get(i).getLocation().getY() > plant.getLocation().getY())
									arrayList.get(i).setY_dir(-1);
								else
									arrayList.get(i).setY_dir(1);
							}

						}
					}

				}
			}
			Animal closedestAnimal = null;
			for (int i = 0; i < min(arrayList.size(),MAX_POOL_SIZE); i++) {
				Animal animal = arrayList.get(i);
				if (animal.calcDistance(plant.getLocation()) < animal.getEAT_DISTANCE()) {
					boolean canEat = animal.getIDiet().canEat(plant.getFoodtype());
					if (closedestAnimal == null) {
						if (canEat)
							closedestAnimal = animal;
					} else if (closedestAnimal.calcDistance(plant.getLocation()) >
							animal.calcDistance(plant.getLocation()) && canEat)
						closedestAnimal = animal;
				}
			}
			if (closedestAnimal != null) {
				closedestAnimal.eat(plant);
				plant = null;
				repaint();
			}
		}

		if (steak != null) {
			//for (int i=0 ; i< min(arrayList.size(),MAX_POOL_SIZE);++i) {
			for (Animal i : arrayList) {
				synchronized (i) {
					if (i != null && steak != null /*&& i.getThread().getState()!=WAITING*/) {

						//����� ��� ���� ����� ����� �� ��� ����� ����� �����
						if (i.getIDiet().canEat(steak.getFoodtype())) {
							//����� ����� ���� x
							if (i.getLocation().getX() > steak.getLocation().getX())
								i.setX_dir(-1);
							else
								i.setX_dir(1);
							//����� ����� ���� y
							if (i.getLocation().getY() > steak.getLocation().getY())
								i.setY_dir(-1);
							else
								i.setY_dir(1);
						}
					}
				}

			}

			Animal closedestAnimal = null;
			//for (int i=0 ; i< min(arrayList.size(),MAX_POOL_SIZE);++i) {
			for (Animal i : arrayList) {
				Animal animal = i;
				if (animal.calcDistance(steak.getLocation()) < animal.getEAT_DISTANCE()) {
					boolean canEat = animal.getIDiet().canEat(steak.getFoodtype());
					if (closedestAnimal == null) {
						if (canEat)
							closedestAnimal = animal;
					} else if (closedestAnimal.calcDistance(steak.getLocation()) > animal.calcDistance(steak.getLocation()) && canEat)
						closedestAnimal = animal;
				}
			}
			if (closedestAnimal != null) {
				closedestAnimal.eat(steak);
				steak = null;
				repaint();
			}
		}
		boolean haveCanges = false;
		for (int i=0 ; i<min(arrayList.size(),MAX_POOL_SIZE);++i) {
			synchronized (arrayList.get(i)){
				if(i<arrayList.size()){
					if (arrayList.get(i).getChanges()) {
						haveCanges = true;
						arrayList.get(i).setChanges(false);
					}
				}
			}
		}

		if (haveCanges) {
			//for (int i=0 ; i< min(arrayList.size(),MAX_POOL_SIZE);++i) {
			for (Animal i : arrayList) {

				Animal closedestAnimal = null;
				EFoodType efood = i.getFoodtype();
				//boolean canEat=arrayList.get(i).getIDiet().canEat(efood);
				if (efood == EFoodType.MEAT) {
					for (Animal j : arrayList) {
						if (i != j && j.getWeight() > 2 * i.getWeight() &&
								i.calcDistance(j.getLocation()) < i.getSize() &&
								j.getIDiet().canEat(efood)) {
							if (closedestAnimal == null)
								closedestAnimal = j;
							else if (i.calcDistance(j.getLocation()) < i.calcDistance(closedestAnimal.getLocation()))
								closedestAnimal = j;
						}
					}
					if (closedestAnimal != null) {
						closedestAnimal.eat(i);
						i.setThreadExit(true);
						//arrayList.get(i).getThread().stop();//�� ���� ��� �������???????????
						Animal.TotalEatCount = Animal.TotalEatCount-i.getEatCount();
						arrayList.remove(i);
						this.repaint();
					}
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//addAnimal,moveAnimal,Clear,Food,Info,Exit
		if (e.getSource() == addAnimal) {
			if (arrayList.size() == MAX_POOL_SIZE+5) {
				JOptionPane.showMessageDialog(addAnimal, "You cannot add more than 15 animals");
			} else {
				//new AddAnimalDialog(arrayList, this).showDialog();
				//arrayList.get(arrayList.size()).drawObject(getGraphics());
				KindOfDiet factory = KindOfDiet.selectFactory(this);
				factory.createAnimal(arrayList, this);
			}
		}

		if (e.getSource() == Save_status){
			Originator.getOriginator(this).hitSave();
			System.out.println("Save_status");	
		}

		if (e.getSource() == Restore_status){
			if(Originator.getOriginator(this).getSize()<=0){
				JOptionPane.showMessageDialog(Restore_status, "There  is no status to restore");
			}
			//frame.setPanel(Originator.getOriginator().pop_status());
			System.out.println("Restore_status");
			Originator.getOriginator(this).hitUndo();
			//frame.repaint();
		}

		if (e.getSource() == Change_color) {
			new ChangeColorDialog(arrayList, this).showDialog();

		}
		if (e.getSource() == Sleep) {
			for (Animal i : arrayList) {
				synchronized (i){
					i.setSuspended();
				}
			}
		}
		if (e.getSource() == Wake_up) {
			for (Animal i : arrayList) {
				synchronized (i) {
					if (i.getThreadSuspended()) {
						i.setResumed();

					}
				}
				//arrayList.get(i).notifyAll();
			}
		}
//			if(e.getSource()==moveAnimal) {
//				if(arrayList.size()==0) {
//					JOptionPane.showMessageDialog(moveAnimal, "No moveable animal");
//				}
//				else
//					new MoveAnimalDialog(arrayList,this).showDialog();
//			}
		if (e.getSource() == Clear) {
			this.clearAll();
			//JOptionPane.showMessageDialog(Clear,"All the animals have been deleted from the panel.");
			//repaint();
		}
		if (e.getSource() == Food) {
			this.addFood();
			this.manageZoo();
		}
		if (e.getSource() == Info) {
			f = new JFrame();
			int size = min(arrayList.size(),MAX_POOL_SIZE);
			String data[][] = new String[size + 1][6];
			//String row []={"Lion","Elephant","Bear","Giraffe","Turtle","Total"};
			for (int i = 0; i < size; i++) {
				data[i][0] = arrayList.get(i).getName();
				data[i][1] = arrayList.get(i).getColor();
				data[i][2] = String.valueOf(arrayList.get(i).getWeight());
				data[i][3] = String.valueOf(arrayList.get(i).getHorSpeed());
				data[i][4] = String.valueOf(arrayList.get(i).getVerSpeed());
				data[i][5] = String.valueOf(arrayList.get(i).getEatCount());
			}
			data[size][0] = "Total:";
			data[size][5] = String.valueOf(Animal.TotalEatCount);
			String column[] = {"Animal", "Color", "Weight", "Hor.speed", "Ver.speed", "Eat counter"};
			JTable jt = new JTable(data, column);
			jt.setBounds(30, 40, 200, 300);
			JScrollPane sp = new JScrollPane(jt);
			f.add(sp);
			f.setSize(600, 300);
			f.setVisible(true);
		}


		if (e.getSource() == Exit) {
			System.exit(0);
			((ExecutorService)threadPoolExecutor).shutdown();
		}
	}
	public void clearAll() {
		int size = min( this.arrayList.size(),MAX_POOL_SIZE);
		plant=null;
		steak=null;

		for (int i=0;i<size;i++){

			synchronized (arrayList.get(0)){
				this.arrayList.get(0).notifyAll();
				this.arrayList.get(0).setThreadExit(true);
				this.arrayList.remove(0);
			}
			//���� �����
//			try {
//				this.getController().sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}

			this.arrayList.get(0).getThread().isAlive();

			System.out.println(this.arrayList.get(0).getThread().isAlive());
			this.arrayList.remove(arrayList.get(0));
		}
		for(int i=0; i < arrayList.size();++i){
			threadPoolExecutor.execute(arrayList.get(i));
		}

		Animal.TotalEatCount=0;
		plant=null;
		steak=null;
		this.repaint();
	}
	public void addFood(){

		  int result = -1;
		  while (result <0) {
			  		String[] options = {"Lettuce", "Cabbage", "Meat"};
		              result = JOptionPane.showOptionDialog(this, "Please choose food", "Food for animals",
		                      JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		  }
		  synchronized (this){
			  switch(result){

				  case 0:
					  if(plant!=null)
						  return;
					  this.plant=Lettuce.getLettuce(this);
					  break;
				  case 1:
					  if(plant!=null)
						  return;
					  this.plant=Cabbage.getCabbage(this);
					  break;
				  case 2:
					  if(steak!=null)
						  return;
					  this.steak=Meat.getMeat(this);
					  break;

			  }
			  this.repaint();
		  }

	  }

//	@Override
//	public void run() {
//		while(this.controller.isAlive()){
//			this.manageZoo();
//		}
//
//	}
}
