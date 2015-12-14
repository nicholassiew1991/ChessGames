package Chess;

public interface Eatable<T extends Chess> {
  public void eat(T c);
}