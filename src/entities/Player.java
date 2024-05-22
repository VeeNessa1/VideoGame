package entities;

import static utilz.Constants.PlayerConstants.GetSpriteAmount;
import static utilz.HelpMethods.*;
import static utilz.Constants.PlayerConstants.IDLE;
import static utilz.Constants.PlayerConstants.ATTACK_1;
import static utilz.Constants.PlayerConstants.RUNNING;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import levels.LevelData.Tile;
import main.Game;
import utilz.Constants;

public class Player extends Entity
{
	private static final int JUMP = 0;
	private static final int FALLING = 0;
	// 2D Array
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed =25;
	private int playerAction = IDLE;
	private boolean moving = false, attacking = false;
	private boolean left, up, right, down, jump;
	private float playerSpeed = 2.0f;
	private int[][] lvlData;
	private float xDrawOffset = 32 * Game.SCALE;
	private float yDrawOffset = 43 * Game.SCALE;

	// All of these will be for jumping/gravity
	private float airSpeed = 0f;
	private float gravity = 0.04f * Game.SCALE;
	// Gravity will dictate how fast our player will fall and jump and the lower
	// the number we set to gravity the higher the player will jump
	private float jumpSpeed = -2.25f * Game.SCALE;
	private float fallSpeedAfterCollision = 0.5f * Game.SCALE;
	private boolean inAir = false;

	private BufferedImage attack1_img;
	private BufferedImage attack2_img;
	private BufferedImage death_img;
	private BufferedImage fall_img;
	private BufferedImage hit_img;
	private BufferedImage idle_img;
	private BufferedImage jump_img;
	private BufferedImage run_img;

	public Player(float x, float y, int width, int height)
	{
		super(x, y, width,height);
		// ^ awesome!
		// this is how objected oriented programming works

		loadAnimations();
		initHitBox(x,y,20*Game.SCALE,27*Game.SCALE);
	}

	public void update()
	{
		updatePos();

		updateAnimationTick();
		setAnimation();
	}

	public void render(Graphics g)
	{
		// this way we can render the player

		g.drawImage(
			animations[playerAction][aniIndex],
			(int)(hitbox.x - xDrawOffset),
			(int)(hitbox.y - yDrawOffset),
			width, height,
			null
		);
		// drawHitbox(g);
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

		if (inAir) {
			if (airSpeed < 0)
				playerAction = JUMP;
			else
				playerAction = FALLING;
		}

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

		if (jump)
			jump();

		if (!left && !right && !inAir)
			return;

		float xSpeed = 0;

		if (left)
			xSpeed -= playerSpeed;

		if (right)
			xSpeed += playerSpeed;

		if (!inAir)
			if (!IsEntityOnFloor(hitbox, lvlData))
				inAir = true;

		if (inAir) {
			if (CanMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, lvlData)) {
				hitbox.y += airSpeed;
				airSpeed += gravity;
				updateXPos(xSpeed);
			} else {
				hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(hitbox, airSpeed);
				if (airSpeed > 0)
					resetInAir();
				else
					airSpeed = fallSpeedAfterCollision;
				updateXPos(xSpeed);
			}
		} else {
			updateXPos(xSpeed);
			moving = true;
		}
	}

	private void jump()
	{
		if (inAir)
			return;

		inAir = true;
		airSpeed = jumpSpeed;
	}

	private void resetInAir()
	{
		inAir = false;
		airSpeed = 0;
	}

	private void updateXPos(float xSpeed)
	{
		if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData)) {
			hitbox.x += xSpeed;
		} else {
			hitbox.x = GetEntityXPosNextToWall(hitbox, xSpeed);
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

	public void loadLvlDataint(int[][] lvlData)
	{
		this.lvlData = lvlData;

		if (!IsEntityOnFloor(hitbox, lvlData))
			inAir = true;
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


	public void setJump(boolean jump)
	{
	this.jump = jump;
	}
}

