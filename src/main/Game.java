package main;

import java.awt.Graphics;

import entities.Player;
import levels.LevelManager;

public class Game implements Runnable
{
	@SuppressWarnings("unused")
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;

	private final int FPS_SET = 120; //This is a global variable
	private final int UPS_SET = 200;

	private Player player;
	private LevelManager levelManager;

	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.25f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	public static final float LEVEL_ONE_DATA = 0;

	private Logic logic;

	public Game()
	{
		initClasses();

		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		// requests that this component gets focus
		gamePanel.requestFocus();
	}

	private void initClasses()
	{
		levelManager = new LevelManager(this);
		player = new Player(200, 200, FPS_SET, FPS_SET);
		player.loadLvlDataint(LevelManager.getCurrentLevel().getLevelData());
		logic = new Logic(this);
	}

	public void startGameLoop()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void update()
	{
		player.update();
		levelManager.update();
		logic.update();
	}

	public void render(Graphics g)
	{
		levelManager.draw(g);
		player.render(g);
		logic.draw(g);
	}

	@Override
	public void run()
	{
		// When dealing with a game loop we are dealing with times that are so small that ms will not satisfy
		double timePerFrame = 1000000000.0 / FPS_SET;
		// Time of the frequency
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true)
		{
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1)
			{
				update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1)
			{
				gamePanel.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000)
			{
				lastCheck = System.currentTimeMillis();

				System.out.println("FPS: " + frames + "| UPS: " + updates);

				frames = 0;
				updates = 0;
				// The characters will be changing speeds so we need to use a variety of game loop in which we can change the frames and updates
			}
		}
	}

	public void windowFocusLost()
	{
		player.resetDirBooleans();
	}

	public Player getPlayer()
	{
		// Creating a Getter
		return player;
	}

	public int getUps()
	{
		return this.UPS_SET;
	}

	public void begin()
	{
		this.logic.begin();
	}
}
