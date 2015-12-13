package ChessGame;

import Chess.ChineseDarkChess.DarkChess;
import ChessBoard.DarkChessBoard;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChineseDarkChessGame extends ChessGame {

  private final int FRAME_WIDTH = 600;
  private final int FRAME_HEIGHT = 400;

  private final String FRAME_TITLE = "Chinese Dark Chess";
  private final String TURN_RED = "Turn: RED";
  private final String TURN_BLACK = "Turn: BLACK";

  private DarkChessBoard dcb;
	private Player p1, p2;
  private DarkChess RedChess[], BlackChess[];

  private JPanel container, northPanel, centerPanel;
  private JLabel lblTurn;

  public ChineseDarkChessGame(Player p1, Player p2) {
    dcb = new DarkChessBoard();
    initFrame();
    setPlayer(p1, p2);
  }

  private void initFrame() {
    super.initFrame(FRAME_TITLE, FRAME_WIDTH, FRAME_HEIGHT);
    initCointainer();
  }

  private void initCointainer() {
    container = new JPanel();
    
    initNorthPanel();
    initCenterPanel();
    
    container.setLayout(new BorderLayout());
    container.add(northPanel, BorderLayout.NORTH);
    container.add(centerPanel, BorderLayout.CENTER);
    cgFrame.add(container);
  }
  
  private void initNorthPanel() {
    northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    lblTurn = new JLabel("Turn: ");
    
    northPanel.add(lblTurn);
  }
  
  private void initCenterPanel() {
    centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(DarkChessBoard.LANDSCAPE_ROW, DarkChessBoard.LANDSCAPE_COL));
    for (int a = 0; a < 32; a++) {
      centerPanel.add(new JLabel("Turn: "));
    }
  }

	private void setPlayer(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
}
