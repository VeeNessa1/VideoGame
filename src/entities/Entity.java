package entities;

public abstract class Entity
{
	// abstract class is a class that you cannot create an object of, store values that both the player and enemie will use
	protected float x,y;

	public Entity(float x, float y)
	{
		this.x = x;
		this.y = y;
		// private means that only this class can use x and y
		// But if it is protected then only classes that extend entity can use x AND y
	}
}
