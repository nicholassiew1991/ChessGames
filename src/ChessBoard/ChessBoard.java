package ChessBoard;

import Chess.Chess;
import Chess.ChineseDarkChess.DarkChess;

public abstract class ChessBoard {
  
  protected Location[][] locOnBoard;
  
  protected void initLocOnBoard(int row, int col) {
    locOnBoard = new Location[row][col];
    
    for (int a = 0; a < locOnBoard.length; a++) {
      for (int b = 0; b < locOnBoard[a].length; b++) {
        locOnBoard[a][b] = new Location(a, b);
      }
    }
  }
  
  public Location[][] getBoardInfo() {
    return locOnBoard;
  }
  
  public void setChessOnLoc(Chess dc, int x, int y) {
    locOnBoard[x][y].setChess(dc);
  }
  
  public Chess getChessOnLoc(int x, int y) {
    return locOnBoard[x][y].getChess();
  }
}
