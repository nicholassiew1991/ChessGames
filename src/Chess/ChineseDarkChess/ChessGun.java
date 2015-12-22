package Chess.ChineseDarkChess;

public class ChessGun extends DarkChess {
  
  private final String IMG_RED_FILE_NAME = "GunR.jpg";
  private final String IMG_BLK_FILE_NAME = "GunB.jpg";
  
  public ChessGun(int team){
    super("Gun", team);
    super.setWeight(GUN_WIEGHT);
    super.setImagePath(IMG_RED_FILE_NAME, IMG_BLK_FILE_NAME);
  }
  
 
}
