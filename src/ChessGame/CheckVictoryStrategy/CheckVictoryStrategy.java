package ChessGame.CheckVictoryStrategy;

import ChessBoard.ChessBoard;

public interface CheckVictoryStrategy {
  boolean checkVitory(ChessBoard cb, int x, int y);
}
