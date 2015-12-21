package ChessGame;

import javax.swing.JFrame;

public abstract class ChessGame {
  
  protected JFrame cgFrame;

  public void playGame() {
    cgFrame.setVisible(true);
  }

  protected void initFrame(String title, int width, int height) {
    cgFrame = new JFrame(title);
    cgFrame.setSize(width, height);
    cgFrame.setLocationRelativeTo(null);
    cgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cgFrame.setResizable(false);
  }
}
