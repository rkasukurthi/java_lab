package algorithm;

/*
 *    Java Program to Implement Kadane Algorithm
 */
 
import java.util.Scanner;
 
/* Class kadane */
public class Kadane
{
    /* Function to largest continuous sum */
    public int maxSequenceSum(int[] arr)
    {        
        int maxSoFar = arr[0], maxEndingHere = arr[0];
 
        for (int i = 1; i < arr.length; i++)
        {
            /* calculate maxEndingHere */
            if (maxEndingHere < 0)
                maxEndingHere = arr[i];
            else
                maxEndingHere += arr[i];
 
            /* calculate maxSoFar */
            if (maxEndingHere >= maxSoFar)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }    
    
    /**
     * Return maximum subsequence indexs
     * @param arr
     * @return
     */
    public void maxSequence(int[] arr)
    {        
        int maxSoFar = arr[0], maxEndingHere = arr[0];
 
        for (int i = 1; i < arr.length; i++)
        {
            /* calculate maxEndingHere */
            if (maxEndingHere < 0)
                maxEndingHere = arr[i];
            else
                maxEndingHere += arr[i];
 
            /* calculate maxSoFar */
            if (maxEndingHere >= maxSoFar)
                maxSoFar = maxEndingHere;
        }
//        return maxSoFar;
    }    
    
    /* Main function */
    public static void main (String[] args) 
    {
    	Kadane k = new Kadane();
        int[] arr ={-2,1,-3,4,-1,2,1,-5,4};
        int sum = k.maxSequenceSum(arr);
        System.out.println("\nMaximum Sequence sum = "+ sum);
 
    }
}