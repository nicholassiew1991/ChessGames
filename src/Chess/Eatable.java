package Chess;

public interface Eatable<T extends Chess> {
  public int eat(T c);
}