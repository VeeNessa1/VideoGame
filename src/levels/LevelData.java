package levels;

public class LevelData
{
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
    
    Tiles(int id)
    {
      this.id = id;
    }

    Tiles(int id, boolean isSolid)
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

  public static final Tiles[][] LEVEL_ONE_DATA = {
    { Tiles.GrassyNorthWest, Tiles.GrassyNorth, Tiles.GrassyNorth, Tiles.GrassyNorth     , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth     , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth     , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth     , Tiles.GrassyNorth , Tiles.GrassyNorth, Tiles.GrassyNorthEast },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.GrassyNorthWest , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorthEast , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.Air        , Tiles.Air        , Tiles.GrassyWest      , Tiles.GrassyNone  , Tiles.GrassyNone  , Tiles.GrassyNone  , Tiles.GrassyEast      , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.Air             , Tiles.Air         , Tiles.Air        , Tiles.GrassyEast      },
    { Tiles.GrassyWest     , Tiles.GrassyNorth, Tiles.GrassyNorth, Tiles.GrassyNone3     , Tiles.GrassyNone  , Tiles.GrassyNone  , Tiles.GrassyNone  , Tiles.GrassyNone4     , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorth , Tiles.GrassyNorthEast , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.GrassyNorthWest , Tiles.GrassyNorth , Tiles.GrassyNorth, Tiles.GrassyEast      },
    { Tiles.GrassySouthWest, Tiles.GrassySouth, Tiles.GrassySouth, Tiles.GrassySouth     , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth     , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouth , Tiles.GrassySouthEast , Tiles.Air         , Tiles.Air         , Tiles.Air         , Tiles.GrassySouthWest , Tiles.GrassySouth , Tiles.GrassySouth, Tiles.GrassySouthEast },
  };
}
