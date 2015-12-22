package ChessBoard;

import Chess.Chess;
import Chess.ChineseDarkChess.DarkChess;

public class Location {

  private int x;
  private int y;
  private Chess c;
  
  public Location(int x, int y) {
    this.x = x;
    this.y = y;
    this.c = null;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Chess getChess() {
    return c;
  }

  public void setChess(Chess c) {
    this.c = c;
  }
}
