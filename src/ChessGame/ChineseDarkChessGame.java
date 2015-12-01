package ChessGame;

import javax.swing.JFrame;

public class ChineseDarkChessGame extends ChessGame {
  
  public static final int SIDE_RED = 1;
  public static final int SIDE_BLACK = 2;

	private Player p1;
	private Player p2;
  
  private JFrame gameUI;
  
  public ChineseDarkChessGame() {
    System.out.println("Chinese");
  }
  
  public ChineseDarkChessGame(Player p1, Player p2) {
    setPlayer(p1, p1);
  }

	public void setPlayer(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	private void generateChesses() {

	}

  @Override
  public void playGame() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void startGame() {
    this.gameUI.setVisible(true);
  }
}
