package Chess;

import ChessBoard.ChessBoard;
import ChessBoard.Location;

public interface Movable<T extends ChessBoard> {
  public void move(T cb, Location src, Location dest);
}