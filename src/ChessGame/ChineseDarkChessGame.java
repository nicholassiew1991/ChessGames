package ChessGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChineseDarkChessGame extends ChessGame {

  private final int FRAME_WIDTH = 600;
  private final int FRAME_HEIGHT = 300;

  private final String FRAME_TITLE = "Chinese Dark Chess";

	private Player p1;
	private Player p2;
  
  private JPanel container;

  public ChineseDarkChessGame(Player p1, Player p2) {
    initFrame();
    setPlayer(p1, p2);
  }

  private void initFrame() {
    super.initFrame(FRAME_TITLE);
    initCointainer();
    cgFrame.setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);
    cgFrame.setLocationRelativeTo(null);
  }

  private void initCointainer() {
    container = new JPanel();

    cgFrame.add(container);
  }

	private void setPlayer(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	private void generateChesses() {

	}
}
