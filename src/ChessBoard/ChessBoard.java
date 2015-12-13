package ChessBoard;

public class ChessBoard
{
       private int LocX, LocY;
       public void setLocation(int x, int y)
       {
              this.LocX = x;
              this.LocY = y;
       }
       public int getLocationX()
       {
              return this.LocX;
       }
       public int getLocationY()
       {
              return this.LocY;
       }
}
