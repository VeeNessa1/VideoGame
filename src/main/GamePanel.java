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

public class GamePanel extends JPanel{
//We also need a constructor here
	
	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100;
	private BufferedImage[][] animations; 	
	private int aniTick, aniIndex, aniSpeed = 15;
	//we need a speed, which will determine how fast we are going to animate, the lower the value, the faster it will go, fastest we can go is one 
	//change x and y direction to float in order to slow down the rectangle
	
	private BufferedImage attack1_img;
    private BufferedImage attack2_img;
    private BufferedImage death_img;
    private BufferedImage fall_img;
    private BufferedImage hit_img;
    private BufferedImage idle_img;
    private BufferedImage jump_img;
    private BufferedImage run_img;
	
    
    public GamePanel() {
		
	    mouseInputs = new MouseInputs(this);
	    
	    importImg();
	    loadAnimations();
	    
	    
	    setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);	 
		addMouseMotionListener(mouseInputs);	
	
	}
	
    private void loadAnimations() {
    	final int ANIM_WIDTH = 231;
    	final int ANIM_HEIGHT = 190;

    	this.animations = new BufferedImage[8][8];

    	for (int i = 0; i < Constants.PlayerConstants.GetSpriteAmount(Constants.PlayerConstants.ATTACK_1); i++)
    		this.animations[Constants.PlayerConstants.ATTACK_1][i] = this.attack1_img.getSubimage(i * ANIM_WIDTH, 0, ANIM_WIDTH, ANIM_HEIGHT);

    	for (int i = 0; i < Constants.PlayerConstants.GetSpriteAmount(Constants.PlayerConstants.ATTACK_2); i++)
    		this.animations[Constants.PlayerConstants.ATTACK_2][i] = this.attack2_img.getSubimage(i * ANIM_WIDTH, 0, ANIM_WIDTH, ANIM_HEIGHT);

    	for (int i = 0; i < Constants.PlayerConstants.GetSpriteAmount(Constants.PlayerConstants.DEATH); i++)
    		this.animations[Constants.PlayerConstants.DEATH][i] = this.death_img.getSubimage(i * ANIM_WIDTH, 0, ANIM_WIDTH, ANIM_HEIGHT);

    	for (int i = 0; i < Constants.PlayerConstants.GetSpriteAmount(Constants.PlayerConstants.FALLING); i++)
    		this.animations[Constants.PlayerConstants.FALLING][i] = this.fall_img.getSubimage(i * ANIM_WIDTH, 0, ANIM_WIDTH, ANIM_HEIGHT);

    	for (int i = 0; i < Constants.PlayerConstants.GetSpriteAmount(Constants.PlayerConstants.HIT); i++)
    		this.animations[Constants.PlayerConstants.HIT][i] = this.hit_img.getSubimage(i * ANIM_WIDTH, 0, ANIM_WIDTH, ANIM_HEIGHT);

    	for (int i = 0; i < Constants.PlayerConstants.GetSpriteAmount(Constants.PlayerConstants.IDLE); i++)
    		this.animations[Constants.PlayerConstants.IDLE][i] = this.idle_img.getSubimage(i * ANIM_WIDTH, 0, ANIM_WIDTH, ANIM_HEIGHT);

    	for (int i = 0; i < Constants.PlayerConstants.GetSpriteAmount(Constants.PlayerConstants.JUMP); i++)
    		this.animations[Constants.PlayerConstants.JUMP][i] = this.jump_img.getSubimage(i * ANIM_WIDTH, 0, ANIM_WIDTH, ANIM_HEIGHT);

    	for (int i = 0; i < Constants.PlayerConstants.GetSpriteAmount(Constants.PlayerConstants.RUNNING); i++)
    		this.animations[Constants.PlayerConstants.RUNNING][i] = this.run_img.getSubimage(i * ANIM_WIDTH, 0, ANIM_WIDTH, ANIM_HEIGHT);
	}
    
	private void importImg() {
        InputStream attack1_is = getClass().getResourceAsStream("/Attack1.png");
        InputStream attack2_is = getClass().getResourceAsStream("/Attack2.png");
        InputStream death_is = getClass().getResourceAsStream("/Death.png");
        InputStream fall_is = getClass().getResourceAsStream("/Fall.png");
        InputStream hit_is = getClass().getResourceAsStream("/Hit.png");
        InputStream idle_is = getClass().getResourceAsStream("/Idle.png");
        InputStream jump_is = getClass().getResourceAsStream("/Jump.png");
        InputStream run_is = getClass().getResourceAsStream("/Run.png");

        try {
            this.attack1_img = ImageIO.read(attack1_is);
            this.attack2_img = ImageIO.read(attack2_is);
            this.death_img = ImageIO.read(death_is);
            this.fall_img = ImageIO.read(fall_is);
            this.hit_img = ImageIO.read(hit_is);
            this.idle_img = ImageIO.read(idle_is);
            this.jump_img = ImageIO.read(jump_is);
            this.run_img = ImageIO.read(run_is);
        } catch (IOException ex) {
            ex.printStackTrace();
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
	
	private void updateAnimationTick() {
		
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= 6)
				aniIndex = 0;
		}
		
	}

	
	public void paintComponent(Graphics g) {
	//paintComponent: this ONLY gets called whenever we press the play button
	//Graphics allows us to draw
		super.paintComponent(g);//this line is calling the super class which is JPanel,it calls the JPanels own paint component method
		
		updateAnimationTick();
		
		g.drawImage(animations[0][aniIndex], (int) xDelta, (int) yDelta, 462, 380, null); 
		

	}

	
	

	
}
