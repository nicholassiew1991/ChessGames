package Chess.ChessMaker;

import Chess.Chess;
import Chess.ChineseDarkChess.*;

public class DarkChessMaker extends ChessMaker {

  public Chess createChess(int chesstype, int team) {

    switch (chesstype) {
      case 1:
        ChessGeneral general = new ChessGeneral(team);
        return general;
      case 2:
        ChessScholar scholar = new ChessScholar(team);
        return scholar;
      case 3:
        ChessElephant elephant = new ChessElephant(team);
        return elephant;
      case 4:
        ChessCar car = new ChessCar(team);
        return car;
      case 5:
        ChessHorse horse = new ChessHorse(team);
        return horse;
      case 6:
        ChessGun gun = new ChessGun(team);
        return gun;
      case 7:
        ChessSolidier solidier = new ChessSolidier(team);
        return solidier;
      default:
        break;
    }

    return null;
  }
}
