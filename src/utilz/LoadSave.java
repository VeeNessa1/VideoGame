package utilz;

import static levels.LevelData.LEVEL_ONE_DATA;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

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

	public static int[][] GetLevelData()
	{
		int[][] lvlData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];

		System.out.println("i: " + lvlData.length + " j: " + lvlData[0].length);
		for (int i = 0; i < Game.TILES_IN_HEIGHT; i++)
		{
			for (int j = 0; j < Game.TILES_IN_WIDTH; j++)
			{
				System.out.println("i, j: " + i + " " + j);

				lvlData[i][j] = LEVEL_ONE_DATA[i][j].getId();
			}
		}

		return lvlData;
	}
}
