package algorithm.leetcode._001_twosum;

import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.*;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author zluo
 *
 */
public class Solution {
    
    /** this method are too slow **/
    public int[] twoSum1(int[] numbers, int target) {
	int[] indexs = { 0, 0 };
	for (int i = 0; i < numbers.length; i++) {
	    for (int j = i + 1; j < numbers.length; j++) {
		if (numbers[i] + numbers[j] == target) {
		    indexs[0] = i + 1;
		    indexs[1] = j + 1;
		    return indexs;
		}
	    }
	}
	return indexs;
    }
    
    /**
     * An optimized solution is to use an additional data structure which allows
     * us to keep track of each number that we have and also its index, for this
     * task we could use a HashMap which offers a constant time look-up
     * operation, so we just need to loop the array once to store the elements
     * and their corresponding indices in our HashMap and then loop through the
     * array again and for each element i just check if
     * hashmap.containsKey(target – array[ i ]). Here is the working solution
     * implemented in Java:
     * 
     * @param numbers
     * @param target
     * @return
     */
    
    public int[] twoSum(int[] numbers, int target) {
	
	HashMap<Integer, LinkedList<Integer>> indexes = new HashMap<Integer, LinkedList<Integer>>();

	/** problem here is the number may be duplicated, so it's need to handle **/
	for (int i = 0; i < numbers.length; ++i) {
	    if (indexes.get(numbers[i])==null){
		indexes.put(numbers[i], new LinkedList());
	    }
	    indexes.get(numbers[i]).add(i);
	}
	
	/** Reversed Thinking, what you want solve is from first one, calculate second one, then find it from index **/
	for (int i = 0; i < numbers.length; ++i) {
	    LinkedList<Integer> list = indexes.get(target - numbers[i]);
	    if (list !=null) {
		list.removeFirstOccurrence(i);
		if (list.size()>0){
		    return new int[] { i + 1, list.getFirst() + 1 };
		}
	    }
	}
	return null;
    }
    
    /**
     * Dynamic Solution Subset Summ Problem
     * See http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/ 
     * @param numbers
     * @param target
     * @return
     */
    
    public int[] twoSum2(int[] numbers, int target) {
//      findSum(0, numbers);
	return null;
    }
    
    void find(int i, int[] numbers){
    }
    
    
    @Test
    public void testTwoSum() {
	int[] numbers = { 2, 7, 11, 15 };
	int[] result = twoSum(numbers, 9);
	assertReflectionEquals(new int[]{1,2}, result);
	
	result = twoSum(numbers, 18);
	assertReflectionEquals(new int[]{2,3}, result);

	assertReflectionEquals(new int[]{1,2},  twoSum(new int[]{2,2,5}, 4));
	
    }
    
    @Test
    public void testTwoSumCaseOne() {
//	assertReflectionEquals(new int[]{1,2},  twoSum(new int[]{2,2,5}, 4));
	assertReflectionEquals(new int[]{3,4},  twoSum(new int[]{2,2,3,3,3,5}, 6));
    }
    
    
}
