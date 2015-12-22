package Chess.ChineseDarkChess;

import Chess.Chess;
import Chess.Eatable;
import Chess.Movable;
import ChessBoard.Location;
import javax.swing.ImageIcon;

public class DarkChess extends Chess implements Eatable<DarkChess>, Movable {
  
  private final String IMG_PATH = "res/img/ChineseDarkChess/";
  private final String IMG_UNKNOWN = "unknown.jpg";
  
  public static final int TEAM_RED = 1;
  public static final int TEAM_BLACK = 2;
  
  public static final int STATUS_UNKNOWN = 1;
  public static final int STATUS_FLIPPED = 2;
  public static final int STATUS_DEATH = 3;

  protected static final int SOLDIER_WEIGHT = 1;
  protected static final int GUN_WIEGHT = 2;
  protected static final int HORSE_WEIGHT = 3;
  protected static final int CAR_WEIGHT = 4;
  protected static final int ELEPHANT_WEIGHT = 5;
  protected static final int SCHOLAR_WEIGHT = 6;
  protected static final int GENERAL_WEIGHT = 7;
  
  private String name;
  private String imageFileName = null;
  private int team;
  private int weight;
  private int status;

  public DarkChess(String name, int team) {
    this.setName(name);
    this.setTeam(team);
    this.setStatus(STATUS_UNKNOWN);
  }
  
  protected void setImagePath(String red, String black) {
    imageFileName = (team == TEAM_RED ? red : black);
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

  @Override
  public boolean eat(DarkChess c) {
    int targetWeight = c.getWeight();
    
    if (this.team == c.getTeam()) {
      return false;
      // can't eat
    }
    else if (c.getStatus() == DarkChess.STATUS_UNKNOWN) {
      return false;
      // can't eat
    }
    else if (weight == SOLDIER_WEIGHT && targetWeight == GENERAL_WEIGHT) {
      return true;
      // eat
    }
    else if (weight >= targetWeight) {
      return true;
      //eat
    }
    else {
      return false;
      // Can't eat
    }
  }

  public boolean invertChess() {
    return true;
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

  private boolean setTeam(int team) {
    if (team == TEAM_RED || team == TEAM_BLACK) {
      this.team = team;
      return true;
    }
    else {
      return false;
    }
  }
  
  public int getTeam() {
    return team;
  }
   
  @Override
  public String toString() {
    return String.format("Name: %s\nTeam: %d\nWeight: %d\n", name, team, weight);
  }

    @Override
    public boolean move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
