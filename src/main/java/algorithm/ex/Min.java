package algorithm.ex;

import static org.junit.Assert.*;

import org.junit.Test;

public class Min {
  public int min(int[] a) {
    return helper(0, a.length-1,a);
  }
  
  int helper(int s, int e, int[] a) {
    if (s==e) return a[s];
    
    return Math.min(helper(s,(s+e)/2, a), helper((s+e)/2+1,e, a));
  }
  
  @Test
  public void test() {
    assertEquals(3, min(new int[] {4,5,3,7,8}));
    
    assertEquals(1, min(new int[] {4,5,3,7,1,9,8}));
    
  }
}
