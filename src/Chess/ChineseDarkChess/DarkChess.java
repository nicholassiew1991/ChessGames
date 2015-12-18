package Chess.ChineseDarkChess;

import Chess.Chess;
import Chess.Eatable;
import Chess.Movable;

public class DarkChess extends Chess implements Eatable<DarkChess>, Movable {

  public static final int SOLDIER_WEIGHT = 1;
  public static final int GUN_WIEGHT = 2;
  public static final int HORSE_WEIGHT = 3;
  public static final int CAR_WEIGHT = 4;
  public static final int ELEPHANT_WEIGHT = 5;
  public static final int SCHOLAR_WEIGHT = 6;
  public static final int GENERAL_WEIGHT = 7;

  public static final int MAXWEIGHT = 6;
  public static final int MINWEIGHT = 0;
  
  public static final int TEAM_RED = 1;
  public static final int TEAM_BLACK = 2;

  private final String IMG_PATH = "res/img/ChineseDarkChess/";

  private String name;
  private int team;
  private int weight;
  private int movedistance;
  private int status;

  public DarkChess(String name, int team) {
    this.setName(name);
    this.setTeam(team);
  }

  @Override
  public void eat(DarkChess c) {
    int targetWeight = c.getWeight();

    if (weight == SOLDIER_WEIGHT && targetWeight == GENERAL_WEIGHT) {
      // eat
    }
    else if (weight >= targetWeight) {
      //eat
    }
    else {
      // Can't eat
    }
  }

  public boolean invertChess() {
    return true;
  }

  protected void setWeight(int weight) {
    if (checkWeight(weight)) {
      this.weight = weight;
    }
  }

  public int getWeight() {
    return this.weight;
  }
  
  private boolean checkWeight(int weight) {
    if (weight >= MINWEIGHT && weight < MAXWEIGHT) {
      return true;
    } else {
      return false;
    }
  }
  
  private void setName(String name) {
    this.name = name;
  }
  
  public String getName(String nmae) {
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

  @Override
  public void move() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
