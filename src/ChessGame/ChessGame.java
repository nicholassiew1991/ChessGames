package ChessGame;

import javax.swing.JFrame;

public abstract class ChessGame {
  
  private Player pp1, pp2;
  
  protected Player currentTurnPlayer1;
  
  protected static ChessGame cg = null;
  
  protected JFrame cgFrame;
  
  protected ChessGame() {};
  
  public static ChessGame getInstance() {
    return cg;
  }

  protected void initFrame(String title, int width, int height) {
    cgFrame = new JFrame(title);
    cgFrame.setSize(width, height);
    cgFrame.setLocationRelativeTo(null);
    cgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cgFrame.setResizable(false);
  }
  
  public void playGame() {
    cgFrame.setVisible(true);
  }
  
  protected void setPlayer(Player p1, Player p2) {
    this.pp1 = p1;
    this.pp2 = p2;
  }
  
  protected void initialize(Player p1, Player p2) {
    initGame(p1, p2);
    currentTurnPlayer1 = p1;
    initUI();
  }
  
  protected abstract void initGame(Player p1, Player p2);
  protected abstract void initUI();
}
