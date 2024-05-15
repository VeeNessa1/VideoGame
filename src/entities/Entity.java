package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity
{
	// abstract class is a class that you cannot create an object of, store values that both the player and enemie will use
	protected float x,y;
	protected int width, height;
	protected Rectangle hitbox;
	
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		initHitBox(); 
	}
	
		
		// private means that only this class can use x and y
		// But if it is protected then only classes that extend entity can use x AND y
	protected void drawHitbox(Graphics g) {
		//For debugging the hitbox
		g.setColor(Color.PINK);
		g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
	}
	
	 private void initHitBox() {
		 hitbox = new Rectangle((int) x,(int) y,width, height); 
	 }
	 protected void updateHitbox() {
		 hitbox.x = (int) x;
		 hitbox.y = (int) y;
	 }
	 public Rectangle getHitbox() {
		 return hitbox; 
	 }
}
