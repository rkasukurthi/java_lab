package sort.myImpl;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQsort{
  
  int a[]= {3,6,2};
  int a1[]= {6,3,2};
  int a2[]= {3,6,2,5,9,7,1,8,0,4};
//  int a2[]= {3,6,2,5,9,7,1,8,0,4};
  
  @Test
  public void testQSort() {
   test(a1);
   System.out.println("--------------------");
 //  test(a2);
  }

  void test(int[] a) {
    QSortAlgorithm qSort= new QSortAlgorithm();
    qSort.sort(a);
    for(int i=0; i<a.length; i++) {
      System.out.println(a[i]);
//      assertEquals(i,a[i]);
    }
  }
  
  @Test
  public void testInsertSort() {
	    InsertSortAlgorithm insertSort= new InsertSortAlgorithm();
	    insertSort.sort(a2);
	    for(int i=0; i<a.length; i++) {
	      System.out.println(a2[i]);
	      assertEquals(i,a2[i]);
	    }
	  }
  
}
