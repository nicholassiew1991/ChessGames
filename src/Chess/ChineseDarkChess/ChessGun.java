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
  
  /**
   * Get the clickable location.
   * @param dcb - DarkChesBoard object
   * @param x - Row of the clicked button.
   * @param y - Column of the clicked button.
   * @return - The arraylist that store the button that can click.
   */
  @Override
  public ArrayList<Location> getClickableLocation(DarkChessBoard dcb, int x, int y) {
    
    ArrayList<Location> arr = new ArrayList();
    
    int numOfRows = dcb.getNumOfRows();
    int numOfCols = dcb.getNumOfCols();
    
    arr.add(new Location(x, y));
    
    /* Move actions. */
    if (x != (numOfRows - 1) && dcb.getChessOnLoc(x + 1, y) == null) {
      arr.add(new Location(x + 1, y));
    }
    if (x != 0 && dcb.getChessOnLoc(x - 1, y) == null) {
      arr.add(new Location(x - 1, y));
    }
    if (y != (numOfCols - 1) && dcb.getChessOnLoc(x, y + 1) == null) {
      arr.add(new Location(x, y + 1));
    }
    if (y != 0 && dcb.getChessOnLoc(x, y - 1) == null) {
      arr.add(new Location(x, y - 1));
    }
    
    /* Eat actions. */
    for (int a = x + 1, chessCnt = 0; a < numOfRows; a++) {
      /* Bottom of the chess */
      
      if (dcb.getChessOnLoc(a, y) != null) {
        chessCnt++;
      }
      if (chessCnt == 2) {
        arr.add(new Location(a, y));
      }
    }
    for (int a = x - 1, chessCnt = 0; a >= 0; a--) {
      /* Top of the chess */
      
      if (dcb.getChessOnLoc(a, y) != null) {
        chessCnt++;
      }
      if (chessCnt == 2) {
        arr.add(new Location(a, y));
      }
    }
    for (int a = y + 1, chessCnt = 0; a < numOfCols; a++) {
      /* Right of the chess */
      
      if (dcb.getChessOnLoc(x, a) != null) {
        chessCnt++;
      }
      if (chessCnt == 2) {
        arr.add(new Location(x, a));
      }
    }
    for (int a = y - 1, chessCnt = 0; a >= 0; a--) {
      /* Left of the chess */
      
      if (dcb.getChessOnLoc(x, a) != null) {
        chessCnt++;
      }
      if (chessCnt == 2) {
        arr.add(new Location(x, a));
      }
    }
    
    return arr;
  }
 
}
