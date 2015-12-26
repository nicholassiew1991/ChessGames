package ChessGame;

import javax.swing.JFrame;

public abstract class ChessGame {
  
  protected Player p1, p2;
  protected Player currentTurnPlayer;
  
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
  
  protected void initialize(Player p1, Player p2) {
    initGame(p1, p2);
    currentTurnPlayer = p1;
    initUI();
  }
  
  protected void setPlayer(Player p1, Player p2) {
    this.p1 = p1;
    this.p2 = p2;
  }
  
  protected String changePlayerTurns() {
    this.currentTurnPlayer = (this.currentTurnPlayer == p1 ? p2 : p1);
    return "Turn: " + this.currentTurnPlayer;
  }
  
  protected abstract void initGame(Player p1, Player p2);
  protected abstract void initUI();
}
