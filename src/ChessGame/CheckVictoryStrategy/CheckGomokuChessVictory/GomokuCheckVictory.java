package ChessGame.CheckVictoryStrategy.CheckGomokuChessVictory;

import Chess.GomokuChess.GomokuChess;
import ChessBoard.ChessBoard;
import ChessBoard.GomokuChessBoard;
import ChessGame.CheckVictoryStrategy.CheckVictoryStrategy;

public interface GomokuCheckVictory extends CheckVictoryStrategy {}

class GomokuCheckVictoryUp implements GomokuCheckVictory {

  @Override
  public boolean checkVitory(ChessBoard gcb, int x, int y) {
    if (x < 4) {
      return false;
    }
    
    GomokuChess gc = (GomokuChess) gcb.getChessOnLoc(x, y);
    
    int countContinuous = 1;
    
    
    return true;
  }
  
}
