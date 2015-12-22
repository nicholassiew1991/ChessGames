package Chess;

public interface Eatable<T extends Chess> {
  public boolean eat(T c);
}