package algorithm.leetcode._209_MinSubarray;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * 
 * Since the given array contains only positive integers, the subarray sum can
 * only increase by including more elements. Therefore, you don't have to
 * include more elements once the current subarray already has a sum large
 * enough. This gives the linear time complexity solution by maintaining a
 * minimum window with a two indices.
 * 
 * As to NLogN solution, logN immediately reminds you of binary search. In this
 * case, you cannot sort as the current order actually matters. How does one get
 * an ordered array then? Since all elements are positive, the cumulative sum
 * must be strictly increasing. Then, a subarray sum can expressed as the
 * difference between two cumulative sum. Hence, given a start index for the
 * cumulative sum array, the other end index can be searched using binary
 * search.
 * 
 * @author zluo
 *
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
	//return solveNLogN(s, nums);
	return solveNLogN(s, nums);
    }
    private int solveNLogN(int s, int[] nums) {
 	int[] sums = new int[nums.length + 1];
 	for (int i = 1; i < sums.length; i++){
 	    sums[i] = sums[i - 1] + nums[i - 1];
 	}
 	int minLen = Integer.MAX_VALUE;
 	for (int i = 0; i < sums.length; i++) {
 	    int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
 	    if (end == sums.length)
 		break;
 	    if (end - i < minLen)
 		minLen = end - i;
 	}
 	return minLen == Integer.MAX_VALUE ? 0 : minLen;
     }
     
     private int binarySearch(int lo, int hi, int key, int[] sums) {
 	while (lo <= hi) {
 	    int mid = (lo + hi) / 2;
 	    if (sums[mid] >= key) {
 		hi = mid - 1;
 	    } else {
 		lo = mid + 1;
 	    }
 	}
 	return lo;
     }
 /*   private int solveN(int s, int[] nums) {
	int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
	while (end < nums.length) {
	    while (end < nums.length && sum < s){
		sum += nums[end++];
	    }
	    if (sum < s) break;
	    while (start < end && sum >= s){
		sum -= nums[start++];
	    }
	    if (end - start + 1 < minLen){
		minLen = end - start + 1;
	    }
	}
	return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }*/
    
 /*   private int solveNLogN(int s, int[] nums) {
	int[] sums = new int[nums.length + 1];
	for (int i = 1; i < sums.length; i++){
	    sums[i] = sums[i - 1] + nums[i - 1];
	}
	int minLen = Integer.MAX_VALUE;
	for (int i = 0; i < sums.length; i++) {
	    int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
	    if (end == sums.length)
		break;
	    if (end - i < minLen)
		minLen = end - i;
	}
	return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    private int binarySearch(int lo, int hi, int key, int[] sums) {
	while (lo <= hi) {
	    int mid = (lo + hi) / 2;
	    if (sums[mid] >= key) {
		hi = mid - 1;
	    } else {
		lo = mid + 1;
	    }
	}
	return lo;
    }*/
    
 
    @Test
    public void test1() {
	assertEquals(2, minSubArrayLen(9, new int[]{1,1,3,2,3,4,2,3,4,5}));
    }
    
    @Test
    public void test2() {
	assertEquals(3, minSubArrayLen(9, new int[]{1,4,2,1,3,1,5,1}));
    }
}
