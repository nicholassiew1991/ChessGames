package ChessBoard;

import Chess.ChineseDarkChess.DarkChess;
import java.awt.GridLayout;
import java.util.Random;

public class DarkChessBoard extends ChessBoard {

  private final int LANDSCAPE_ROW = 4;
  private final int LANDSCAPE_COL = 8;
  private final int POTRAIT_ROW = 8;
  private final int PORTAIT_COL = 4;

  public static final int LANDSCAPE = 1;
  //public static final int POTRAIT = 2;

  private Location[][] locOnBoard;

  private int layout;

  public DarkChessBoard() {
    setLayout();
  }

  public void placeChessRandom(DarkChess dc) {
    Random rand = new Random();

    while (true) {
      int x = rand.nextInt(4);
      int y = rand.nextInt(8);

      if (locOnBoard[x][y].getChess() == null) {
        continue;
      }

      locOnBoard[x][y].setChess(dc);
      break;
    }
  }

  /*
   * Set the layout and initialize the location on the board.
   * By default is landscape
   */
  private void setLayout() {
    this.layout = LANDSCAPE;
    this.locOnBoard = new Location[LANDSCAPE_ROW][LANDSCAPE_COL];
    initLocOnBoard();
  }

  public GridLayout getLayout() {
    return new GridLayout(LANDSCAPE_ROW, LANDSCAPE_COL);
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
}
