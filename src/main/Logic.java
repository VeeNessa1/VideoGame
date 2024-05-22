package main;

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
  };

  private State state = State.Startup;

  public Logic(Game game)
  {
    this.game = game;
  }
  
  public void update()
  {
    this.upsCounter++;

    if (this.upsCounter == this.game.getUps())
    {
      this.upsCounter = 0;
      
      tick();
    }
  }

  private void tick()
  {
    this.updatesCounter++;
    System.out.println("Hello, world: " + this.updatesCounter);
  }
}
