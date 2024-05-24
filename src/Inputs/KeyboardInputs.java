package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GamePanel;

public class KeyboardInputs implements KeyListener
{
	private GamePanel gamePanel;

	public KeyboardInputs(GamePanel gamePanel)
	{
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e)
	{
		Game game = this.gamePanel.getGame();

		switch (e.getKeyCode())
		{
			case KeyEvent.VK_W:
				// Once key is released, the player will stop moving
				game.getPlayer().setUp(false);
				break;

			case KeyEvent.VK_A:
				// Once key is released, the player will stop moving
				game.getPlayer().setLeft(false);
				break;

			case KeyEvent.VK_S:
				// Once key is released, the player will stop moving
				game.getPlayer().setDown(false);
				break;

			case KeyEvent.VK_D:
				// Once key is released, the player will stop moving
				game.getPlayer().setRight(false);
				break;

			case KeyEvent.VK_SPACE:
				game.getPlayer().setJump(false);
				break;

			case KeyEvent.VK_ENTER:
				game.begin();
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		Game game = this.gamePanel.getGame();

		switch (e.getKeyCode())
		{
			case KeyEvent.VK_W:
				// Once key is released, the player will stop moving
				game.getPlayer().setUp(true);
				break;

			case KeyEvent.VK_A:
				// Once key is released, the player will stop moving
				game.getPlayer().setLeft(true);
				break;

			case KeyEvent.VK_S:
				// Once key is released, the player will stop moving
				game.getPlayer().setDown(true);
				break;

			case KeyEvent.VK_D:
				// Once key is released, the player will stop moving
				game.getPlayer().setRight(true);
				break;

			case KeyEvent.VK_SPACE:
				game.getPlayer().setJump(true);
				break;
		}
	}
}

