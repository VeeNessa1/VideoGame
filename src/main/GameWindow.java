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
		jframe = new JFrame();

		// This closes the program whenever we close the window
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);

		// This method needs to be called *before* setVisible
		jframe.pack();

		// This line needs to be placed after previous line, order is IMPORTANT
		jframe.setVisible(true);
		jframe.addWindowFocusListener(new WindowFocusListener()
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
