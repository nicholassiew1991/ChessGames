package ChessGame;

import Chess.ChessMaker.DarkChessMaker;
import Chess.ChineseDarkChess.DarkChess;
import static Chess.ChineseDarkChess.DarkChess.TEAM_BLACK;
import static Chess.ChineseDarkChess.DarkChess.TEAM_RED;
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
    for (int x = 0; x < btnChesses.length; x++) {
      nextChess:
      for (int y = 0; y < btnChesses[x].length; y++) {
        for (Location loc : enableLoc) {
          
          int enabledX = loc.getX();
          int enabledY = loc.getY();
          
          if (x == enabledX && y == enabledY) {
            
            DarkChess dc = dcb.getChessOnLoc(enabledX, enabledY);
            
            if (dc == null) {
              btnChesses[x][y].setEnabled(true);
            }
            else if (dc.getStatus() == DarkChess.STATUS_UNKNOWN) {
              btnChesses[x][y].setEnabled(false);
            }
            else if (dc.getTeam() == currentSelectChess.getTeam() && !(x == this.currentSelectedX && y == this.currentSelectedY)) {
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
    System.out.println(dc);
    
    if (this.isSelectChess == false) {
      if (dc == null) {
        return;
      }
      else if (dc.getStatus() == DarkChess.STATUS_UNKNOWN) {
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
        Location src = new Location(currentSelectedX, currentSelectedY);
        Location dest = new Location(x, y);
        if (dc == null) {
          currentSelectChess.move(dcb, src, dest);
          changePlayerTurn();
        }
        else {
          if (this.currentSelectChess.eat(dc) == DarkChess.EAT_SUCCESS) {
            dc.setStatus(DarkChess.STATUS_DEATH);
            currentSelectChess.move(dcb, src, dest);
            if(dc.getTeam() == TEAM_RED){
                 p1.setTotalChess(p1.getTotalChess() - 1);
                if(p1.getTotalChess() ==0 ){
                    JOptionPane.showMessageDialog(null, "P2 Win");
                }
            }
            if(dc.getTeam() == TEAM_BLACK){
                 p2.setTotalChess(p2.getTotalChess() - 1);
                if(p2.getTotalChess() ==0 ){
                    JOptionPane.showMessageDialog(null, "P1 Win");
                }
            }
            changePlayerTurn();
          }
        }
        enableButtons();
        drawButtonsImage();
      }
      deselectChess();
    }
  }
}