package ChessGame.CheckVictoryStrategy.CheckGomokuChessVictory;

import Chess.GomokuChess.GomokuChess;
import ChessBoard.GomokuChessBoard;

public class GomokuCheckVictoryUpperRight extends GomokuCheckVictory{

  @Override
  public boolean checkVitory(GomokuChessBoard gcb, int x, int y) {
    if (x < 4 || y > super.getPreCheckCol()) {
      return false;
    }
    
    GomokuChess startGC = (GomokuChess) gcb.getChessOnLoc(x, y);

    int countContinuous = 1;
    int startX = x;
    int startY = y;
    
    for (int a = 0; a < 4; a++) {
      startX -= 1;
      startY += 1;
      GomokuChess gc = (GomokuChess) gcb.getChessOnLoc(startX, startY);
      
      if (gc != null && startGC.getSide() == gc.getSide()) {
        countContinuous++;
      } 
      else {
        break;
      }
    }

    if (countContinuous == 5) {
      System.out.println("Upper Right Win");
      return true;
    }
    
    return false;
  }
  
}
