package ChessGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChineseDarkChessGame extends ChessGame {

  private final int FRAME_WIDTH = 600;
  private final int FRAME_HEIGHT = 300;

  private final String FRAME_TITLE = "Chinese Dark Chess";

	private Player p1;
	private Player p2;

  private JFrame gameUI;
  private JPanel container;

  public ChineseDarkChessGame() {
    System.out.println("Chinese");
  }

  public ChineseDarkChessGame(Player p1, Player p2) {
    setPlayer(p1, p2);
    initFrame();
  }

  private void initFrame() {
    gameUI = new JFrame(this.FRAME_TITLE);
    initCointainer();
    
    gameUI.setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);
    gameUI.setLocationRelativeTo(null);
    gameUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameUI.setResizable(false);
  }

  private void initCointainer() {
    container = new JPanel();

    gameUI.add(container);
  }

	private void setPlayer(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	private void generateChesses() {

	}

  @Override
  public void playGame() {
    this.gameUI.setVisible(true);
  }
}
