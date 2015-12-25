package ChessGame;

import Chess.GomokuChess.GomokuChess;
import ChessBoard.GomokuChessBoard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GomokuChessGame extends ChessGame {

  private final int FRAME_WIDTH = 700;
  private final int FRAME_HEIGHT = 400;
  private final String FRAME_TITLE = "Gomoku Chess";
  
  private GomokuChessBoard gcb;
  
  // <editor-fold defaultstate="collapsed" desc="UI components declaration">
  private JPanel container, northPanel, centerPanel;
  private JLabel lblTurn;
  private JButton btnChesses[][];
  // </editor-fold>
  
  public static ChessGame getInstance(Player p1, Player p2) {
    if (cg == null) {
      cg = new GomokuChessGame(p1, p2);
    }
    return cg;
  }

  private GomokuChessGame(Player p1, Player p2) {
    initialize(p1, p2);
  }

  @Override
  protected void initGame(Player p1, Player p2) {
    gcb = new GomokuChessBoard();
    super.setPlayer(p1, p2);
  }
  
  private GomokuChess getChess(Player p) {
    p.getSide();
    return null;
  }

  @Override
  protected void initUI() {
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
    lblTurn = new JLabel("Turn: " + super.currentTurnPlayer1);

    northPanel.add(lblTurn);
  }

  private void initCenterPanel() {
    centerPanel = new JPanel();
  }
}
