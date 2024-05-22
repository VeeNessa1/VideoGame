package levels;

public class LevelData
{
  public enum Tile
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
    GrassyNone7(14),
    StoneCornerNorthEast(38),
    StoneCornerSouthEast(39),
    StoneCornerSouthWest(40),
    StoneCornerNorthWest(41),
    Air(47, false),
    RedBackground(48, false),
    GreenBackground(49, false);

    public static final int TILE_COUNT = 50;
    
    private int id = 0;
    private boolean isSolid = true;
    
    Tile(int id)
    {
      this.id = id;
    }

    Tile(int id, boolean isSolid)
    {
      this(id);
      this.isSolid = isSolid;
    };

    public int getId()
    {
      return this.id;
    }

    public boolean isSolid()
    {
      return this.isSolid;
    };
    
  };

  public static final Tile[][] LEVEL_ONE_DATA = {
    { Tile.GrassyNorthWest, Tile.GrassyNorth, Tile.GrassyNorth, Tile.GrassyNorth     , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth     , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth     , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth     , Tile.GrassyNorth , Tile.GrassyNorth, Tile.GrassyNorthEast },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.GrassyNorthWest , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorthEast , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.Air        , Tile.Air        , Tile.GrassyWest      , Tile.GrassyNone  , Tile.GrassyNone  , Tile.GrassyNone  , Tile.GrassyEast      , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air         , Tile.Air         , Tile.Air             , Tile.Air         , Tile.Air        , Tile.GrassyEast      },
    { Tile.GrassyWest     , Tile.GrassyNorth, Tile.GrassyNorth, Tile.GrassyNone3     , Tile.GrassyNone  , Tile.GrassyNone  , Tile.GrassyNone  , Tile.GrassyNone4     , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorth , Tile.GrassyNorthEast , Tile.Air         , Tile.Air         , Tile.Air         , Tile.GrassyNorthWest , Tile.GrassyNorth , Tile.GrassyNorth, Tile.GrassyEast      },
    { Tile.GrassySouthWest, Tile.GrassySouth, Tile.GrassySouth, Tile.GrassySouth     , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth     , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouth , Tile.GrassySouthEast , Tile.Air         , Tile.Air         , Tile.Air         , Tile.GrassySouthWest , Tile.GrassySouth , Tile.GrassySouth, Tile.GrassySouthEast },
  };
}
