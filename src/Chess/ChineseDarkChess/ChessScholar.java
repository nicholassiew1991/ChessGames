package Chess.ChineseDarkChess;

public class ChessScholar extends DarkChess {

  private final String IMG_RED_FILE_NAME = "ScholarR.jpg";
  private final String IMG_BLK_FILE_NAME = "ScholarB.jpg";

  public ChessScholar(int team){
    super("Scholar", team);
    super.setWeight(SCHOLAR_WEIGHT);
    super.setImagePath(IMG_RED_FILE_NAME, IMG_BLK_FILE_NAME);
  }
}
