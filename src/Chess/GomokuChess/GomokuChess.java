package Chess.GomokuChess;

import Chess.Chess;
import javax.swing.ImageIcon;

public class GomokuChess extends Chess {
  
  public static final String IMG_PATH = "res/img/Gomoku/";
  private final String BLACK_FILE = "black.jpg";
  private final String WHITE_FILE = "white.jpg";
  public static final String EMPTY_FILE = "empty.jpg";
  
  public static final int TEAM_BLACK = 1;
  public static final int TEAM_WHITE = 2;
  
  public GomokuChess(int side) {
    super.setSide(side);
  }
  
  public ImageIcon getChessImage() {
    if (super.side == TEAM_BLACK) {
      return new ImageIcon(GomokuChess.IMG_PATH + this.BLACK_FILE);
    }
    return new ImageIcon(GomokuChess.IMG_PATH + this.WHITE_FILE);
  }
}
