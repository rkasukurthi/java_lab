package algorithm.sort.myImpl;

/**
 * QuickSort
 * The thought behind QuickSort is divided and conquer.
 * and  binary search.
 * @author zluo
 *
 */
public class QSortAlgorithm implements SortAlgorithm{

  public void sort(int[] a) {
    sort(a, 0, a.length-1);
  }
  
  void sort(int[] a, int lo0, int hi0) {
    int lo=lo0, hi=hi0;
    if (lo >= hi) return;
    
    if (lo== hi-1) {
      if(a[lo]>a[hi]) swap(a, lo, hi);
      return;
    }
    // pick up a pivot and get out of the way
    int pivot=a[(lo+hi)/2];
    a[(lo+hi)/2]=a[hi];
    a[hi]=pivot;
    
    while(lo < hi) {
      while(a[lo] <= pivot && lo<hi) {
        lo++;
      }
      while(pivot<=a[hi] && lo<hi) {
        hi--;
      }
      
      if (lo<hi) {
        swap(a, lo, hi);
      }
    }
    
    //put the median in the "center" of the list
    a[hi0]=a[hi];
    a[hi]=pivot;    
    
    sort(a, lo0, lo-1);
    sort(a, hi+1, hi0);
  }
  
  void swap(int[] a, int lo, int hi)
  {
    int t=a[lo];
    a[lo]=a[hi];
    a[hi]=t;
  }
}
