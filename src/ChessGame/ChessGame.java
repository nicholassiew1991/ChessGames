package ChessGame;

import java.util.HashMap;
import javax.swing.JFrame;

public abstract class ChessGame {
  
  protected Player p1, p2;
  protected Player currentTurnPlayer;
  
  protected static ChessGame cg = null;
  
  protected JFrame cgFrame;
  
  // <editor-fold defaultstate="collapsed" desc="Constructuors">
  protected ChessGame() {};
  
  public static ChessGame getInstance() {
    return cg;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Initialize methods">
  protected void initFrame(String title, int width, int height) {
    cgFrame = new JFrame(title);
    cgFrame.setSize(width, height);
    cgFrame.setLocationRelativeTo(null);
    cgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cgFrame.setResizable(false);
  }
  
  protected void initialize(Player p1, Player p2) {
    initGame(p1, p2);
    currentTurnPlayer = p1;
    initUI();
  }
  // </editor-fold>
  
  public void playGame() {
    cgFrame.setVisible(true);
  }
  
  protected void setPlayer(Player p1, Player p2) {
    this.p1 = p1;
    this.p2 = p2;
  }
  
  protected String changePlayerTurns() {
    this.currentTurnPlayer = (this.currentTurnPlayer == p1 ? p2 : p1);
    return "Turn: " + this.currentTurnPlayer;
  }
  
  protected HashMap<String, Integer> getCoordinates(String str) {
    HashMap<String, Integer> hm = new HashMap();
    
    String[] coordinate = str.split(",");
    
    hm.put("x", Integer.parseInt(coordinate[0]));
    hm.put("y", Integer.parseInt(coordinate[1]));
    
    return hm;
  }
  
  protected abstract void initGame(Player p1, Player p2);
  protected abstract void initUI();
}
