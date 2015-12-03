package ChessGame;

import javax.swing.JFrame;

public abstract class ChessGame {
  
  protected JFrame cgFrame;
  
  public void playGame() {
    cgFrame.setVisible(true);
  }
  
  protected void initFrame(String title) {
    cgFrame = new JFrame(title);
    cgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cgFrame.setResizable(false);
  }
}