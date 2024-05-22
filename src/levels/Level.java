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
		return lvlData[y][x];
	}

	public Tile[][] getLevelData()
	{
		return lvlData;
	}
}
