package Utilities;

import java.util.Random;

public class Util {
  
  public static void sufflingArray(Object[] o) {
    int n = o.length;
    Random random = new Random();
    random.nextInt();
    for (int i = 0; i < n; i++) {
      int change = i + random.nextInt(n - i);
      swap(o, i, change);
    }
  }
  
  public static void swap(Object[] o, int a, int b) {
    Object temp = o[a];
    o[a] = o[b];
    o[b] = temp;
  }
}
