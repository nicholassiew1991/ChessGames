package ChessBoard;

import java.awt.GridLayout;

public class GomokuChessBoard extends ChessBoard {
  
  public static final int LAYOUT_ROW = 16;
  public static final int LAYOUT_COL = 16;
  
  public GomokuChessBoard() {
    super.initLocOnBoard(LAYOUT_ROW, LAYOUT_COL);
  }
  
  public GridLayout getLayout() {
    return new GridLayout(LAYOUT_ROW, LAYOUT_COL);
  }
}
