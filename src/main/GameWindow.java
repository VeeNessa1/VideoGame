package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;


//jFrame is part of a collection of components that helpsus developers create a window or GUI
public class GameWindow {
//Create a constructor
	private JFrame jframe;
	
	public GameWindow(GamePanel gamePanel) {
		
		jframe = new JFrame();
		//Now make a call to make a window appear
		
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//This closes the program whenever we close the window
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.pack();
		jframe.setVisible(true);//This line needs to be placed after previous line, order is IMPORTANT
		jframe.addWindowFocusListener(new WindowFocusListener() {
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				gamePanel.getGame().windowFocusLost();
				
			}
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
}
			
			
			

