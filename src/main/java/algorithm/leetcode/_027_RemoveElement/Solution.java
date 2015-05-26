package algorithm.leetcode._027_RemoveElement;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author zluo
 *
 */
public class Solution {
    public int removeElement1(int[] nums, int val) {
	int length = nums.length;
	int i = 0;
	while (i < length) {
	    if (nums[i] == val) {
		int j = i;
		while (j < length - 1) {
		    nums[j] = nums[++j];
		}
		length--;
	    } else {
		i++;
	    }
	}
	return length;
    }
    
    public int removeElement(int[] A, int elem) {
	int m = 0;
	for (int i = 0; i < A.length; i++) {
	    if (A[i] != elem) {
		A[m] = A[i];
		m++;
	    }
	}
	return m;
    }
    
    @Test
    public void test1() {
	assertEquals(4, removeElement(new int[] { 1, 3, 4, 1, 4, 5 }, 1));
    }
    
    @Test
    public void test2() {
	assertEquals(0, removeElement(new int[] { 3, 3, 3 }, 3));
    }
}
