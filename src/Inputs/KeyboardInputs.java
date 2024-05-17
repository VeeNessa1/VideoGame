package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_W:
				// Once key is released, the player will stop moving
				gamePanel.getGame().getPlayer().setUp(false);
				break;

			case KeyEvent.VK_A:
				// Once key is released, the player will stop moving
				gamePanel.getGame().getPlayer().setLeft(false);
				break;

			case KeyEvent.VK_S:
				// Once key is released, the player will stop moving
				gamePanel.getGame().getPlayer().setDown(false);
				break;

			case KeyEvent.VK_D:
				// Once key is released, the player will stop moving
				gamePanel.getGame().getPlayer().setRight(false);
				break;
			case KeyEvent.VK_SPACE:
				gamePanel.getGame().getPlayer().setJump(false);
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_W:
				// Once key is released, the player will stop moving
				gamePanel.getGame().getPlayer().setUp(true);
				break;

			case KeyEvent.VK_A:
				// Once key is released, the player will stop moving
				gamePanel.getGame().getPlayer().setLeft(true);
				break;

			case KeyEvent.VK_S:
				// Once key is released, the player will stop moving
				gamePanel.getGame().getPlayer().setDown(true);
				break;

			case KeyEvent.VK_D:
				// Once key is released, the player will stop moving
				gamePanel.getGame().getPlayer().setRight(true);
				break;
				
			case KeyEvent.VK_SPACE:
				gamePanel.getGame().getPlayer().setJump(true);
				break;
		}
	}
}

