package Chess.ChineseDarkChess;

public class ChessSoldier extends DarkChess {
    public ChessSoldier(int team){
      super("Soldier", team);
      super.setWeight(SOLDIER_WEIGHT);
    }
}
