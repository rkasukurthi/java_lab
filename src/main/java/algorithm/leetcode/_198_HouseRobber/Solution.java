package algorithm.leetcode._198_HouseRobber;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author zluo
 *
 */
public class Solution {
    int total=0; 
    public int rob(int[] num) {
	if (num==null) return 0;
	for (int i=0; i< num.length;i++){
	    
	}
        return 0;
    }
    
    public int rob(int i, int[] num){
	if (i > num.length) return 0;
	return num[i];
	
    }
    
    @Test
    public void testCase1(){
	assertEquals(0, rob(null));
    }
    
    @Test
    public void testCase2(){
	
    }
    
    @Test
    public void testCase3(){
	
    }
    
    @Test
    public void testCase4(){
	
    }
    
}
