package Chess.ChessMaker;

import Chess.Chess;
import Chess.GomokuChess.GomokuChess;

public class GomokuChessMaker extends ChessMaker {

  @Override
  public GomokuChess createChess(int chesstype, int team) {
    return new GomokuChess(team);
  }
    
}
