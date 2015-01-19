package sort.myImpl;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMergeSort{
  
  int a[]= {3,6,2};
  int a1[]= {6,3,2};
  int a2[]= {3,6,2,5,9,7,1,8,0,4};
//  int a2[]= {3,6,2,5,9,7,1,8,0,4};
  
  @Test
  public void testMergeSort() {
   test(a1);
   System.out.println("--------------------");
   test(a2);
  }

  void test(int[] a) {
    MergeSortAlgorithm qSort= new MergeSortAlgorithm();
    qSort.sort(a);
    for(int i=0; i<a.length; i++) {
      System.out.println(a[i]);
//      assertEquals(i,a[i]);
    }
  }
  
}
