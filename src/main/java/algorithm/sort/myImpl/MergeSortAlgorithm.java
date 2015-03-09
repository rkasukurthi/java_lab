package algorithm.sort.myImpl;

public class MergeSortAlgorithm implements SortAlgorithm{

  private int[] a;
  private int[] t;
  
  public void sort(int[] a) {
    this.a=a;
    this.t=new int[a.length];
    mergeSort(0, a.length-1);
  }

  void mergeSort(int lo, int hi) {
    // check if low is smaller than high
    if(lo < hi) {
      int mid = lo +(hi-lo)/2;
      mergeSort(lo, mid);
      mergeSort(mid+1, hi);
      
      //combine both 
      
      merge(lo, mid, hi);
    }
  }
    
    void merge(int lo, int mid, int hi) {
      //copy both parts into the helper
      for(int i=lo; i<= hi; i++) {
        t[i]=a[i];
      }
      
      int i=lo;
      int j= mid+1;
      int k=lo;
      while(i<=mid && j<=hi) {
        if (t[i] <=t[j]) {
          a[k]=t[i];
          i++;
        }
        else {
          a[k]=t[j];
          j++;
        }
        k++;
      }
  
    // copy the rest of the left side of the array into the target array
    while (i<= mid) {
      a[k]=t[i];
      k++;
      i++;
    }
    }
}
