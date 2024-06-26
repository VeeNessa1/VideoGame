package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public abstract class Entity
{
	// Abstract class is a class that you cannot create an object of, store values that both the player and enemie will use
	protected float x, y;
	protected int width, height;
	protected Rectangle2D.Float hitbox;

	public Entity(float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// initHitBox();
	}

	// Private means that only this class can use x and y,
	// but if it is protected then only classes that extend entity can use x AND y
	protected void drawHitbox(Graphics g)
	{
		// For debugging the hitbox
		g.setColor(Color.PINK);
		g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}

	protected void initHitBox(float x, float y, float width, float height)
	{
		this.hitbox = new Rectangle2D.Float(x, y, width, height);
	}

	// protected void updateHitbox()
	// {
	// 	 hitbox.x = (int) x;
	// 	 hitbox.y = (int) y;
	// }

	public Rectangle2D.Float getHitbox()
	{
		return this.hitbox;
	}
}
