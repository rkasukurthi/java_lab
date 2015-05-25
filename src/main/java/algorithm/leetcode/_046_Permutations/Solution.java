package algorithm.leetcode._046_Permutations;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
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
	List<List<Integer>> lists = new ArrayList<List<Integer>>();
	int len;
	public List<List<Integer>> permute(int[] nums) {
		len=nums.length;
		permute(nums,0);
	return lists;
    }
    
	public void permute(int[] nums, int index){
		if (index== len){
//			System.out.println("-------------------------------" + Arrays.toString(nums));
			List<Integer> list = new ArrayList<Integer>();
			for(int i:nums){
				list.add(i);
			}
			lists.add(list);
		}else{
			for(int i=index;i<len;i++){
				swap(nums, index, i);
				permute(nums,index+1);
				swap(nums, index,i);
			}
		}
	}
	
	public void swap(int[] nums, int i, int j){
		int t=nums[i];
		nums[i]=nums[j];
		nums[j]=t;
//		System.out.println("i= " + i + " j= " +j + " " + Arrays.toString(nums));
	}
	
	
	@Test
	public void test1() {
		assertEquals(6, permute(new int[] { 1, 2, 3 }).size());
	}
}
