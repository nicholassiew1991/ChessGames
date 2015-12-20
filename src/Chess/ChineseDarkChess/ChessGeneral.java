package Chess.ChineseDarkChess;

public class ChessGeneral extends DarkChess {

  private final String IMG_RED_FILE_NAME = "GeneralR.jpg";
  private final String IMG_BLK_FILE_NAME = "GeneralB.jpg";

  public ChessGeneral(int team) {
    super("General", team);
    super.setWeight(GENERAL_WEIGHT);
    super.setImagePath(IMG_RED_FILE_NAME, IMG_BLK_FILE_NAME);
  }

}
