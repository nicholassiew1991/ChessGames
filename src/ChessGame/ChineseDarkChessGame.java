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
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChineseDarkChessGame extends ChessGame {

  // <editor-fold defaultstate="collapsed" desc="Constants declaration">
  private final int FRAME_WIDTH = 700;
  private final int FRAME_HEIGHT = 400;

  private final String FRAME_TITLE = "Chinese Dark Chess";
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Variables declaration">
  private DarkChessBoard dcb;
  private DarkChess RedChess[], BlackChess[];
  
  /* These variable is used to control the action after click the buttons. */
  private DarkChess currentSelectChess = null;
  private boolean isSelectChess = false;
  private int currentSelectedX = -1;
  private int currentSelectedY = -1;
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="UI components declaration">
  private JPanel container, northPanel, centerPanel;
  private JLabel lblTurn;
  private JButton btnChesses[][];
  // </editor-fold>
  
  // <editor-fold defaultstate="collapsed" desc="Constructuors">
  public static ChessGame getInstance(Player p1, Player p2) {
    if (cg == null) {
      cg = new ChineseDarkChessGame(p1, p2);
    }
    return cg;
  }

  private ChineseDarkChessGame(Player p1, Player p2) {
    dcb = new DarkChessBoard(DarkChessBoard.LANDSCAPE);
    initialize(p1, p2);
  }
  // </editor-fold>
  
  // <editor-fold defaultstate="collapsed" desc="Initialize methods">
  @Override
  protected void initGame(Player p1, Player p2) {
    super.setPlayer(p1, p2);
    this.p1.setTotalChess(16);
    this.p2.setTotalChess(16);
    this.RedChess = getChesses(DarkChess.TEAM_RED);
    this.BlackChess = getChesses(DarkChess.TEAM_BLACK);
    dcb.placeChess(RedChess, BlackChess);
    currentTurnPlayer = this.p1;
  }
  
  private void drawButtonsImage() {
    for (int a = 0; a < this.btnChesses.length; a++) {
      for (int b = 0; b < this.btnChesses[a].length; b++) {
        DarkChess dc = (DarkChess) dcb.getChessOnLoc(a, b);
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

  @Override
  protected void initUI() {
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
  
  /**
   * Disable buttons base on the button that can click after select the chess.
   * @param enableLoc - The arraylist that store the location that can enable.
   */
  private void disableButtons(ArrayList<Location> enableLoc) {
    for (int x = 0; x < btnChesses.length; x++) {
      nextChess:
      for (int y = 0; y < btnChesses[x].length; y++) {
        for (Location loc : enableLoc) {
          
          int enabledX = loc.getX();
          int enabledY = loc.getY();
          
          if (x == enabledX && y == enabledY) {
            
            DarkChess dc = (DarkChess) dcb.getChessOnLoc(enabledX, enabledY);
            
            if (dc == null) {
              btnChesses[x][y].setEnabled(true);
            }
            else if (dc.getStatus() == DarkChess.STATUS_UNKNOWN) {
              btnChesses[x][y].setEnabled(false);
            }
            else {
              btnChesses[x][y].setEnabled(true);
            }
            continue nextChess;
          }
          else {
            btnChesses[x][y].setEnabled(false);
          }
        }
      }
    }
  }
  
  private void disableButtons() {
    for (JButton[] btnChesse : btnChesses) {
      for (JButton btnChesse1 : btnChesse) {
        btnChesse1.setEnabled(false);
      }
    }
  }
  
  private void enableButtons() {
    for (JButton[] btnChesse : btnChesses) {
      for (JButton btnChesse1 : btnChesse) {
        btnChesse1.setEnabled(true);
      }
    }
  }
  
  private boolean checkPlayerWin(DarkChess dc) {
    Player ply = (dc.getSide() == DarkChess.TEAM_RED ? p1 : p2);
    ply.setTotalChess(ply.getTotalChess() - 1);
    
    if (ply.getTotalChess() == 0) {
      Player eater = (dc.getSide() == DarkChess.TEAM_RED ? p2 : p1);
      JOptionPane.showMessageDialog(null, eater.getName() + " Win!");
      return true;
    }
    
    return false;
  }
  
  private void chessButtonsEvent(ActionEvent e) {
    HashMap<String, Integer> coordinate = super.getCoordinates(e.getActionCommand());
    int x = coordinate.get("x");
    int y = coordinate.get("y");
    
    DarkChess dc = (DarkChess) dcb.getChessOnLoc(x, y);
    System.out.println(dc);
    
    if (this.isSelectChess == false && dc != null) {
      if (dc.getStatus() == DarkChess.STATUS_UNKNOWN) {
        dc.setStatus(DarkChess.STATUS_FLIPPED);
        lblTurn.setText(changePlayerTurns());
        drawButtonsImage();
      }
      else if (dc.getSide() != currentTurnPlayer.getSide()) {
        JOptionPane.showMessageDialog(null, "Please select your's side chess.");
      }
      else if (dc.getStatus() == DarkChess.STATUS_FLIPPED) {
        selectChess(dc, x, y);
        disableButtons(dc.getClickableLocation(dcb, x, y));
      }
    }
    else if (this.isSelectChess == true) {
      if (!(x == this.currentSelectedX && y == this.currentSelectedY)) {
        Location src = new Location(currentSelectedX, currentSelectedY);
        Location dest = new Location(x, y);
        if (dc == null) {
          currentSelectChess.move(dcb, src, dest);
          lblTurn.setText(changePlayerTurns());
        }
        else {
          int retEatVal = this.currentSelectChess.eat(dc);
          if (retEatVal == DarkChess.EAT_SUCCESS) {
            dc.setStatus(DarkChess.STATUS_DEATH);
            currentSelectChess.move(dcb, src, dest);
            drawButtonsImage();
            if (checkPlayerWin(dc) == true) {
              disableButtons();
              return ;
            }
            lblTurn.setText(changePlayerTurns());
          }
          else {
            JOptionPane.showMessageDialog(null, dc.getEatMessage(retEatVal));
          }
        }
        drawButtonsImage();
      }
      enableButtons();
      deselectChess();
    }
  }
}