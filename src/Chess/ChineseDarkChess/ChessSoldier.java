package Chess.ChineseDarkChess;

public class ChessSoldier extends DarkChess {

  private final String IMG_RED_FILE_NAME = "SoldierR.jpg";
  private final String IMG_BLK_FILE_NAME = "SoldierB.jpg";

  public ChessSoldier(int team){
    super("Soldier", team);
    super.setWeight(SOLDIER_WEIGHT);
    super.setImagePath(IMG_RED_FILE_NAME, IMG_BLK_FILE_NAME);
  }
}
