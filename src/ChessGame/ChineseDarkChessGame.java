package ChessGame;

import Chess.ChessMaker.DarkChessMaker;
import Chess.ChineseDarkChess.DarkChess;
import ChessBoard.DarkChessBoard;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChineseDarkChessGame extends ChessGame {

  // <editor-fold defaultstate="collapsed" desc="Constants declaration">
  private final int FRAME_WIDTH = 700;
  private final int FRAME_HEIGHT = 400;

  private final String FRAME_TITLE = "Chinese Dark Chess";
  private final String TURN_RED = "Turn: RED";
  private final String TURN_BLACK = "Turn: BLACK";
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Variables declaration">
  private DarkChessBoard dcb;
	private Player p1, p2;
  private DarkChess RedChess[], BlackChess[];
  // </editor-fold>

  private JPanel container, northPanel, centerPanel;
  private JLabel lblTurn;
  private JButton btnChesses[][];

  public ChineseDarkChessGame(Player p1, Player p2) {
    dcb = new DarkChessBoard(DarkChessBoard.LANDSCAPE);
    initGame();
    initUI();
  }

  // <editor-fold defaultstate="collapsed" desc="Initialize methods">
  private void initGame() {
    setPlayers(p1, p2);
    this.RedChess = getChesses(DarkChess.TEAM_RED);
    this.BlackChess = getChesses(DarkChess.TEAM_BLACK);
    dcb.placeChess(RedChess, BlackChess);
  }
  
  private void drawButtonsImage() {
    for (int a = 0; a < this.btnChesses.length; a++) {
      for (int b = 0; b < this.btnChesses[a].length; b++) {
        DarkChess dc = dcb.getChessOnLoc(a, b);
        this.btnChesses[a][b].setIcon((dc == null ? null : dc.getChessImage()));
      }
    }
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

  private void initUI() {
    super.initFrame(FRAME_TITLE, FRAME_WIDTH, FRAME_HEIGHT);
    initCointainer();
    drawButtonsImage();
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
    
    // <editor-fold defaultstate="collapsed" desc="Initialize and add buttons">
    for (int a = 0; a < this.btnChesses.length; a++) {
      for (int b = 0; b < this.btnChesses[a].length; b++) {
        this.btnChesses[a][b] = new JButton();
        this.btnChesses[a][b].setActionCommand(String.format("%d,%d", a, b));
        centerPanel.add(this.btnChesses[a][b]);
        this.btnChesses[a][b].addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            boardButtonEvents(e);
          }
        });
      }
    }
    // </editor-fold>
  }
  // </editor-fold>

	private void setPlayers(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
  
  private void boardButtonEvents(ActionEvent e) {
    int x = Integer.parseInt(e.getActionCommand().substring(0, 1));
    int y = Integer.parseInt(e.getActionCommand().substring(2));
    
    DarkChess dc = dcb.getChessOnLoc(x, y);
    
    if (dc == null) {
      return; // Do nothing
    }
    
    dc.setStatus(DarkChess.STATUS_FLIPPED);
    drawButtonsImage();
  }
}