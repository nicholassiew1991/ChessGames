package ChessBoard;

import java.awt.GridLayout;

public class GomokuChessBoard extends ChessBoard {
  
  public final int LAYOUT_ROW = 19;
  public final int LAYOUT_COL = 19;
  
  public GomokuChessBoard() {
    super.initLocOnBoard(LAYOUT_ROW, LAYOUT_COL);
  }
  
  public GridLayout getLayout() {
    return new GridLayout(this.LAYOUT_ROW, this.LAYOUT_COL);
  }
}
