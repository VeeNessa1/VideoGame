package entities;

import static utilz.HelpMethods.*;
import static utilz.Constants.PlayerConstants.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

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
	private Tile[][] lvlData;
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

	private BufferedImage[] images = new BufferedImage[8];

	public Player(float x, float y, int width, int height)
	{
		super(x, y, width, height);
		// ^ awesome!
		// this is how objected oriented programming works

		loadAnimations();
		initHitBox(x, y, 20 * Game.SCALE, 27 * Game.SCALE);
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
		{
			playerAction = RUNNING;
		} else {
			playerAction = IDLE;
		}

		if (inAir) {
			if (airSpeed < 0) {
				playerAction = JUMP;
			} else {
				playerAction = FALLING;
			}
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

		if (!inAir && !IsEntityOnFloor(hitbox, lvlData))
			inAir = true;

		if (inAir)
		{
			if (CanMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, lvlData))
			{
				hitbox.y += airSpeed;
				airSpeed += gravity;
			} else {
				hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(hitbox, airSpeed);

				if (airSpeed > 0)
				{
					resetInAir();
				} else {
					airSpeed = fallSpeedAfterCollision;
				}
			}
		} else {
			moving = true;
		}

		updateXPos(xSpeed);
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
		if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData))
		{
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
				this.animations[spriteId][i] = this.images[spriteId].getSubimage(i * ANIM_WIDTH, 0, ANIM_WIDTH, ANIM_HEIGHT);
			}
		}
	}

	public void loadLvlDataint(Tile[][] lvlData)
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

