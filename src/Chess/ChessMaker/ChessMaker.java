package Chess.ChessMaker;

import Chess.Chess;
import Chess.ChineseDarkChess.DarkChess;

public abstract class ChessMaker { 
  public abstract Chess createChess(int chesstype,int team);
}
