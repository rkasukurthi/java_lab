package algorithm.maxsubsum;

/*
 *    Java Program to Implement Kadane Algorithm
 */
 
import java.util.Scanner;
 
/* Class kadane */
public class Kadane
{
    int startIndex=0;
    int endIndex=0;
    
    int startIndexSofar=0;
    int endIndexSofar=0;
        
    
    /* Function to largest continuous sum */
    public int maxSequenceSum(int[] arr)
    {        
        int maxSoFar = arr[0], maxEndingHere = arr[0];
 
        for (int i = 1; i < arr.length; i++)
        {
            /* calculate maxEndingHere */
            if (maxEndingHere < 0){
            	maxEndingHere = arr[i];
            	startIndex=i;
            	endIndex=i;
            }
            else
            {
                maxEndingHere += arr[i];
                endIndex=i;
            }    
            /* calculate maxSoFar */
            if (maxEndingHere >= maxSoFar){
            	maxSoFar = maxEndingHere;
            	startIndexSofar=startIndex;
            	endIndexSofar=endIndex;
            }
        }
        return maxSoFar;
    }    
    
    
    /* Main function */
    public static void main (String[] args) 
    {
    	Kadane k = new Kadane();
        int[] arr ={1,1,-3,4,-1,2,1,-5,4};
        int sum = k.maxSequenceSum(arr);
        System.out.println("\nMaximum Sequence sum [" + k.startIndexSofar + "," + k.endIndexSofar + "] = "+ sum );
 
    }
}