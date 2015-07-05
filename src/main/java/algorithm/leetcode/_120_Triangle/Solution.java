package algorithm.leetcode._120_Triangle;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 
 * @author zluo
 *
 */
public class Solution {
    int[][] cache;
    int[][] history;
    public int minimumTotal(List<List<Integer>> triangle) {
	cache = new int[triangle.get(triangle.size()-1).size()+1][triangle.size()+1];
	history = new int[triangle.get(triangle.size()-1).size()+1][triangle.size()+1];
	
	return minTotal(0, 0, triangle);
    }
    
    int minTotal(int index, int layer, List<List<Integer>> list){
	if (history[index][layer]==1){
	    return cache[index][layer];
	}
	int result=0;
	history[index][layer]=1;
	if (layer>= list.size()) return 0;
	int val =list.get(layer).get(index);
        result= Math.min(val + minTotal(index +1, layer+1, list), val+ minTotal(index, layer+1, list));
        cache[index][layer]=result;
        return result;
    }
    
    public int minimumTotal1(List<List<Integer>> triangle) {
        int[] cur = new int[triangle.size()];
        //initial cur
        for(int i = 0; i < triangle.size(); i++) 
            cur[i] = triangle.get(triangle.size() - 1).get(i);

        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
               //update cur[] for each row, cur[i] is the minimum path value from bottom to node i;
               if(cur[j] > cur[j+1]) {
                    cur[j] = cur[j+1] + triangle.get(i).get(j);
               }else{
                    cur[j] += triangle.get(i).get(j);
               }
            }
        }
        return cur[0];
    }
    
    
    @Test
    public void test1() {
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	list.add(Arrays.asList(new Integer[]{2}));
	list.add(Arrays.asList(new Integer[]{3,4}));
	list.add(Arrays.asList(new Integer[]{6,5,7}));
	list.add(Arrays.asList(new Integer[]{4,1,8,3}));
	assertEquals(11, minimumTotal(list));
    }
    @Test
    public void test2() {
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	list.add(Arrays.asList(new Integer[]{-1}));
	list.add(Arrays.asList(new Integer[]{3,2}));
	list.add(Arrays.asList(new Integer[]{-3,1,-1}));
	assertEquals(-1, minimumTotal(list));
    }
}
