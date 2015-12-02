package ChessGame;

import javax.swing.JFrame;

public abstract class ChessGame {
  
  protected JFrame chessGameUI;

	private String strPlayerTurn = null;

	public String getPlayerTurn() {
		return strPlayerTurn;
	}

	public void setPlayerTurn(String strPlayerTurn) {
		this.strPlayerTurn = strPlayerTurn;
	}
  
  public abstract void playGame();
}