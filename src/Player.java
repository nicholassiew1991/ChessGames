public class Player {

	public static final char SIDE_RED = 1;
	public static final char SIDE_BLACK = 2;

	private String name;
	private char side;


	public Player(String name, char side) {
		this.setName(name);
		this.setSide(side);
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getName(String name) {
		return this.name;
	}

	private void setSide(char side) {
		this.side = side;
	}

	public char getSide() {
		return this.side;
	}
}
