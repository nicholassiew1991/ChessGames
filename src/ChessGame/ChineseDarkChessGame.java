package ChessGame;

import Chess.ChessMaker.DarkChessMaker;
import Chess.ChineseDarkChess.DarkChess;
import ChessBoard.DarkChessBoard;
import ChessBoard.Location;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChineseDarkChessGame extends ChessGame {

  // <editor-fold defaultstate="collapsed" desc="Constants declaration">
  private final int FRAME_WIDTH = 700;
  private final int FRAME_HEIGHT = 400;

  private final String FRAME_TITLE = "Chinese Dark Chess";
  private final String TURN = "Turn: ";
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Variables declaration">
  private DarkChessBoard dcb;
  private Player p1, p2, currentTurnPlayer;
  private DarkChess RedChess[], BlackChess[];
  
  /* These variable is used to control the action after click the buttons. */
  private DarkChess currentSelectChess = null;
  private boolean isSelectChess = false;
  private int currentSelectedX = -1;
  private int currentSelectedY = -1;
  // </editor-fold>

  private JPanel container, northPanel, centerPanel;
  private JLabel lblTurn;
  private JButton btnChesses[][];
  
  // <editor-fold defaultstate="collapsed" desc="Constructuors">
  public static ChessGame getInstance(Player p1, Player p2) {
    if (cg == null) {
      cg = new ChineseDarkChessGame(p1, p2);
    }
    return cg;
  }

  private ChineseDarkChessGame(Player p1, Player p2) {
    dcb = new DarkChessBoard(DarkChessBoard.LANDSCAPE);
    initGame(p1, p2);
    initUI();
  }
  // </editor-fold>
  
  // <editor-fold defaultstate="collapsed" desc="Initialize methods">
  private void initGame(Player p1, Player p2) {
    setPlayers(p1, p2);
    this.RedChess = getChesses(DarkChess.TEAM_RED);
    this.BlackChess = getChesses(DarkChess.TEAM_BLACK);
    dcb.placeChess(RedChess, BlackChess);
    currentTurnPlayer = p1;
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
    lblTurn = new JLabel("Turn: " + this.currentTurnPlayer);

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
            chessButtonsEvent(e);
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
  
  private void changePlayerTurn() {
    this.currentTurnPlayer = (this.currentTurnPlayer == p1 ? p2 : p1);
    this.lblTurn.setText(this.TURN + this.currentTurnPlayer);
  }
  
  private void selectChess(DarkChess dc, int x, int y) {
    this.isSelectChess = true;
    currentSelectChess = dc;
    currentSelectedX = x;
    currentSelectedY = y;
    System.out.println("Saved current button");
  }
  
  private void deselectChess() {
    this.isSelectChess = false;
    this.currentSelectChess = null;
    this.currentSelectedX = this.currentSelectedY = -1;
    System.out.println("Unselected.");
  }
  
  public void disableButtons(ArrayList<Location> enableLoc) {
    for (int a = 0; a < btnChesses.length; a++) {
      nextChess:
      for (int b = 0; b < btnChesses[a].length; b++) {
        for (Location loc : enableLoc) {
          if (a == loc.getX() && b == loc.getY()) {
            if (dcb.getChessOnLoc(loc.getX(), loc.getY()).getStatus() == DarkChess.STATUS_UNKNOWN) {
              btnChesses[a][b].setEnabled(false);
            }
            else {
              btnChesses[a][b].setEnabled(true);
            }
            continue nextChess;
          }
          else {
            btnChesses[a][b].setEnabled(false);
          }
        }
      }
    }
  }
  
  public void enableButtons() {
    for (JButton[] btnChesse : btnChesses) {
      for (JButton btnChesse1 : btnChesse) {
        btnChesse1.setEnabled(true);
      }
    }
  }
  
  private void chessButtonsEvent(ActionEvent e) {
    int x = Integer.parseInt(e.getActionCommand().substring(0, 1));
    int y = Integer.parseInt(e.getActionCommand().substring(2));
    
    DarkChess dc = dcb.getChessOnLoc(x, y);
    
    if (this.isSelectChess == false) {
      if (dc.getStatus() == DarkChess.STATUS_UNKNOWN) {
        dc.setStatus(DarkChess.STATUS_FLIPPED);
        changePlayerTurn();
        drawButtonsImage();
      }
      else if (dc.getTeam() != currentTurnPlayer.getSide()) {
        JOptionPane.showMessageDialog(null, "Please select your's side chess.");
      }
      else if (dc.getStatus() == DarkChess.STATUS_FLIPPED) {
        selectChess(dc, x, y);
        disableButtons(dc.getClickableLocation(dcb, x, y));
      }
    }
    else {
      if (x == this.currentSelectedX && y == this.currentSelectedY) {
        enableButtons();
      }
      else {
        if (dc == null) {
          System.out.println("Move");
        }
        else {
          System.out.println("Eat");                
          System.out.println(this.currentSelectChess.eat(dc)); 
        }
        enableButtons();
        drawButtonsImage();
      }
      deselectChess();
    }
  }
}