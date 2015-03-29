package algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class AU {
  public static void printRow(int[] a) {
    for(int i: a) {
      System.out.print(i + "\t|");
    }
    System.out.print("\n");
  }
  
  public int round(int i) {
    return i/2+i%2;
  }
  
  @Test
  public void testPrintRow() {
    int[] a ={3,4,12,40,50};
    int[] a1 ={8,4,15,40,50};
    printRow(a);
    printRow(a1);
  }
  
  @Test
  public void testMode() {
    assertEquals(3, 7/2);
    assertEquals(1, 7%2);
    
  }
}
