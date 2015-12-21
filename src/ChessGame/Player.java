package ChessGame;

public class Player {

	private String name;

	public Player(String name) {
		this.setName(name);
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
  
  @Override
  public String toString() {
    return this.name;
  }
}
