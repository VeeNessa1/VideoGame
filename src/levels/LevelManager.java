package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class LevelManager
{
	@SuppressWarnings("unused")
	private Game game;
	private BufferedImage[] levelSprite;
	private Level level;

	public LevelManager(Game game)
	{
		this.game = game;
		// levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ONE_DATA);
		this.importOutsideSprites();
		this.resetLevel();
	}

	public void resetLevel()
	{
		this.level = new Level(LoadSave.GetLevelData());
	}

	private void importOutsideSprites()
	{
		BufferedImage img = LoadSave.GetSpriteAtlas("spr_VillageTileSetNoBkg_strip.png");
		levelSprite = new BufferedImage[LevelData.Tile.TILE_COUNT];

		for (int i = 0; i < LevelData.Tile.TILE_COUNT; i++)
		{
			int x = 16 + 64 * i, y = 16, w = 32, h = 32;

			this.levelSprite[i] = img.getSubimage(x, y, w, h);
		}
	}

	public void draw(Graphics g)
	{
		for (int j = 0; j < Game.TILES_IN_HEIGHT; j++)
		{
			for (int i = 0; i < Game.TILES_IN_WIDTH; i++)
			{
				int id = this.level.getSpriteIndex(i, j).getId();

				g.drawImage(
					this.levelSprite[id],
					Game.TILES_SIZE * i,
					Game.TILES_SIZE * j,
					Game.TILES_SIZE,
					Game.TILES_SIZE,
					null
				);
			}
		}
	}

	public void update() {}

	public Level getCurrentLevel()
	{
		return this.level;
	}
}

