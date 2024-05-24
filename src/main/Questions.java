package main;

public class Questions
{
  public static final String[] QUESTIONS = {
    "Who is the main protagonist in \"The Lord of the Rings\"?",
    "How many \"Star Wars\" movies have there been\nin total?",
    "Which actor played the character Iron Man in the\nMarvel Cinematic Universe?",
    "Who played the role of Hermione Granger in the\nHarry Potter film series?",
    "Which film features the line\n\"May the Force Be With You\"?",
    "Who is the main antagonist in \"The Lion King\"?",
  };

  public static final String[][] ANSWERS = {
    {
      "Frodo Baggins",
      "Harry Potter",
      "Tony Stark",
    },
    {
      "6",
      "10",
      "11",
    },
    {
      "Robert Downey Jr.",
      "Chris Hemsworth",
      "Chris Evans",
    },
    {
      "Emma Roberts",
      "Emma Stone",
      "Emma Watson",
    },
    {
      "Star Wars: Episode IV - A New Hope",
      "Star Wars: Episode V - The Empire Strikes Back",
      "Star Wars: Episode VI - Return of the Jedi",
    },
    {
      "Scar",
      "Simba",
      "Rafiki",
    },
  };

  public static final int[] ANSWER_INDICES = {
    0,
    2,
    0,
    2,
    0,
    0,
  };

  public static final String[] WIN_MESSAGES = {
    "Winner!",
    "Congratulations! You've won!",
    "Victory is yours!",
    "Fantastic! You did it!",
    "You've conquered the game!",
  };

  public static final String[] LOSS_MESSAGES = {
    "Aww, try again!",
    "Better luck next time!",
    "Don't give up! Try again!",
    "You were so close!",
    "Oops! Give it another shot!",
    "Don't worry, you'll get it next time!",
  };
}
