package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import levels.LevelData.Tile;
import levels.LevelManager;

public class Logic
{
  private Game game;

  private int upsCounter = 0;
  private int updatesCounter = 0;

  private enum State {
    // Main menu phase, gives player time to ready theirself and maybe
    // we can show them a brief explanation of how to play the game
    Startup,
    // This is the phase in which we will clear/reset the level and display the
    // question they are to answer, as well as the colors associated with the
    // answers to said question
    ShowQuestion,

    // The countdown phase in which the player is allotted a certain span
    // of time to position theirself in the correct side of the level so as to
    // answer the question presented to them properly
    Countdown,
    // In this phase, the position of the player is compared to the bounds of
    // the answer areas.  This is where they will receive points for being right,
    // or have lives deducted for being wrong.  This phase will persist for an
    // amount of time so that the player has a chance to process the information
    // being shown to them before resetting
    Result,
		// This is the end screen in case the player wins
		Win,
		// This is the end screen in case the player loses
		Loss;

    public static final int QUESTION_TIMER = 1;
    public static final int COUNTER_TIMER = 10;
    public static final int RESULT_TIMER = 5;
  };

  private static final Tile BLOCK_TILES[][] = {
    { Tile.GrassyNorthWest, Tile.GrassyNorthEast },
    { Tile.GrassySouthWest, Tile.GrassySouthEast },
  };

  private int nextQuestionIndex = 0;
  private int redAnswerIndex = 0;
  private int greenAnswerIndex = 0;

	private int lives = 3;
	private int points = 0;

  private State state = State.Startup;

  public Logic(Game game)
  {
    this.game = game;
  }

  // This is the method in which introduce obstacles for the player
  // to navigate before the countdown timer expires
  private void setup()
  {
    // Place random, non-obstructing/overlapping blocks
    LevelManager levelManager = this.game.getLevelManager();

    // By reference -- we are modifying the actual level data here
    Tile[][] levelData = levelManager.getCurrentLevel().getLevelData();

    int height = levelData.length;
    int width = levelData[0].length;

    int ySpace = height - 4;
    int xSpace = width - 4;

    for (int i = 0; i < 5; i++)
    {
      int xIndex = 0;
      int yIndex = 0;

      int playerX = (int)(this.game.getPlayer().getHitbox().getX() / Game.TILES_SIZE);
      int playerY = (int)(this.game.getPlayer().getHitbox().getY() / Game.TILES_SIZE);

      // Find a suitable place to place our obstacles
      // TODO make sure these blocks don't overlap themselves
      outer: do {
        yIndex = (int)(Math.random() * ySpace) + 2;
        xIndex = (int)(Math.random() * xSpace) + 2;

        for (int xOffset = -1; xOffset < 3; xOffset++)
        {
          for (int yOffset = -1; yOffset < 3; yOffset++)
          {
            if (levelData[yIndex + yOffset][xIndex + xOffset].isSolid())
              continue outer;

            if (yIndex + yOffset == playerY)
              continue outer;

            if (xIndex + xOffset == playerX)
              continue outer;
          }
        }

        break;
      } while (true);

      for (int xOffset = 0; xOffset < 2; xOffset++)
        for (int yOffset = 0; yOffset < 2; yOffset++)
          levelData[yIndex + yOffset][xIndex + xOffset] = BLOCK_TILES[yOffset][xOffset];
    };

    int greenZoneWidth = (int)(Math.random() * 4) + 4;
    int redZoneWidth = (int)(Math.random() * 4) + 4;

    int redZoneColumn = (int)(Math.random() * (width - redZoneWidth));

    int greenZoneColumn = 0;
    do {
      greenZoneColumn = (int)(Math.random() * (width - greenZoneWidth));
    } while (
      (greenZoneColumn > redZoneColumn && greenZoneColumn + greenZoneWidth < redZoneColumn + redZoneWidth) ||
      (greenZoneColumn < redZoneColumn && greenZoneColumn + greenZoneWidth > redZoneColumn + redZoneWidth)
    );

		boolean existsGreenZone = false;
		boolean existsRedZone = false;

    for (int yIndex = 0; yIndex < height; yIndex++)
    {
      for (int xOffset = 0; xOffset < greenZoneWidth; xOffset++)
			{
        if (!levelData[yIndex][greenZoneColumn + xOffset].isSolid())
				{
          levelData[yIndex][greenZoneColumn + xOffset] = Tile.GreenBackground;
					existsGreenZone = true;
				}
			}

      for (int xOffset = 0; xOffset < redZoneWidth; xOffset++)
			{
        if (!levelData[yIndex][redZoneColumn + xOffset].isSolid())
				{
					levelData[yIndex][redZoneColumn + xOffset] = Tile.RedBackground;
					existsRedZone = true;
				}
			}
    }

		if (!existsGreenZone || !existsRedZone)
		{
			// If somehow no red or green zone actually got drawn, try again
			levelManager.resetLevel();
			this.setup();
		}
  }

  public void drawStartup(Graphics g)
  {
		g.drawString("Press enter to begin ...", 400, 200);
  }

  public void drawQuestion(Graphics g)
  {
    g.setFont(new Font("Arial", Font.PLAIN, 36));

    String question = Questions.QUESTIONS[this.nextQuestionIndex];
    String[] answers = Questions.ANSWERS[this.nextQuestionIndex];

    String redAnswer = answers[this.redAnswerIndex];
    String greenAnswer = answers[this.greenAnswerIndex];

    int secondsLeft = State.QUESTION_TIMER - this.updatesCounter;

    String textToShow =
      question + "\n\n" +
      "Red: " + redAnswer + "\n" +
      "Green: " + greenAnswer + "\n\n" +
      "Starting in " + secondsLeft + " ...";

    String[] lines = textToShow.split("\n");

    for (int lineNumber = 0; lineNumber < lines.length; lineNumber++)
    {
      g.drawString(lines[lineNumber], 100, 100 + 36 * lineNumber);
    }
  }

  public void drawCountdown(Graphics g)
  {
    int secondsLeft = State.COUNTER_TIMER - this.updatesCounter;

    String countdownText = secondsLeft + " second";

    // make sure the plural matches the number
    if (secondsLeft != 1)
      countdownText += "s";

    countdownText += " left";

    g.setColor(Color.LIGHT_GRAY);
    g.setFont(new Font("Arial", Font.PLAIN, Game.TILES_SIZE));
		g.drawString(countdownText, (int)(1 * Game.TILES_SIZE), (int)(13.33 * Game.TILES_SIZE));
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
  }

  public void draw(Graphics g)
  {
    switch (this.state)
    {
      case Startup:
        this.drawStartup(g);
        break;

      case ShowQuestion:
        this.drawQuestion(g);
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
      case ShowQuestion:
        if (this.updatesCounter >= State.QUESTION_TIMER)
        {
          this.setup();
          this.updateState(State.Countdown);
        };

        break;

      case Countdown:
        if (this.updatesCounter >= State.COUNTER_TIMER)
          this.updateState(State.Result);

        break;

      case Result:
        if (this.updatesCounter >= State.RESULT_TIMER)
				{
					// Check if player lost (out of lives)
					if (this.lives == 0)
					{
						this.updateState(State.Loss);

						return;
					}

					// Check if player won (answered all questions)
					if (this.points == Questions.QUESTIONS.length)
					{
						this.updateState(State.Win);

						return;
					}

					// Otherwise, go on to the next round
          this.updateState(State.ShowQuestion);
				};

        break;

      default:
        // do nothing
    }
  }

  private void chooseNextQuestion()
  {
    this.nextQuestionIndex = (int)(Math.random() * Questions.QUESTIONS.length);

    // Choose random answers from our pools -- we need to make sure the correct
    // answer is one of the options
    int goodAnswerIndex = Questions.ANSWER_INDICES[this.nextQuestionIndex];
    int badAnswerIndex = 0;

    do {
      badAnswerIndex = (int)(Math.random() * Questions.ANSWERS[this.nextQuestionIndex].length);
    } while (badAnswerIndex == goodAnswerIndex);

    // Randomly decide if red or green represent the good or bad answer respectively
    if (Math.random() > 0.5)
    {
      this.greenAnswerIndex = goodAnswerIndex;
      this.redAnswerIndex = badAnswerIndex;
    } else {
      this.greenAnswerIndex = badAnswerIndex;
      this.redAnswerIndex = goodAnswerIndex;
    }
  }

  private void finalizeResults()
  {
    // Setup the level so we can add new obstacles & answer fields
    LevelManager levelManager = this.game.getLevelManager();

		int playerYIndex = (int)(this.game.getPlayer().getHitbox().y / Game.TILES_SIZE);
		int playerXIndex = (int)(this.game.getPlayer().getHitbox().x / Game.TILES_SIZE);

		Tile[][] levelData = levelManager.getCurrentLevel().getLevelData();
		Tile tilePlayerIsStandingOn = levelData[playerYIndex][playerXIndex];

		// Check if player is standing on the correct tile
		boolean greenIsCorrect = this.greenAnswerIndex == Questions.ANSWER_INDICES[this.nextQuestionIndex];

		if (
			(greenIsCorrect && tilePlayerIsStandingOn == Tile.GreenBackground) ||
			(!greenIsCorrect && tilePlayerIsStandingOn == Tile.RedBackground)
		) {
			System.out.println("Correct!");
			this.points++;
		} else {
			System.out.println("Wrong!");
			this.lives--;
		}

		System.out.println("points: " + this.points);
		System.out.println("lives: " + this.lives);

		// Reset level for next round
    levelManager.resetLevel();
  }

  private void updateState(State newState)
  {
    System.out.println("newState: " + newState.toString());

    this.state = newState;
    this.updatesCounter = 0;

    switch (newState)
    {
      case ShowQuestion:
        this.chooseNextQuestion();

        break;

      case Result:
        this.finalizeResults();

        break;

      default:
        // do nothing
    }
  }

  public void begin() {
		switch (this.state)
		{
			case Startup:
			case Win:
			case Loss:
	      this.updateState(State.ShowQuestion);

			default:
				// do nothing
		};
  }
}
