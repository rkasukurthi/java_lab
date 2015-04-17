package algorithm.leetcode._198_HouseRobber;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine
 * the maximum amount of money you can rob tonight without alerting the police.
 * 
 * @author zluo
 * 
 */
public class Solution {
  int cache[];
  public int rob(int[] num) {
    cache = new int[num.length];
    Arrays.fill(cache, -1);  //init cache
    return maxRob(0, num);
  }

  private int maxRob(int i, int[] num) {
    if (i >= num.length) return 0;
    if (cache[i]!=-1) return cache[i];
    return cache[i]= Math.max(num[i] +maxRob(i + 2, num), maxRob(i+1, num));
  }
  
  
  
  public int rob1(int[] num) {
    if (num == null) return 0;
    int i = 0;
    int e = 0;
    for (int k = 0; k<num.length; k++) {
        int tmp = i;
        i = num[k] + e;
        e = tmp>e? tmp:e;
    }
    return i>e? i:e;
}
  
  public int rob2(int[] num) {
    int n = num.length;
    if (n < 2)
        return n == 0 ? 0 : num[0];
    int[] result = new int[n]; //so far, the best result
    result[0] = num[0];
    result[1] = num[0] > num[1] ? num[0] : num[1];
    for (int i = 2; i < n; i++) {
        result[i] = result[i - 2] + num[i];
        result[i] = result[i] > result[i-1]? result[i] : result[i-1];
    }
    return result[n - 1];
}
  @Test
  public void testCase1() {
    assertEquals(0, rob(null));
 //   assertEquals(0, rob1(null));
  }

  @Test
  public void testCase2() {
    assertEquals(2, rob(new int[] {1,2}));
    assertEquals(2, rob1(new int[] {1,2}));
  }

  @Test
  public void testCase3() {
    assertEquals(5, rob(new int[] {1,5,2}));
    assertEquals(5, rob1(new int[] {1,5,2}));
  }

  @Test
  public void testCase4() {
    assertEquals(301, rob(new int[] {1,3,100,20,50,100,30,100}));
    assertEquals(301, rob1(new int[] {1,3,100,20,50,100,30,100}));
  }
  
  @Test
  public void testCase5() {
    assertEquals(1, rob(new int[] {1}));
    assertEquals(1, rob1(new int[] {1}));
  }
  
  @Test
  public void testCase6() {
    assertEquals(7102, rob(new int[] {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124}));
    assertEquals(7102, rob1(new int[] {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124}));
  }

}
