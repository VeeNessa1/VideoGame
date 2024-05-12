package levels;

import static main.Game.TILES_IN_HEIGHT;
import static main.Game.TILES_IN_WIDTH;

public class LevelData
{
  // TODO do stuff

  public enum Tiles
  {
    GrassyNorthWest(0),
    GrassyNorth(1),
    GrassyNorthEast(2),
    GrassyWest(3),
    GrassyNone(4),
    GrassyEast(5),
    GrassySouthWest(6),
    GrassySouth(7),
    GrassySouthEast(8),
    GrassyNone2(9),
    GrassyNone3(10),
    GrassyNone4(11),
    GrassyNone5(12),
    GrassyNone6(13),
    GrassyNone7(14);

    private int id = 0;

    Tiles(int id)
    {
      this.id = id;
    }

    public int getId()
    {
      return this.id;
    }
  };

  public static final Tiles[][] LEVEL_ONE_DATA = {
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
    { Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone, Tiles.GrassyNone },
  };
}
