package algorithm.sort.myImpl;

/**
 * Heapsort is one of the best general-purpose sorting algorithms, a comparison sort and part of the
 * selection sort family. Although somewhat slower in practice on most machines than a good
 * implementation of quicksort, it has the advantages of worst-case O(n log n) runtime and being an
 * in-place algorithm. Heapsort is not a stable sort.
 * 
 * @author zluo
 * 
 */
public class HeapSortAlgorithm implements SortAlgorithm {
  private static int[] a;
  private static int n;
  private static int left;
  private static int right;
  private static int largest;

  
  public static void buildheap(int []a){
      n=a.length-1;
      for(int i=n/2;i>=0;i--){
          maxheap(a,i);
      }
  }
  
  public static void maxheap(int[] a, int i){ 
      left=2*i;
      right=2*i+1;
      if(left <= n && a[left] > a[i]){
          largest=left;
      }
      else{
          largest=i;
      }
      
      if(right <= n && a[right] > a[largest]){
          largest=right;
      }
      if(largest!=i){
          exchange(a,i,largest);
          maxheap(a, largest);
      }
  }
  
  public static void exchange(int[] a,int i, int j){
      int t=a[i];
      a[i]=a[j];
      a[j]=t; 
      }
  
  public  void sort(int []a){
      buildheap(a);
      for(int i=n;i>0;i--){
          exchange(a,0, i);
          n=n-1;
          maxheap(a, 0);
      }
  }
  
}
