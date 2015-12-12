
import ChessGame.ChessGame;
import ChessGame.ChineseDarkChessGame;

public class ComboBoxItemGames {

  private String key;
  private ChessGame value;
  
  public ComboBoxItemGames(String key, ChessGame value) {
    this.key = key;
    this.value = value;
  }
  
  public String getKey() {
    return key;
  }

  public ChessGame getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return getKey();
  }
}