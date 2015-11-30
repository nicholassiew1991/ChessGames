
import javax.swing.JFrame;

public class Game {
  
  private final int WIDTH = 300;
  private final int HEIGHT = 300;
  
  private JFrame gameUI;
  
  public Game() {
    initUIComponents();
    //initActions();
  }
  
  private void initUIComponents() {
    gameUI = new JFrame();
    
    gameUI.setSize(this.WIDTH, this.HEIGHT);
    gameUI.setLocationRelativeTo(null);
    gameUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameUI.setResizable(false);
  }
  
  public void show() {
    this.gameUI.setVisible(true);
  }
}