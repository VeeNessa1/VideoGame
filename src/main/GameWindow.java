package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

// jFrame is part of a collection of components that helpsus developers create a window or GUI
public class GameWindow
{
	private JFrame jframe;

	// Create a constructor
	public GameWindow(GamePanel gamePanel)
	{
		// Now make a call to make a window appear
		this.jframe = new JFrame();

		// This closes the program whenever we close the window
		this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.jframe.add(gamePanel);
		this.jframe.setLocationRelativeTo(null);
		this.jframe.setResizable(false);

		// This method needs to be called *before* setVisible
		this.jframe.pack();

		// This line needs to be placed after previous line, order is IMPORTANT
		this.jframe.setVisible(true);
		this.jframe.addWindowFocusListener(new WindowFocusListener()
		{
			@Override
			public void windowLostFocus(WindowEvent e)
			{
				gamePanel.getGame().windowFocusLost();
			}

			@Override
			public void windowGainedFocus(WindowEvent e)
			{
				// TODO Auto-generated method stub
			}
		});
	}
}
