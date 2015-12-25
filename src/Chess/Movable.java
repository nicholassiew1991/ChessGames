package Chess;

import ChessBoard.ChessBoard;
import ChessBoard.Location;

public interface Movable<T extends ChessBoard> {
  public boolean move();
  public void move(T cb, Location src, Location dest);
}