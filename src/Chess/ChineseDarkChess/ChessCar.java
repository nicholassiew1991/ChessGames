package Chess.ChineseDarkChess;

public class ChessCar extends DarkChess {
  
  private final String IMG_RED_FILE_NAME = "CarR.jpg";
  private final String IMG_BLK_FILE_NAME = "CarB.jpg";

  public ChessCar(int team){
    super("Car", team);
    super.setWeight(CAR_WEIGHT);
    super.setImagePath(IMG_RED_FILE_NAME, IMG_BLK_FILE_NAME);
  }
}
