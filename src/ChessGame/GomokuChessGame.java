package ChessGame;

public class GomokuChessGame extends ChessGame {

  private final int FRAME_WIDTH = 600;
  private final int FRAME_HEIGHT = 300;

  private final String FRAME_TITLE = "Gomoku Chess";
  
  public static ChessGame getInstance(Player p1, Player p2) {
    if (cg == null) {
      cg = new GomokuChessGame(p1, p2);
    }
    return cg;
  }

  private GomokuChessGame(Player p1, Player p2) {
    initFrame();
  }

  private void initFrame() {
    super.initFrame(FRAME_TITLE, FRAME_WIDTH, FRAME_HEIGHT);
  }
}
