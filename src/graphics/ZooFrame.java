package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 * Ashdod Campus
 * @author Esty Friedman 209531482
 * @author Malky Rotshild 308464262
 *
 */


@SuppressWarnings("serial")
public class ZooFrame extends JFrame implements ActionListener{
	private JMenuBar mb;
	private ZooPanel panel;
	// JMenu
	private JMenu file,Background,help;
	// Menu items
	private JMenuItem exit, imageBackground, greenBackground,noBackground,help1;
	@SuppressWarnings("deprecation")
	public ZooFrame() {
		super("Zoo");
		this.setSize(1300,670);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panel=ZooPanel.getPan();
		this.add(panel);
		//panel.getController().start();
		mb=new JMenuBar();
		//create a menu
		file = new JMenu("File");
		Background=new JMenu("Background");
		help=new JMenu("Help");
		// create menuitems
		try {
			exit =  new JMenuItem("Exit");
			exit.addActionListener(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imageBackground = new JMenuItem("image");
		imageBackground.addActionListener(this);
		greenBackground = new JMenuItem("Green");
		greenBackground.addActionListener(this);
		noBackground=new JMenuItem("None");
		noBackground.addActionListener(this);
		help1=new JMenuItem("help");
		help1.addActionListener(this);

		// add menu items to menu
		file.add(exit);
		Background.add(imageBackground);
		Background.add(greenBackground);
		Background.add(noBackground);
		help.add(help1);
		// add menu to menu bar
		mb.add(file);
		mb.add(Background);
		mb.add(help);
		this.setJMenuBar(mb);
		//this.add(mb,BorderLayout.NORTH);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	//	this.setUndecorated(true);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			System.exit(0);
		if(e.getSource() ==help1 )
			JOptionPane.showMessageDialog(help1, "Home Work 2 GUI");
		if(e.getSource() == imageBackground) {
			this.panel.setImage();
			this.panel.repaint();
		}
		if(e.getSource() == greenBackground) {
			this.panel.setImg();
			this.panel.setBackground(Color.green);
			this.panel.repaint();	
		}
		if(e.getSource() == noBackground) {
			this.panel.setImg();
			this.panel.setBackground(null);
			this.panel.repaint();	
		}

	}
	public void setPanel(ZooPanel pan ){
		this.panel=pan;
	}

	public static void main(String[] args)
	{
		//AddAnimalDialog animalDialog=new AddAnimalDialog();
		//We've created a dialogue to manage our animals
		new ZooFrame();

	}
}


