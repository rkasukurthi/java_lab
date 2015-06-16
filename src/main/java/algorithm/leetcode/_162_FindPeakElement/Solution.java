package algorithm.leetcode._162_FindPeakElement;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * Your solution should be in logarithmic complexity.
 *
 * Solution:
 *
 * This problem is similar to Local Minimum. And according to the given
 * condition, num[i] != num[i+1], there must exist a O(logN) solution. So we use
 * binary search for this problem.
 * 
 * If num[i-1] < num[i] > num[i+1], then num[i] is peak If num[i-1] < num[i] <
 * num[i+1], then num[i+1...n-1] must contains a peak If num[i-1] > num[i] >
 * num[i+1], then num[0...i-1] must contains a peak If num[i-1] > num[i] <
 * num[i+1], then both sides have peak (n is num.length) Here is the code
 *
 *
 */
public class Solution {
    public int findPeakElement(int[] nums) {
	return find(nums, 0, nums.length-1);
    }
    
    int find(int[] nums, int l, int r){
	if (l==r) return l;
	if (l+1==r) {
	    if (nums[l]>nums[r]){
		return l;
	    }else{
		return r;
	    }
	} 
	int m =(l+r)/2;
	if (nums[m-1]<nums[m] && nums[m] > nums[m+1]){
	    return m;
	}
	
	if (nums[m-1]> nums[m]){
	   return find(nums, l, m);
	}else{
	   return find(nums, m, r);
	}
          
    }
    
    
    @Test
    public void test1() {
	assertEquals(2, findPeakElement(new int[] { 1, 2, 3, 1 }));
    }
}
