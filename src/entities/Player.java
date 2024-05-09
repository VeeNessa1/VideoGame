package entities;

import static utilz.Constants.Directions.DOWN;
import static utilz.Constants.Directions.LEFT;
import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.Directions.UP;
import static utilz.Constants.PlayerConstants.GetSpriteAmount;
import static utilz.Constants.PlayerConstants.IDLE;
import static utilz.Constants.PlayerConstants.RUNNING;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import utilz.Constants;

public class Player extends Entity {
	
	private BufferedImage[][] animations; //2D Array
	private int aniTick, aniIndex, aniSpeed = 25;
	private int playerAction = IDLE;
	private int playerDir = -1;
	private boolean moving = false;
	
	private BufferedImage attack1_img;
    private BufferedImage attack2_img;
    private BufferedImage death_img;
    private BufferedImage fall_img;
    private BufferedImage hit_img;
    private BufferedImage idle_img;
    private BufferedImage jump_img;
    private BufferedImage run_img;
	
	public Player(float x, float y) {
		super(x, y);
		//this is how objected oriented programming works
		loadAnimations(); 
	}
	
	public void update() {
		
		updateAnimationTick();
		setAnimation();
		updatePos();

		
	}
	
	public void render(Graphics g) {
		//this way we can render the player 
		
		g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 462, 380, null);
		
	}
	
	public void setDirection(int direction) {
		this.playerDir = direction;
		moving = true; 
		
	}
	
	public void setMoving(boolean moving) { 
		this.moving = moving;
		//setter 
		
	}
	//method that says moving equals false
	
	private void updateAnimationTick() {
		
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playerAction))
				aniIndex = 0;
		}
		
	}
	
	private void setAnimation( ) {
		
		if(moving)
			playerAction = RUNNING;
		else
			playerAction = IDLE;
		//if-else statement 
	}
	private void updatePos() {

		
		if(moving) {
			switch(playerDir) {
			case LEFT:
				x -= 5;
				break;
			case UP:
				y -= 5;
				break;
			case RIGHT:
				x += 5;
				break;
			case DOWN:
				y +=5;
				break;
			
			}
		}
		
	}
	
	private void loadAnimations() {
		
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
	
	
	
}
	
	