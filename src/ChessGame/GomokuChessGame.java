package ChessGame;

import Chess.ChessMaker.GomokuChessMaker;
import Chess.GomokuChess.GomokuChess;
import static Chess.GomokuChess.GomokuChess.TEAM_BLACK;
import ChessBoard.GomokuChessBoard;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GomokuChessGame extends ChessGame {

  private final int FRAME_WIDTH = 1000;
  private final int FRAME_HEIGHT = 1000;
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
    drawButtons();
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
  private boolean checkVictory(int team,int x,int y){
      int a,b;
      //判斷直行的狀況
      for(a = x-4 ; a <= x+4 ; a++ ){
          if(a < 0){
              a = 0;
          }
          if(a > 14 ){
              return false;
          }
          if(gcb.getChessOnLocation(a, y) != null &&  gcb.getChessOnLocation(a+1, y) != null && gcb.getChessOnLocation(a+2, y) != null && gcb.getChessOnLocation(a+3, y) != null && gcb.getChessOnLocation(a+4, y) != null){
              if(gcb.getChessOnLocation(a, y).getSide() == team && gcb.getChessOnLocation(a+1, y).getSide() == team && gcb.getChessOnLocation(a+2, y).getSide() == team && gcb.getChessOnLocation(a+3, y).getSide() == team && gcb.getChessOnLocation(a+4, y).getSide() == team){
                  return true;
              }
          }
      }
      //判斷衡型的狀況
   
          for(b = y-4 ;b <= y+4 ; b++ ){
              if(b < 0){
                  b = 0;
              }
              if(b > 14 ){
                  return false;
              }
              if(gcb.getChessOnLocation(x, b) != null &&  gcb.getChessOnLocation(x, b+1) != null && gcb.getChessOnLocation(x, b+2) != null && gcb.getChessOnLocation(x, b+3) != null && gcb.getChessOnLocation(x, b+4) != null){
                  if(gcb.getChessOnLocation(x, b).getSide() == team && gcb.getChessOnLocation(x, b + 1).getSide() == team && gcb.getChessOnLocation(x, b+2).getSide() == team && gcb.getChessOnLocation(x, b+3).getSide() == team && gcb.getChessOnLocation(x, b+4).getSide() == team){
                      return true;
                  }
              }
          }
      
    
      return false;
  }
  // <editor-fold defaultstate="collapsed" desc="Actions">
  private void chessButtonActions(ActionEvent e) {
    HashMap<String, Integer> coordinate = super.getCoordinates(e.getActionCommand());
    int x = coordinate.get("x");
    int y = coordinate.get("y");
    
    GomokuChess gc = gcb.getChessOnLocation(x, y);
    
    if (gc == null) {
      gcb.setChessOnLocation(this.getChess(super.currentTurnPlayer), x, y);
      System.out.println(x + " " + y);
      drawButtons();
      if(checkVictory(this.getChess(super.currentTurnPlayer).getSide(),x,y) == true){
          System.out.println(this.getChess(super.currentTurnPlayer).getSide() + " Vectory");
      }
      lblTurn.setText(super.changePlayerTurns());
    }
  }
  // </editor-fold>
  
  private void drawButtons() {
    
    ImageIcon emptyIcon = new ImageIcon(GomokuChess.IMG_PATH + GomokuChess.EMPTY_FILE);
    
    for (int a = 0; a < btnChesses.length; a++) {
      for (int b = 0; b < btnChesses[a].length; b++) {
        GomokuChess gc = gcb.getChessOnLocation(a, b);
        btnChesses[a][b].setIcon((gc == null) ? emptyIcon : gc.getChessImage());
      }
    }
  }
}
