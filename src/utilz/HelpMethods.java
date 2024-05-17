package utilz;

import java.awt.geom.Rectangle2D;

import levels.LevelData;
import levels.LevelData.Tiles;
import main.Game;

public class HelpMethods
{
	private static final float LEVEL_ONE_DATA = 0;

	public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
		if(!IsSolid(x,y,lvlData))
			if(!IsSolid(x+width,y+height, lvlData))
				if(!IsSolid(x+width,y, lvlData))
					if(!IsSolid(x,y+height, lvlData))
						return true;

		return false;
	}

	// If we g diagonal it will be one of those two that goes inside the tile.
	// In this method we test if all four sides of our hitbox are true or false
	// If all four sides are true, the player will be able to move
	// if at least one of the sides are false, then the player will not be able to move there
	private static boolean IsSolid(float x, float y, int[][] lvlData) {
		if(x<0|| x >= Game.GAME_WIDTH)
			return true;

		if(y < 0 || y >= Game.GAME_HEIGHT)
			return true;

		float xIndex = x / Game.TILES_SIZE;
		float yIndex = y / Game.TILES_SIZE;

		int value = lvlData[(int) yIndex][(int) xIndex];

		if(value == Tiles.Air.getId())
			return false;

		return true;
	}

	public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed)
	{
		int currentTile = (int)(hitbox.x / Game.TILES_SIZE);

		if (xSpeed > 0) {
			// Right
			int tileXPos = currentTile * Game.TILES_SIZE;
			int xOffset = (int)(Game.TILES_SIZE - hitbox.width);

			return tileXPos + xOffset - 1;
		} else {
			// Left
			return currentTile * Game.TILES_SIZE;
		}
	}

	public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed)
	{
		int currentTile = (int) (hitbox.y / Game.TILES_SIZE);

		if (airSpeed > 0) {
			// Falling - touching floor
			int tileYPos = currentTile * Game.TILES_SIZE;
			int yOffset = (int) (Game.TILES_SIZE - hitbox.height);
			return tileYPos + yOffset - 1;
		} else
			// Jumping
			return currentTile * Game.TILES_SIZE;
	}


	public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData)
	{
		// Check the pixel below bottom left and bottom right
		if (!IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData))
			if (!IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData))
				return false;

		return true;
	}
}
