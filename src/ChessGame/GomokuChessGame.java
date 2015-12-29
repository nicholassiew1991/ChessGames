package ChessGame;

import Chess.ChessMaker.GomokuChessMaker;
import Chess.GomokuChess.GomokuChess;
import ChessBoard.GomokuChessBoard;
//import ChessGame.CheckVictoryStrategy.CheckGomokuChessVictory.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
  
  private boolean checkVictory(int team, int x, int y){
	  /*
    new GomokuCheckVictoryUp().checkVitory(gcb, x, y);
    new GomokuCheckVictoryDown().checkVitory(gcb, x, y);
    new GomokuCheckVictoryLeft().checkVitory(gcb, x, y);
    new GomokuCheckVictoryRight().checkVitory(gcb, x, y);
    new GomokuCheckVictoryUpperLeft().checkVitory(gcb, x, y);
    new GomokuCheckVictoryUpperRight().checkVitory(gcb, x, y);
    new GomokuCheckVictoryBottomLeft().checkVitory(gcb, x, y);
	*/
      int a,b;
      //判斷直行的狀況
	  
	  if(x <10 ){
	      for(a = x-4 ; a <= x+4 ; a++ ){
              if(a < 0){
                  a = 0;
              }
              if(gcb.getChessOnLoc(a, y) != null &&  gcb.getChessOnLoc(a+1, y) != null && gcb.getChessOnLoc(a+2, y) != null && gcb.getChessOnLoc(a+3, y) != null && gcb.getChessOnLoc(a+4, y) != null){
                  if(gcb.getChessOnLoc(a, y).getSide() == team && gcb.getChessOnLoc(a+1, y).getSide() == team && gcb.getChessOnLoc(a+2, y).getSide() == team && gcb.getChessOnLoc(a+3, y).getSide() == team && gcb.getChessOnLoc(a+4, y).getSide() == team){
                      return true;
                  }
              } 
          }
	  }
	  else{
		  for(a = x+4 ; a >= x-4 ; a--){
	              if(a > 14){
			      a = 14;	  
		      }	  
	    	      if(gcb.getChessOnLoc(a, y) != null &&  gcb.getChessOnLoc(a+1, y) != null && gcb.getChessOnLoc(a+2, y) != null && gcb.getChessOnLoc(a+3, y) != null && gcb.getChessOnLoc(a+4, y) != null){
                          if(gcb.getChessOnLoc(a, y).getSide() == team && gcb.getChessOnLoc(a+1, y).getSide() == team && gcb.getChessOnLoc(a+2, y).getSide() == team && gcb.getChessOnLoc(a+3, y).getSide() == team && gcb.getChessOnLoc(a+4, y).getSide() == team){
                              return true;
                          }
		      }	  
	          }
	  }
      //判斷橫行的狀況
          if(y < 10){  
              for(b = y-4 ;b <= y+4 ; b++ ){
                  if(b < 0){
                      b = 0;
                  }
                  if(gcb.getChessOnLoc(x, b) != null &&  gcb.getChessOnLoc(x, b+1) != null && gcb.getChessOnLoc(x, b+2) != null && gcb.getChessOnLoc(x, b+3) != null && gcb.getChessOnLoc(x, b+4) != null){
                      if(gcb.getChessOnLoc(x, b).getSide() == team && gcb.getChessOnLoc(x, b + 1).getSide() == team && gcb.getChessOnLoc(x, b+2).getSide() == team && gcb.getChessOnLoc(x, b+3).getSide() == team && gcb.getChessOnLoc(x, b+4).getSide() == team){
                          return true;
                      }
                  }
              }
          }  
          else{
              for(b = y+4;b >= y-4;b--){
                  if(b > 14){
                      b = 14;
                  }
                  if(gcb.getChessOnLoc(x, b) != null &&  gcb.getChessOnLoc(x, b+1) != null && gcb.getChessOnLoc(x, b+2) != null && gcb.getChessOnLoc(x, b+3) != null && gcb.getChessOnLoc(x, b+4) != null){
                      if(gcb.getChessOnLoc(x, b).getSide() == team && gcb.getChessOnLoc(x, b + 1).getSide() == team && gcb.getChessOnLoc(x, b+2).getSide() == team && gcb.getChessOnLoc(x, b+3).getSide() == team && gcb.getChessOnLoc(x, b+4).getSide() == team){
                          return true;
                      }
                  }
              }
          }
          //判斷\的狀況
         if(x < 10){  
              for(a = x-4,b = y-4 ;a <= x+4 ; a++,b++ ){
                  if(((a + 4) <= 18) &&  (a >= 0) && ((b+4) <= 18 ) && (b >= 0)) {
                      if(gcb.getChessOnLoc(a, b) != null &&  gcb.getChessOnLoc(a+1, b+1) != null && gcb.getChessOnLoc(a+2, b+2) != null && gcb.getChessOnLoc(a+3, b+3) != null && gcb.getChessOnLoc(a+4, b+4) != null){
                          if(gcb.getChessOnLoc(a, b).getSide() == team && gcb.getChessOnLoc(a+1, b + 1).getSide() == team && gcb.getChessOnLoc(a+2, b+2).getSide() == team && gcb.getChessOnLoc(a+3, b+3).getSide() == team && gcb.getChessOnLoc(a+4, b+4).getSide() == team){
                              return true;
                          }
                      }
                  } 
              }
          }  
          else{
              for(a = x+4,b = y+4;a >= x-4;a--,b--){
                  if(((a + 4) <= 18) &&  (a >= 0) && ((b+4) <= 18 ) && (b >= 0)) {
                      if(gcb.getChessOnLoc(a, b) != null &&  gcb.getChessOnLoc(a+1, b+1) != null && gcb.getChessOnLoc(a+2, b+2) != null && gcb.getChessOnLoc(a+3, b+3) != null && gcb.getChessOnLoc(a+4, b+4) != null){
                          if(gcb.getChessOnLoc(a, b).getSide() == team && gcb.getChessOnLoc(a+1, b + 1).getSide() == team && gcb.getChessOnLoc(a+2, b+2).getSide() == team && gcb.getChessOnLoc(a+3, b+3).getSide() == team && gcb.getChessOnLoc(a+4, b+4).getSide() == team){
                              return true;
                          }
                      }
                  }
              }       
          }
          //判斷/的狀況
         if(x < 10){  
              for(a = x-4,b = y+4 ;a <= x+4 ; a++,b-- ){
                  //System.out.println("debug" +a + " " +b);
                  if(((a + 4) <= 18) &&  ((a) >= 0) && ((b+4) <= 18 ) && ((b-4) >= 0))  {
                      if(gcb.getChessOnLoc(a, b) != null &&  gcb.getChessOnLoc(a+1, b-1) != null && gcb.getChessOnLoc(a+2, b-2) != null && gcb.getChessOnLoc(a+3, b-3) != null && gcb.getChessOnLoc(a+4, b-4) != null){
                          if(gcb.getChessOnLoc(a, b).getSide() == team && gcb.getChessOnLoc(a+1, b-1).getSide() == team && gcb.getChessOnLoc(a+2, b-2).getSide() == team && gcb.getChessOnLoc(a+3, b-3).getSide() == team && gcb.getChessOnLoc(a+4, b-4).getSide() == team){
                              return true;     
                          }
                      }
                  }  
              }
         }
          else{
              for(a = x+4,b = y-4;a >= x-4;a--,b++){
                 if(((a + 4) <= 18) &&  ((a) >= 0) && ((b+4) <= 18 ) && ((b) >= 0)) {
                     //System.out.println(" else debug"+ a + " "+ b);
                     if(gcb.getChessOnLoc(a, b) != null &&  gcb.getChessOnLoc(a+1, b-1) != null && gcb.getChessOnLoc(a+2, b-2) != null && gcb.getChessOnLoc(a+3, b-3) != null && gcb.getChessOnLoc(a+4, b-4) != null){
                         if(gcb.getChessOnLoc(a, b).getSide() == team && gcb.getChessOnLoc(a+1, b-1).getSide() == team && gcb.getChessOnLoc(a+2, b-2).getSide() == team && gcb.getChessOnLoc(a+3, b-3).getSide() == team && gcb.getChessOnLoc(a+4, b-4).getSide() == team){
                             return true;
                             }
                         }
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
    
    GomokuChess gc = (GomokuChess) gcb.getChessOnLoc(x, y);
    
    if (gc == null) {
      gcb.setChessOnLoc(this.getChess(super.currentTurnPlayer), x, y);
      System.out.println(x + " " + y);
      drawButtons();
      if(checkVictory(this.getChess(super.currentTurnPlayer).getSide(), x, y) == true) {
        disableButtons();
        JOptionPane.showMessageDialog(null, super.currentTurnPlayer.getName() + " Win!");
        return;
      }
      lblTurn.setText(super.changePlayerTurns());
    }
  }
  // </editor-fold>
  
  private void disableButtons() {
    for (JButton[] btnChesse : btnChesses) {
      for (JButton btnChesse1 : btnChesse) {
        btnChesse1.setEnabled(false);
      }
    }
  }
  
  private void drawButtons() {
    
    ImageIcon emptyIcon = new ImageIcon(GomokuChess.IMG_PATH + GomokuChess.EMPTY_FILE);
    
    for (int a = 0; a < btnChesses.length; a++) {
      for (int b = 0; b < btnChesses[a].length; b++) {
        GomokuChess gc = (GomokuChess) gcb.getChessOnLoc(a, b);
        btnChesses[a][b].setIcon((gc == null) ? emptyIcon : gc.getChessImage());
      }
    }
  }
}
