package main;

import javax.swing.JFrame;

//jFrame is part of a collection of components that helpsus developers create a window or GUI
public class GameWindow {
//Create a constructor
	private JFrame jframe;
	
	public GameWindow(GamePanel gamePanel) {
		
		jframe = new JFrame();
		//Now make a call to make a window appear
		jframe.setSize(400, 400);

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//This closes the program whenever we close the window
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);//This line needs to be placed after previous line, order is IMPORTANT
		
	}
}
