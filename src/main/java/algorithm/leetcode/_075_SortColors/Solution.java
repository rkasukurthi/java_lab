package algorithm.leetcode._075_SortColors;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * @author zluo
 *
 */
public class Solution {
    public void sortColors(int[] nums) {
	int rp=0,bp=nums.length-1; //red point, blue point.
	for(int i=0; i<=bp && i< nums.length;){
	    if (nums[i]==0 && i>rp){
		swap(i, rp++, nums);
	    }else if(nums[i]==2 && i<bp){
		swap(i, bp--, nums);
	    }else{
		i++;
	    }
	}
    }
    
    void swap(int i, int j, int[] nums){
	int t=nums[i];
	nums[i]=nums[j];
	nums[j]=t;
    }
    
    
    @Test
    public void test1() {
	int[] arr =new int[]{0,2,1,2,1,0,2,1,0,2};
	sortColors(arr);
	assertEquals(0, arr[2]);
	assertEquals(1, arr[3]);
	assertEquals(1, arr[5]);
	assertEquals(2, arr[6]);
    }
}
