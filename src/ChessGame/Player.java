package ChessGame;

import Chess.ChineseDarkChess.DarkChess;

public class Player {

	private String name;
  private int side;

	public Player(String name, int side) {
		this.setName(name);
    this.side = side;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
  
  public int getSide() {
    return this.side;
  }
  
  @Override
  public String toString() {
    String sideColor = (this.side == DarkChess.TEAM_RED ? "Red" : "Black");
    return String.format("%s Team: %s", this.name, sideColor);
  }
}
