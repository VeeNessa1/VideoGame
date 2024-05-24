package utilz;

import static levels.LevelData.LEVEL_ONE_DATA;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import levels.LevelData.Tile;
import main.Game;

public class LoadSave
{
	public static BufferedImage GetSpriteAtlas(String fileName)
	{
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return img;
	}

	public static Tile[][] GetLevelData()
	{
		Tile[][] lvlData = new Tile[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];

		for (int i = 0; i < Game.TILES_IN_HEIGHT; i++)
			for (int j = 0; j < Game.TILES_IN_WIDTH; j++)
				lvlData[i][j] = LEVEL_ONE_DATA[i][j];

		return lvlData;
	}
}
