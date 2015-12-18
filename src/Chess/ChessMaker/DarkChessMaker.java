package Chess.ChessMaker;

import Chess.Chess;
import Chess.ChineseDarkChess.*;

public class DarkChessMaker extends ChessMaker {

  public final byte GENERAL = 1;
  public final byte SCHOLAR = 2;
  public final byte ELEPHANT = 3;
  public final byte CAR = 4;
  public final byte HORSE = 5;
  public final byte GUN = 6;
  public final byte SOLDIER = 7;

  @Override
  public DarkChess createChess(int chesstype, int team) {

    switch (chesstype) {
      case GENERAL:
        return new ChessGeneral(team);
      case SCHOLAR:
        return new ChessScholar(team);
      case ELEPHANT:
        return new ChessElephant(team);
      case CAR:
        return new ChessCar(team);
      case HORSE:
        return new ChessHorse(team);
      case GUN:
        return new ChessGun(team);
      case SOLDIER:
        return new ChessSoldier(team);
      default:
        return null;
    }
  }
}
