package ChessBoard;

import Chess.GomokuChess.GomokuChess;
import java.awt.GridLayout;

public class GomokuChessBoard extends ChessBoard {
  
  public final int LAYOUT_ROW = 19;
  public final int LAYOUT_COL = 19;
  
  private Location[][] locOnBoard;
  
  public GomokuChessBoard() {
    this.initLocOnBoard();
  }
  
  private void initLocOnBoard() {
    this.locOnBoard = new Location[LAYOUT_ROW][LAYOUT_COL];
    
    for (int a = 0; a < this.locOnBoard.length; a++) {
      for (int b = 0; b < this.locOnBoard[a].length; b++) {
        this.locOnBoard[a][b] = new Location(a, b);
      }
    }
  }
  
  public GridLayout getLayout() {
    return new GridLayout(this.LAYOUT_ROW, this.LAYOUT_COL);
  }
  
  public Location[][] getLocationInfo() {
    return this.locOnBoard;
  }
  
  public void setChessOnLocation(GomokuChess gc, int x, int y) {
    this.locOnBoard[x][y].setChess(gc);
  }
  
  public GomokuChess getChessOnLocation(int x, int y) {
    return (GomokuChess) this.locOnBoard[x][y].getChess();
  }
  
}
