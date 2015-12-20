package Chess.ChineseDarkChess;

public class ChessHorse extends DarkChess {

  private final String IMG_RED_FILE_NAME = "HorseR.jpg";
  private final String IMG_BLK_FILE_NAME = "HorseB.jpg";

  public ChessHorse(int team){
    super("Horse", team);
    super.setWeight(HORSE_WEIGHT);
    super.setImagePath(IMG_RED_FILE_NAME, IMG_BLK_FILE_NAME);
  }
}
