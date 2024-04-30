package main;

import java.awt.Graphics;

import javax.swing.JPanel;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

public class GamePanel extends JPanel{
//We also need a constructor here
	
	private MouseInputs mouseInputs;
	private int xDelta = 100, yDelta = 100;
	private int frames = 0;
	private long lastCheck =0;
	
	public GamePanel() {
		
	    mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);	 
		addMouseMotionListener(mouseInputs);	
	
	}
	
	public void changeXDelta(int value) {
		this.xDelta +=value;
		
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
		
	}
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		
	}
	
	public void paintComponent(Graphics g) {
	//paintComponent: this ONLY gets called whenever we press the play button
	//Graphics allows us to draw
		super.paintComponent(g);//this line is calling the super class which is JPanel,it calls the JPanels own paint component method
		
		g.fillRect(xDelta, yDelta, 200, 50);//We need to assemble the jFrame and the jPanel
		//We need to add an argument 
		
		frames++;
		if(System.currentTimeMillis() - lastCheck >= 1000) {
			lastCheck = System.currentTimeMillis();
			System.out.println("FPS: " + frames);
			frames=0;
		}
			repaint();
	}
}
