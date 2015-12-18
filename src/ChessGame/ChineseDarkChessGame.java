package ChessGame;

import Chess.ChessMaker.DarkChessMaker;
import Chess.ChineseDarkChess.DarkChess;
import ChessBoard.DarkChessBoard;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
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
  private JButton btnChesses[][];

  public ChineseDarkChessGame(Player p1, Player p2) {
    dcb = new DarkChessBoard(DarkChessBoard.LANDSCAPE);
    initFrame();
    initGame();
  }

  private void initGame() {
    setPlayers(p1, p2);
    this.RedChess = getChesses(DarkChess.TEAM_RED);
    this.BlackChess = getChesses(DarkChess.TEAM_BLACK);
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
    centerPanel.setLayout(dcb.getLayout());
    this.btnChesses = new JButton[dcb.getNumOfRows()][dcb.getNumOfCols()];
    for (int a = 0; a < this.btnChesses.length; a++) {
      for (int b = 0; b < this.btnChesses[a].length; b++) {
        this.btnChesses[a][b] = new JButton(a + ", " + b);
        centerPanel.add(this.btnChesses[a][b]);
      }
    }
  }

	private void setPlayers(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

  private DarkChess[] getChesses(int team) {

    DarkChessMaker cm = new DarkChessMaker();

    return new DarkChess[] {
      cm.createChess(cm.GENERAL, team),
      cm.createChess(cm.SCHOLAR, team),
      cm.createChess(cm.SCHOLAR, team),
      cm.createChess(cm.ELEPHANT, team),
      cm.createChess(cm.ELEPHANT, team),
      cm.createChess(cm.CAR, team),
      cm.createChess(cm.CAR, team),
      cm.createChess(cm.HORSE, team),
      cm.createChess(cm.HORSE, team),
      cm.createChess(cm.GUN, team),
      cm.createChess(cm.GUN, team),
      cm.createChess(cm.SOLDIER, team),
      cm.createChess(cm.SOLDIER, team),
      cm.createChess(cm.SOLDIER, team),
      cm.createChess(cm.SOLDIER, team),
      cm.createChess(cm.SOLDIER, team)
    };
  }
}
