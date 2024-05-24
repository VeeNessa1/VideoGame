package entities;

import static utilz.HelpMethods.*;
import static utilz.Constants.PlayerConstants.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import levels.LevelManager;
import levels.LevelData.Tile;
import main.Game;

public class Player extends Entity
{
	// 2D Array
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 25;
	private int playerAction = IDLE;
	private boolean moving = false, attacking = false;
	private boolean left, up, right, down, jump;
	private float playerSpeed = 2.0f;
	private float xDrawOffset = 32 * Game.SCALE;
	private float yDrawOffset = 43 * Game.SCALE;

	// All of these will be for jumping/gravity
	private float airSpeed = 0f;
	private float gravity = 0.04f * Game.SCALE;
	// Gravity will dictate how fast our player will fall and jump and the lower
	// the number we set to gravity the higher the player will jump
	private float jumpSpeed = -3.10f * Game.SCALE;
	private float fallSpeedAfterCollision = 0.5f * Game.SCALE;
	private boolean inAir = false;

	private BufferedImage[] images = new BufferedImage[8];

	private LevelManager levelManager;

	public Player(float x, float y, int width, int height, LevelManager levelManager)
	{
		super(x, y, width, height);
		// ^ awesome!
		// this is how objected oriented programming works

		this.levelManager = levelManager;

		this.loadAnimations();
		this.initHitBox(x, y, 20 * Game.SCALE, 27 * Game.SCALE);
	}

	public void update()
	{
		this.updatePos();

		this.updateAnimationTick();
		this.setAnimation();
	}

	public void render(Graphics g)
	{
		// this way we can render the player

		g.drawImage(
			this.animations[this.playerAction][this.aniIndex],
			(int)(this.hitbox.x - this.xDrawOffset),
			(int)(this.hitbox.y - this.yDrawOffset),
			this.width, this.height,
			null
		);

		// drawHitbox(g);
	}

	private void updateAnimationTick()
	{
		this.aniTick++;

		if (this.aniTick >= this.aniSpeed)
		{
			this.aniTick = 0;
			this.aniIndex++;

			if (this.aniIndex >= GetSpriteAmount(this.playerAction))
			{
				this.aniIndex = 0;
				this.attacking = false;
			}
		}
	}

	private void setAnimation()
	{
		int startAni = this.playerAction;

		// if-else statement
		if (this.moving)
		{
			this.playerAction = RUNNING;
		} else {
			this.playerAction = IDLE;
		}

		if (this.inAir)
		{
			if (this.airSpeed < 0)
			{
				this.playerAction = JUMP;
			} else {
				this.playerAction = FALLING;
			}
		}

		if (this.attacking)
			this.playerAction = ATTACK_1;

		if (startAni != this.playerAction)
			this.resetAniTick();
	}

	private void resetAniTick()
	{
		this.aniTick = 0;
		this.aniIndex = 0;
	}

	private void updatePos()
	{
		this.moving = false;

		if (this.jump)
			this.jump();

		if (!this.left && !this.right && !this.inAir)
			return;

		float xSpeed = 0;

		if (this.left)
			xSpeed -= this.playerSpeed;

		if (this.right)
			xSpeed += this.playerSpeed;

		if (!this.inAir && !IsEntityOnFloor(this.hitbox, this.levelManager.getCurrentLevel().getLevelData()))
			this.inAir = true;

		if (this.inAir)
		{
			if (CanMoveHere(
				this.hitbox.x,
				this.hitbox.y + this.airSpeed,
				this.hitbox.width,
				this.hitbox.height,
				this.levelManager.getCurrentLevel().getLevelData()
			)) {
				this.hitbox.y += this.airSpeed;
				this.airSpeed += this.gravity;
			} else {
				this.hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(this.hitbox, this.airSpeed);

				if (airSpeed > 0)
				{
					this.resetInAir();
				} else {
					this.airSpeed = this.fallSpeedAfterCollision;
				}
			}
		} else {
			this.moving = true;
		}

		this.updateXPos(xSpeed);
	}

	private void jump()
	{
		if (this.inAir)
			return;

		this.inAir = true;
		this.airSpeed = this.jumpSpeed;
	}

	private void resetInAir()
	{
		this.inAir = false;
		this.airSpeed = 0;
	}

	private void updateXPos(float xSpeed)
	{
		if (CanMoveHere(
			this.hitbox.x + xSpeed,
			this.hitbox.y,
			this.hitbox.width,
			this.hitbox.height,
			this.levelManager.getCurrentLevel().getLevelData()
		)) {
			this.hitbox.x += xSpeed;
		} else {
			this.hitbox.x = GetEntityXPosNextToWall(this.hitbox, xSpeed);
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
			this.images[ATTACK_1] = ImageIO.read(attack1_is);
			this.images[ATTACK_2] = ImageIO.read(attack2_is);
			this.images[DEATH] = ImageIO.read(death_is);
			this.images[FALLING] = ImageIO.read(fall_is);
			this.images[HIT] = ImageIO.read(hit_is);
			this.images[IDLE] = ImageIO.read(idle_is);
			this.images[JUMP] = ImageIO.read(jump_is);
			this.images[RUNNING] = ImageIO.read(run_is);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		final int ANIM_WIDTH = 231;
		final int ANIM_HEIGHT = 190;

		this.animations = new BufferedImage[8][8];

		final int[] SPRITE_IDS = {
			ATTACK_1,
			ATTACK_2,
			DEATH,
			FALLING,
			HIT,
			IDLE,
			JUMP,
			RUNNING,
		};

		for (final int spriteId : SPRITE_IDS)
		{
			int spriteFrames = GetSpriteAmount(spriteId);

			for (int i = 0; i < spriteFrames; i++)
			{
				this.animations[spriteId][i] = this.images[spriteId].getSubimage(
					i * ANIM_WIDTH, 0,
					ANIM_WIDTH,
					ANIM_HEIGHT
				);
			}
		}
	}

	public void loadLvlDataint(Tile[][] lvlData)
	{
		if (!IsEntityOnFloor(this.hitbox, lvlData))
			inAir = true;
	}

	public void resetDirBooleans()
	{
		this.left = false;
		this.right = false;
		this.up = false;
		this.down = false;
	}

	public void setAttacking(boolean attacking)
	{
		this.attacking = attacking;
	}

	public boolean isLeft()
	{
		return this.left;
	}

	public void setLeft(boolean left)
	{
		this.left = left;
	}

	public boolean isUp()
	{
		return this.up;
	}

	public void setUp(boolean up)
	{
		this.up = up;
	}

	public boolean isRight()
	{
		return this.right;
	}

	public void setRight(boolean right)
	{
		this.right = right;
	}

	public boolean isDown()
	{
		return this.down;
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

