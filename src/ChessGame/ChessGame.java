package ChessGame;

public abstract class ChessGame {

	private String strPlayerTurn = null;

	public String getPlayerTurn() {
		return strPlayerTurn;
	}

	public void setPlayerTurn(String strPlayerTurn) {
		this.strPlayerTurn = strPlayerTurn;
	}
  
  public abstract void startGame();
  public abstract void playGame();
}