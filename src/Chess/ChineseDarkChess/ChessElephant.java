package Chess.ChineseDarkChess;

public class ChessElephant extends DarkChess {
  
  private final String IMG_RED_FILE_NAME = "ElephantR.jpg";
  private final String IMG_BLK_FILE_NAME = "ElephantB.jpg";

  public ChessElephant(int team){
    super("Elephant", team);
    super.setWeight(ELEPHANT_WEIGHT);
    super.setImagePath(IMG_RED_FILE_NAME, IMG_BLK_FILE_NAME);
  }
}
