package Chess.GomokuChess;

import Chess.Chess;

public class GomokuChess extends Chess {
  
  public static final int TEAM_BLACK = 1;
  public static final int TEAM_WHITE = 2;
  
  public GomokuChess(int side) {
    super.setSide(side);
  }
}
