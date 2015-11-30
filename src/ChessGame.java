public abstract class ChessGame {

	private String strPlayerTurn = null;

	public String getPlayerTurn() {
		return strPlayerTurn;
	}

	public void setPlayerTurn(String strPlayerTurn) {
		this.strPlayerTurn = strPlayerTurn;
	}
}

class ChineseDarkChessGame extends ChessGame {
  
  public static final int SIDE_RED = 1;
  public static final int SIDE_BLACK = 2;

	private Player p1;
	private Player p2;

	public void setPlayer(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	private void generateChesses() {

	}
}
