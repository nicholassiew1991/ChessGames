package Chess.ChineseDarkChess;

import Chess.Chess;
import Chess.Eatable;
import Chess.Movable;
import ChessBoard.ChessBoard;
import ChessBoard.DarkChessBoard;
import ChessBoard.Location;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class DarkChess extends Chess implements Eatable<DarkChess>, Movable<DarkChessBoard> {
  
  private final String IMG_PATH = "res/img/ChineseDarkChess/";
  //private final String IMG_PATH = "img/ChineseDarkChess/";
  private final String IMG_UNKNOWN = "unknown.jpg";
  
  public static final int TEAM_RED = 1;
  public static final int TEAM_BLACK = 2;
  
  public static final int STATUS_UNKNOWN = 1;
  public static final int STATUS_FLIPPED = 2;
  public static final int STATUS_DEATH = 3;
  
  public static final int EAT_SUCCESS = 0;
  public static final int EAT_FAILED = 1;
  public static final int EAT_FAILED_WEIGHT_SMALLER = 2;
  public static final int EAT_FAILED_GENERAL_EAT_SOLDIER = 3;
  public static final int EAT_FAILED_SAME_TEAM = 4;
  public static final int EAT_FAILED_UNKNOWN_CHESS = 5;

  // <editor-fold defaultstate="collapsed" desc="Weight constants declaration. ">
  protected static final int SOLDIER_WEIGHT = 1;
  protected static final int GUN_WEIGHT = 2;
  protected static final int HORSE_WEIGHT = 3;
  protected static final int CAR_WEIGHT = 4;
  protected static final int ELEPHANT_WEIGHT = 5;
  protected static final int SCHOLAR_WEIGHT = 6;
  protected static final int GENERAL_WEIGHT = 7;
  // </editor-fold>
  
  private HashMap<Integer, String> hmEatMessage;
  
  private String name;
  private String imageFileName = null;
  private int weight;
  private int status;

  public DarkChess(String name, int team) {
    this.setName(name);
    super.setSide(team);
    this.setStatus(STATUS_UNKNOWN);
    initEatMessage();
  }
  
  private void initEatMessage() {
    hmEatMessage = new HashMap();
    hmEatMessage.put(EAT_FAILED, "Eat Failed.");
    hmEatMessage.put(EAT_FAILED_WEIGHT_SMALLER, "Your weight is smaller.");
    hmEatMessage.put(EAT_FAILED_GENERAL_EAT_SOLDIER, "General can't eat soldier.");
    hmEatMessage.put(EAT_FAILED_SAME_TEAM, "Can't eat your team's chess.");
    hmEatMessage.put(EAT_FAILED_UNKNOWN_CHESS, "The chess hasn't flip yet.");
  }
  
  public String getEatMessage(int code) {
    return hmEatMessage.get(code);
  }
  
  protected void setImagePath(String red, String black) {
    imageFileName = (side == TEAM_RED ? red : black);
  }
  
  public ImageIcon getChessImage() {
    String path = null;
    
    if (status == STATUS_UNKNOWN) {
      path = this.IMG_PATH  + this.IMG_UNKNOWN;
    }
    else if (status == STATUS_FLIPPED){
      path = this.IMG_PATH + this.imageFileName;
    }
    return new ImageIcon(path);
  }
  
  public void setStatus(int status) {
    this.status = status;
  }
  
  public int getStatus() {
    return this.status;
  }

  protected void setWeight(int weight) {
    this.weight = weight;
  }

  public int getWeight() {
    return this.weight;
  }
  
  private void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  
  /**
   * Get the clickable location.
   * @param dcb DarkChesBoard object
   * @param x - Row of the clicked button.
   * @param y - Column of the clicked button.
   * @return The arraylist that store the button that can click.
   */
  public ArrayList<Location> getClickableLocation(DarkChessBoard dcb, int x, int y) {
    ArrayList<Location> arr = new ArrayList();
    
    arr.add(new Location(x, y));
    
    if (x != 0) {
      arr.add(new Location(x - 1, y));
    }
    if (x != dcb.getNumOfRows() - 1) {
      arr.add(new Location(x + 1, y));
    }
    if (y != 0) {
      arr.add(new Location(x, y - 1));
    }
    if (y != dcb.getNumOfCols() - 1) {
      arr.add(new Location(x, y + 1));
    }
    return arr;
  }
   
  @Override
  public int eat(DarkChess c) {
    int targetWeight = c.getWeight();
    
    if (this.side == c.getSide()) {
      return EAT_FAILED_SAME_TEAM;
    }
    else if (c.getStatus() == DarkChess.STATUS_UNKNOWN) {
      return EAT_FAILED_UNKNOWN_CHESS;
    }
    else if (weight == GENERAL_WEIGHT && targetWeight == SOLDIER_WEIGHT) {
      return EAT_FAILED_GENERAL_EAT_SOLDIER;
    }
    else if (weight == GUN_WEIGHT ) {
      return EAT_SUCCESS;
    }
    else if (weight == SOLDIER_WEIGHT && targetWeight == GENERAL_WEIGHT) {
      return EAT_SUCCESS;
    }
    else if (weight >= targetWeight) {
      return EAT_SUCCESS;
    }
    else if (weight < targetWeight) {
      return EAT_FAILED_WEIGHT_SMALLER;
    }
    else {
      return EAT_FAILED;
    }
  }

  @Override
  public void move(DarkChessBoard cb, Location src, Location dest) {
    
    DarkChess srcChess = (DarkChess) cb.getChessOnLoc(src.getX(), src.getY());
    
    cb.setChessOnLoc(srcChess, dest.getX(), dest.getY());
    cb.setChessOnLoc(null, src.getX(), src.getY());
  }
  
  @Override
  public String toString() {
    return String.format("Name: %s\nTeam: %d\nWeight: %d\n", name, side, weight);
  }

}
