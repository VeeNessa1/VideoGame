package entities;

import static utilz.Constants.PlayerConstants.GetSpriteAmount;
import static utilz.HelpMethods.CanMoveHere;
import static utilz.Constants.PlayerConstants.IDLE;
import static utilz.Constants.PlayerConstants.ATTACK_1;
import static utilz.Constants.PlayerConstants.RUNNING;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import utilz.Constants;

public class Player extends Entity
{
	// 2D Array
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 25;
	private int playerAction = IDLE;
	private boolean moving = false, attacking = false;
	private boolean left, up, right, down; 
	private float playerSpeed = 2.0f;
	private int[][] lvlData; 

	private BufferedImage attack1_img;
	private BufferedImage attack2_img;
	private BufferedImage death_img;
	private BufferedImage fall_img;
	private BufferedImage hit_img;
	private BufferedImage idle_img; 
	private BufferedImage jump_img;
	private BufferedImage run_img;

	public Player(float x, float y, int width, int height) {
	super(x, y, width,height);

		// this is how objected oriented programming works
		// ^ awesome!
		loadAnimations();
	}

	public void update()
	{
		updatePos();
		updateHitbox();
		updateAnimationTick();
		setAnimation();
	}

	public void render(Graphics g)
	{
		// this way we can render the player

		g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, width, height, null); 
		drawHitbox(g);
	}

	private void updateAnimationTick()
	{
		aniTick++;

		if (aniTick >= aniSpeed)
		{
			aniTick = 0;
			aniIndex++;

			if (aniIndex >= GetSpriteAmount(playerAction))
			{
				aniIndex = 0;
				attacking = false; 
			}
		}
	}

	private void setAnimation()
	{
		int startAni = playerAction;

		// if-else statement
		if (moving)
			playerAction = RUNNING;
		else
			playerAction = IDLE;

		if (attacking)
			playerAction = ATTACK_1;

		if (startAni != playerAction)
			resetAniTick();
	}

	private void resetAniTick()
	{
		aniTick = 0;
		aniIndex = 0;
	}

	private void updatePos()
	{
		moving = false;
		if(!left && !right && !up && !down)
			return;
		
		float xSpeed = 0, ySpeed = 0;
		

		if (left && !right)
	
			xSpeed = -playerSpeed;
			
		else if (right && !left) 
			xSpeed = playerSpeed;
			
		

		if (up && !down)
		
			ySpeed = -playerSpeed;
			
		 else if (down && !up) 
			ySpeed = playerSpeed;
			
		if(CanMoveHere(x+xSpeed, y+ySpeed, width, height, lvlData)) {
			this.x += xSpeed;
			this.y += ySpeed;
			moving = true;
		}
			
		}
	

	private void loadAnimations()
	{
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
	public void loadLvlDataint(int[][] lvlData) {
		this.lvlData = lvlData; 
		
	}

	public void resetDirBooleans()
	{
		left = false;
		right = false;
		up = false;
		down = false;
	}

	public void setAttacking(boolean attacking )
	{
		this.attacking = attacking;
	}

	public boolean isLeft()
	{
		return left;
	}

	public void setLeft(boolean left)
	{
		this.left = left;
	}

	public boolean isUp()
	{
		return up;
	}

	public void setUp(boolean up)
	{
		this.up = up;
	}

	public boolean isRight()
	{
		return right;
	}

	public void setRight(boolean right)
	{
		this.right = right;
	}

	public boolean isDown()
	{
		return down;
	}

	public void setDown(boolean down)
	{
		this.down = down;
	}
}
