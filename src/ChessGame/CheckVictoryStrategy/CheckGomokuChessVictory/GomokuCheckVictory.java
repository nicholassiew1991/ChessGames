package ChessGame.CheckVictoryStrategy.CheckGomokuChessVictory;

import Chess.GomokuChess.GomokuChess;
import ChessBoard.ChessBoard;
import ChessBoard.GomokuChessBoard;
import ChessGame.CheckVictoryStrategy.CheckVictoryStrategy;

public abstract class GomokuCheckVictory implements CheckVictoryStrategy<GomokuChessBoard> {
  
  protected int getPreCheckRow() {
    return GomokuChessBoard.LAYOUT_ROW - 5;
  }
  
  protected int getPreCheckCol() {
    return GomokuChessBoard.LAYOUT_COL - 5;
  }
}
