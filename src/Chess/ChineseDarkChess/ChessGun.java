package Chess.ChineseDarkChess;

public class ChessGun extends DarkChess {
  public ChessGun(int team){
      super(team);
      super.setWeight(GUN_WIEGHT);
  }
  
  @Override
  public void eat(DarkChess c) {
    
  }
}
