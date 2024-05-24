package levels;

import levels.LevelData.Tile;

public class Level
{
	private Tile[][] lvlData;

	public Level(Tile[][] lvlData)
	{
		this.lvlData = lvlData;
	}

	public Tile getSpriteIndex(int x, int y)
	{
		return this.lvlData[y][x];
	}

	public Tile[][] getLevelData()
	{
		return this.lvlData;
	}
}
