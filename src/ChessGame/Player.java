package ChessGame;

import Chess.ChineseDarkChess.DarkChess;

public class Player {
    private String name;
    private int side;
    private int toatalchess;

	public Player(String name, int side) {
		this.setName(name);
                this.side = side;
                this.toatalchess = 16;
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
        
        public void setTotalChess(int total){
            this.toatalchess = total;
        }
        
        public int getTotalChess(){
            return this.toatalchess;
        }
        @Override
        public String toString() {
            String sideColor = (this.side == DarkChess.TEAM_RED ? "Red" : "Black");
            return String.format("%s Team: %s", this.name, sideColor);
        }
}
