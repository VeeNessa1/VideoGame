package main;


import java.awt.Dimension;
 

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import utilz.Constants;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel{
//We also need a constructor here
	
	private MouseInputs mouseInputs;
	
	//If we are not moving then it is -1, if moving it is 0
	//we need a speed, which will determine how fast we are going to animate, the lower the value, the faster it will go, fastest we can go is one 
	//change x and y direction to float in order to slow down the rectangle
	
	
	private Game game; 
    public GamePanel(Game game) {
	    mouseInputs = new MouseInputs(this);
	    this.game = game;
	   //To-Do Instantiate player 
	    
	    
	    setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);	 
		addMouseMotionListener(mouseInputs);	
	
	}
	
   
	
	private void setPanelSize() {
		Dimension size = new Dimension(1280,800);
		setPreferredSize(size);
		
		
	} 


	public void updateGame() {
		
		
	}
	
	public void paintComponent(Graphics g) {
	//paintComponent: this ONLY gets called whenever we press the play button
	//Graphics allows us to draw
		super.paintComponent(g);//this line is calling the super class which is JPanel,it calls the JPanels own paint component method 
		game.render(g);
		

	}

	
	public Game getGame() {//Another getter for games
		return game;
	}

	
}
