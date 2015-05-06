package algorithm.leetcode._046_Permutations;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author zluo
 *
 */
public class Solution {
	public List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> lists = new ArrayList<List<Integer>>();
	for (int i=0; i<nums.length; i++){
		
	}
	return null;
    }

	
	
	
	@Test
	public void test1() {
		assertEquals(6, permute(new int[] { 1, 2, 3 }).size());
	}
}
