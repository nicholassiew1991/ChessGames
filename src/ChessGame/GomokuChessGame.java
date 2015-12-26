package ChessGame;

import Chess.ChessMaker.GomokuChessMaker;
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

  private final int FRAME_WIDTH = 800;
  private final int FRAME_HEIGHT = 800;
  private final String FRAME_TITLE = "Gomoku Chess";
  
  private GomokuChessBoard gcb;
  
  // <editor-fold defaultstate="collapsed" desc="UI components declaration">
  private JPanel container, northPanel, centerPanel;
  private JLabel lblTurn;
  private JButton btnChesses[][];
  // </editor-fold>
  
  // <editor-fold defaultstate="collapsed" desc="Constructuors">
  public static ChessGame getInstance(Player p1, Player p2) {
    if (cg == null) {
      cg = new GomokuChessGame(p1, p2);
    }
    return cg;
  }

  private GomokuChessGame(Player p1, Player p2) {
    initialize(p1, p2);
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Initialize methods">
  @Override
  protected void initGame(Player p1, Player p2) {
    gcb = new GomokuChessBoard();
    super.setPlayer(p1, p2);
  }
  
  private GomokuChess getChess(Player p) {
    GomokuChessMaker gcm = new GomokuChessMaker();
    return gcm.createChess(0, p.getSide());
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
    lblTurn = new JLabel("Turn: " + super.currentTurnPlayer);

    northPanel.add(lblTurn);
  }

  private void initCenterPanel() {
    centerPanel = new JPanel();
    centerPanel.setLayout(gcb.getLayout());
    initChessButtons();
  }
  
  private void initChessButtons() {
    btnChesses = new JButton[gcb.LAYOUT_ROW][gcb.LAYOUT_COL];
    
    for (int a = 0; a < btnChesses.length; a++) {
      for (int b = 0; b < btnChesses[a].length; b++) {
        btnChesses[a][b] = new JButton();
        btnChesses[a][b].setActionCommand(String.format("%d,%d", a, b));
        this.centerPanel.add(btnChesses[a][b]);
        btnChesses[a][b].addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            chessButtonActions(e);
          }
        });
      }
    }
  }
  // </editor-fold>
  
  // <editor-fold defaultstate="collapsed" desc="Actions">
  private void chessButtonActions(ActionEvent e) {
    System.out.println(e.getActionCommand());
  }
  // </editor-fold>
}
