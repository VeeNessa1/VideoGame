package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

import static levels.LevelData.LEVEL_ONE_DATA;

public class LevelManager {
	
	private Game game;
	private BufferedImage[] levelSprite;
	private Level levelOne; 
	
	public LevelManager(Game game) {
		this.game = game;
		//levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ONE_DATA); 
		importOutsideSprites();
		levelOne = new Level(LoadSave.GetLevelData());
	}
	
	private void importOutsideSprites() {
		BufferedImage img = LoadSave.GetSpriteAtlas("spr_VillageTileSetNoBkg_strip.png");

		levelSprite = new BufferedImage[47];

		for (int i = 0; i < 47; i++)
		{
			int x = 12 + 64 * i, y = 12, w = 36, h = 36;;

			System.out.format("x: %d, y: %d, w: %d, h: %d\n", x, y, w, h);

			levelSprite[i] = img.getSubimage(x, y, w, h);
		}
	}

	public void draw(Graphics g) {
		
		for(int j = 0; j < Game.TILES_IN_HEIGHT; j++)
			for(int i = 0; i < Game.TILES_IN_WIDTH; i++) {
				int index = levelOne.getSpriteIndex(i, j);
				g.drawImage(levelSprite[index], Game.TILES_SIZE * i,Game.TILES_SIZE * j, Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
		
		
	}
	public void update() {
		
	}
}
