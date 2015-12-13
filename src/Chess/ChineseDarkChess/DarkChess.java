package Chess.ChineseDarkChess;

import Chess.Chess;
import Chess.Eatable;
import Chess.Movable;

public class DarkChess extends Chess implements Eatable, Movable {
  
  public static final int SOLDIER_WEIGHT = 1;
  public static final int GUN_WIEGHT = 2;
  public static final int HORSE_WEIGHT = 3;  
  public static final int CAR_WEIGHT = 4;
  public static final int ELEPHANT_WEIGHT = 5;
  public static final int SCHOLAR_WEIGHT = 6;
  public static final int GENERAL_WEIGHT = 7;
  
  
  public static final int MAXWEIGHT = 6;
  public static final int MINWEIGHT = 0;
  public static final int REDTEAM = 0;
  public static final int BLACKTEAM = 1;

  private int team;
  private String darkchessname;
  private int weight;
  private int movedistance;
  private int status;
  
  public DarkChess() {
    
  }
  
  public DarkChess(int weight) {
    this.setWeight(weight);
  }
  
  @Override
  public void eat(Chess c) {
    DarkChess dc = (DarkChess) c;
    
    if (weight == SOLDIER_WEIGHT && dc.getWeight() == GENERAL_WEIGHT) {
      // eat
    }
    else if (weight > dc.getWeight()) {
      //eat
    }
    else {
      // Can't eat
    }
  }

  public DarkChess(String chesstype, String darkchessname, int team, int weight, int movedistance) {
  }

  public boolean invertChess() {
    return true;
  }

  protected void setWeight(int weight) {
    if (checkWeight(weight)) {
      this.weight = weight;
      //return true;
    }
    //else 
    // return false;
  }

  public boolean checkWeight(int weight) {
    if (weight >= MINWEIGHT && weight < MAXWEIGHT) {
      return true;
    } else {
      return false;
    }
  }

  public int getWeight() {
    return this.weight;
  }

  public boolean setTeam(int team) {
    if (team == REDTEAM) {
      this.team = 0;
      return true;
    } else if (team == BLACKTEAM) {
      this.team = 1;
      return true;
    } else {
      return false;
    }
  }
  
  public void move() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
