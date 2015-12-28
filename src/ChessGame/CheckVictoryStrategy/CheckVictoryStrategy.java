package ChessGame.CheckVictoryStrategy;

import ChessBoard.ChessBoard;

public interface CheckVictoryStrategy<T extends ChessBoard> {
  boolean checkVitory(T cb, int x, int y);
}
