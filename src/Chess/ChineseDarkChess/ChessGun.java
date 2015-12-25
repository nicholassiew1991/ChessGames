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
  public ArrayList<Location> getClickableLocation(DarkChessBoard dcb, int x, int y) {
    
    ArrayList<Location> arr = new ArrayList();
    
    Location[][] locInfo = dcb.getBoardInfo();
    
    int numOfRows = dcb.getNumOfRows();
    int numOfCols = dcb.getNumOfCols();
    
    arr.add(new Location(x, y));
    
    if (x >= 2) {
      if (locInfo[x - 1][y].getChess() != null) {
        arr.add(new Location(x - 2, y));
      }
    }
    if (x <= ((numOfRows - 1) - 2)) {
      if (locInfo[x + 1][y].getChess() != null) {
          arr.add(new Location(x + 2, y));
      }
    }
    if (y >= 2) {
      if (locInfo[x][y - 1].getChess() != null) {
        arr.add(new Location(x, y - 2));
      }
    }
    if (y <= ((numOfCols - 1) - 2)) {
      if (locInfo[x][y + 1].getChess() != null) {
        arr.add(new Location(x, y + 2));
      }
    }
    
    return arr;
  }
 
}
