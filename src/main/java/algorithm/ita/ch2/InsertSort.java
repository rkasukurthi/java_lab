package algorithm.ita.ch2;

import org.junit.Test;

/**
 * Pseudocode
 * <code>
 * for j=2 to A.length
 *   key=A[j]
 *   // Insert A[j] into the sorted sequence A[1 .. j-1] 
 *   i=j-1
 *   while i >0 and A[i]>key
 *     A[i+1]=A[i]
 *     i= i-1
 *   A[i+1]=key
 * </code>  
 * 
 * 
 * 
 * @author zluo
 */
public class InsertSort {
    
    int[] sort(int[] a){
	return a;
    }
    
    @Test
    public void test(){
    }
}
