package algorithm;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class BigONotation {
    
    
    public void quickSort(int[] a){
	sort(a, 0, a.length-1);
    }
    
    private void sort(int[] a, int l0, int h0){
	if (l0 ==h0-1){
	   if (a[l0]>a[h0]){
	       swap(a, l0, h0);
	   }
	   return;
	}
	
	int l=l0;
	int h=h0;
	
	int pivot = a[(l+h)/2];
	
	while(l<h){
	    while (a[l]<pivot && l<h){
		l++;
	    }
	    while(pivot <= a[h] && l<h){
		h--;
	    }
	    
	}
	
	
    }
    
    private void swap(int[] a, int i, int j){
	int t= a[i];
	a[i]=a[j];
	a[j]=t;
    }
    
    
    int[] generateArray(int n){
	int[] a = new int[n];
	Random random = new Random();
	for(int i=0; i<n; i++){
	    a[i]=random.nextInt();
	}
	return a;
    }
    
    @Test  //O(n)
    public void testGenerate(){
	int[] a = generateArray(1000);
	System.out.println("O(n) : " + Arrays.toString(a));
    }
}
