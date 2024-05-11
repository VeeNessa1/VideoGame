package main;

import java.awt.Graphics;

import entities.Player;

public class Game implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120; //This is a global variable
	private final int UPS_SET = 200;
	
	private Player player; 
	
	
	public Game() {
		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();//requests that this component gets focus
		
		
		startGameLoop();
	
	}
	
	private void initClasses() {
		player = new Player(200, 200);
		
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update() {
		player.update();
	}
	
	public void render(Graphics g) {
		player.render(g);
		
	}
	
	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET;//when dealing with a game loop we are dealing with times that are so small that ms will not satisfy 
		double timePerUpdate = 1000000000.0 / UPS_SET; //time of the frequency

		long previousTime = System.nanoTime();
		
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double deltaU = 0;
		double deltaF = 0;
				
		while(true) {
			long currentTime = System.nanoTime();
			
			
			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;
			
			if(deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}
			if(deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
				
			}
			
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + "| UPS: " + updates);
				frames = 0;
				updates = 0;
				//The characters will be changing speeds so we need to use a variety of game loop in which we can change the frames and updates 
			}
			
		}
		
	}
	
	public void windowFocusLost() {
		
		player.resetDirBooleans(); 
		
	}
	
	public Player getPlayer() {//creating a Getter
		return player;
	}
	
}

