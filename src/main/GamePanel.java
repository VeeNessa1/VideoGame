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

public class GamePanel extends JPanel{
//We also need a constructor here
	
	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100;
	private BufferedImage img, subImg; {
	}  
	
	//change x and y direction to float in order to slow down the rectangle
	
    
    public GamePanel() {
		
	    mouseInputs = new MouseInputs(this);
	    
	    importImg();
	    
	    
	    setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);	 
		addMouseMotionListener(mouseInputs);	
	
	}
	
	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/Hit.png"); //tasking in an image as an input stream to load the image 
		
		try {
			img = ImageIO.read(is);
	} catch (IOException e) {
		e.printStackTrace(); 
		}
	}

	private void setPanelSize() {
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
	}

	public void changeXDelta(int value) {
		this.xDelta += value;
		
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
		
		subImg = img.getSubimage(82,55,54,86);
		g.drawImage(subImg, (int) xDelta, (int) yDelta, 54, 86, null);
		

	}

	

	
}
