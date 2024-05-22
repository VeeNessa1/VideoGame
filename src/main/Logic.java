package main;

import java.awt.Graphics;

public class Logic
{
  private Game game;

  private int upsCounter = 0;
  private int updatesCounter = 0;

  private enum State {
    // Main menu phase, gives player time to ready theirself and maybe
    // we can show them a brief explanation of how to play the game
    Startup,
    // This is the phase in which we reset the level data as it will be
    // modified later on as part of the gameplay -- we will be introducing
    // obstacles for them to navigate before the countdown timer expires
    Reset,
    // The countdown phase in which the player is allotted a certain span
    // of time to position theirself in the correct side of the level so as to
    // answer the question presented to them properly
    Countdown,
    // In this phase, the position of the player is compared to the bounds of
    // the answer areas.  This is where they will receive points for being right,
    // or have lives deducted for being wrong.  This phase will persist for an
    // amount of time so that the player has a chance to process the information
    // being shown to them before resetting, see State.Reset
    Result;

    public static final int COUNTER_TIMER = 10;
    public static final int RESULT_TIMER = 5;
  };

  private State state = State.Startup;

  public Logic(Game game)
  {
    this.game = game;
  }

  public void startup()
  {
    System.out.println("Startup");
  }

  public void reset()
  {
    System.out.println("Reset");
  }

  public void drawStartup(Graphics g)
  {
		g.drawString("Press any key to begin ...", 400, 200);
  }
  
  public void drawCountdown(Graphics g)
  {
    int secondsLeft = State.COUNTER_TIMER - this.updatesCounter;
    
		g.drawString("Countdown: " + secondsLeft, 400, 200);
  }

  public void drawResults(Graphics g)
  {
		g.drawString("Results", 400, 200);
  }
  
  public void update()
  {
    this.upsCounter++;

    if (this.upsCounter == this.game.getUps())
    {
      this.upsCounter = 0;
      this.tick();
    }

    switch (this.state)
    {
      case Startup:
        this.startup();

        break;
      
      case Reset:
        this.reset();
        this.updateState(State.Countdown);

        break;
      
      default:
        // do nothing
    }
  }

  public void draw(Graphics g)
  {
    switch (this.state)
    {
      case Startup:
        this.drawStartup(g);
        break;
      
      case Countdown:
        this.drawCountdown(g);
        break;

      case Result:
        this.drawResults(g);
        break;

      default:
        // do nothing
    }
  }

  public void tick()
  {
    this.updatesCounter++;

    switch (this.state)
    {
      case Countdown:
        if (this.updatesCounter >= State.COUNTER_TIMER)
          this.updateState(State.Result);

        break;
      
      case Result:
        if (this.updatesCounter >= State.RESULT_TIMER)
          this.updateState(State.Reset);

        break;

      default:
        // do nothing
    }
  }

  private void updateState(State newState)
  {
    this.state = newState;
    this.updatesCounter = 0;
  }

  public void begin() {
    this.updateState(State.Reset);
  }
}
