package Chess.ChineseDarkChess;

import ChessBoard.DarkChessBoard;
import ChessBoard.Location;
import java.util.ArrayList;

public class ChessGun extends DarkChess {
  
  private final String IMG_RED_FILE_NAME = "GunR.jpg";
  private final String IMG_BLK_FILE_NAME = "GunB.jpg";
  
  public ChessGun(int team){
    super("Gun", team);
    super.setWeight(GUN_WEIGHT);
    super.setImagePath(IMG_RED_FILE_NAME, IMG_BLK_FILE_NAME);
  }
  
  @Override
  public ArrayList<Location> getClickableLocation(DarkChessBoard dcb, int currentX, int currentY) {
    ArrayList<Location> arr = new ArrayList();
    
    int numOfRows = dcb.getNumOfRows();
    int numOfCols = dcb.getNumOfCols();
    
    arr.add(new Location(currentX, currentY));
    
    if (currentX >= 2) {
      arr.add(new Location(currentX - 2, currentY));
    }
    if (currentX <= ((numOfRows - 1) - 2)) {
      arr.add(new Location(currentX + 2, currentY));
    }
    if (currentY >= 2) {
      arr.add(new Location(currentX, currentY - 2));
    }
    if (currentY <= ((numOfCols - 1) - 2)) {
      arr.add(new Location(currentX, currentY + 2));
    }
    
    return arr;
  }
 
}
