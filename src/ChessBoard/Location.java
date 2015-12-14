package ChessBoard;

import Chess.Chess;
import Chess.ChineseDarkChess.DarkChess;

public class Location {

  private int x;
  private int y;
  private Chess c;
  
  public Location(int x, int y) {
    setX(x);
    setY(y);
    this.c = null;
  }

  public int getX() {
    return x;
  }

  private void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  private void setY(int y) {
    this.y = y;
  }

  public Chess getChess() {
    return c;
  }

  public void setChess(Chess c) {
    this.c = c;
  }
}
