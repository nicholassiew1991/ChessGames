package ChessGame.CheckVictoryStrategy.CheckGomokuChessVictory;

import Chess.GomokuChess.GomokuChess;
import ChessBoard.ChessBoard;
import ChessBoard.GomokuChessBoard;

public class GomokuCheckVictoryUp extends GomokuCheckVictory {

  @Override
  public boolean checkVitory(GomokuChessBoard gcb, int x, int y) {
    if (x < 4) {
      return false;
    }

    GomokuChess startGC = (GomokuChess) gcb.getChessOnLoc(x, y);

    int countContinuous = 1;
    int startX = x;

    for (int a = 0; a < 4; a++) {
      startX -= 1;
      GomokuChess gc = (GomokuChess) gcb.getChessOnLoc(startX, y);
      
      if (gc != null && startGC.getSide() == gc.getSide()) {
        countContinuous++;
      } 
      else {
        break;
      }
    }

    if (countContinuous == 5) {
      System.out.println("Up Win");
      return true;
    }

    return true;
  }

}
