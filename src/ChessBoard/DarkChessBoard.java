package ChessBoard;

import Chess.ChineseDarkChess.DarkChess;
import Utilities.Util;
import java.awt.GridLayout;
import java.util.Random;

public class DarkChessBoard extends ChessBoard {

  private final int LANDSCAPE_ROW = 4;
  private final int LANDSCAPE_COL = 8;
  private final int POTRAIT_ROW = 8;
  private final int POTRAIT_COL = 4;

  public static final int LANDSCAPE = 1;
  public static final int POTRAIT = 2;

  private Location[][] locOnBoard;

  private int layout;

  public DarkChessBoard(int layout) {
    setLayout(layout);
  }
  
  public void placeChess(DarkChess[] dc1, DarkChess[] dc2) {
    Random rand = new Random();
    DarkChess[] temp = new DarkChess[dc1.length + dc2.length];
    
    System.arraycopy(dc1, 0, temp, 0, dc1.length);
    System.arraycopy(dc2, 0, temp, dc1.length, dc2.length);
    Util.sufflingArray(temp);
    
    for (DarkChess dc : temp) {
      while (true) {
        int x = rand.nextInt(4);
        int y = rand.nextInt(8);

        if (locOnBoard[x][y].getChess() != null) {
          continue;
        }

        locOnBoard[x][y].setChess(dc);
        break;
      }
    }
  }
  
  private void setLayout(int layout) {
    // Potrait not available yet.
    // If layout value is unexpected, then set it to landscape
    this.layout = (layout == POTRAIT ? LANDSCAPE : LANDSCAPE);
    this.locOnBoard = new Location[getNumOfRows()][getNumOfCols()];
    
    initLocOnBoard();
  }

  public GridLayout getLayout() {
    return new GridLayout(getNumOfRows(), getNumOfCols());
  }
  
  public int getNumOfRows() {
    return (layout == LANDSCAPE ? LANDSCAPE_ROW : POTRAIT_ROW);
  }
  
  public int getNumOfCols() {
    return (layout == LANDSCAPE ? LANDSCAPE_COL : POTRAIT_COL);
  }

  public Location[][] getBoardInfo() {
    return this.locOnBoard;
  }
  
  private void initLocOnBoard() {
    for (int a = 0; a < locOnBoard.length; a++) {
      for (int b = 0; b < locOnBoard[a].length; b++) {
        locOnBoard[a][b] = new Location(a, b);
      }
    }
  }
  
  public void setChessOnLoc(DarkChess dc, int x, int y) {
    locOnBoard[x][y].setChess(dc);
  }
  
  public DarkChess getChessOnLoc(int x, int y) {
    DarkChess dc = (DarkChess) locOnBoard[x][y].getChess();
    return dc;
  }
}
