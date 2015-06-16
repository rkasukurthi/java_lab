package algorithm.leetcode._219_ContainsDuplicatedII;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Given an array of integers and an integer k, return true if and only if there
 * are two distinct indices i and j in the array such that nums[i] = nums[j] and
 * the difference between i and j is at most k.
 * 
 * @author zluo
 *
 */
public class Solution {
    
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
	for(int i=0;i<nums.length ;i++){
	    if (map.containsKey(nums[i])){
		if (i-map.get(nums[i])<=k){
		    return true;
		}
	    }
	    map.put(nums[i], i);
	}
	return false;
    }
    
    @Test
    public void test1() {
	assertEquals(false, containsNearbyDuplicate(new int[]{1,2,3,4,5,1},4));
	assertEquals(true, containsNearbyDuplicate(new int[]{1,2,3,4,5,1},5));
    }
}
