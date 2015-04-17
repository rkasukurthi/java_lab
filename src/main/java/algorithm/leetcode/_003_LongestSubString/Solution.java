package algorithm.leetcode._003_LongestSubString;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Given a string, find the length of the longest substring without repeating characters. For
 * example, the longest substring without repeating letters for "abcabcbb" is "abc", which the
 * length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author zluo
 * 
 */
public class Solution {

  public int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    int start = 0;
    
    /** mapping character position **/ 
    int[] map = new int[128];
    Arrays.fill(map, -1);
    int l;
    for (int i = 0; i < s.length(); i++) {
      if (map[s.charAt(i)] >= start) {
        l=i-start;
        if (maxLength < l) {
          maxLength = l;
        }
        start = map[s.charAt(i)] + 1;
      }
      map[s.charAt(i)] = i;
    }
    return Math.max(maxLength, (s.length() - start));
  }


  @Test
  public void testCase1() {
    assertEquals(3, lengthOfLongestSubstring("abc"));
    assertEquals(1, lengthOfLongestSubstring("bbbbbb"));
    assertEquals(0, lengthOfLongestSubstring(""));
    assertEquals(1, lengthOfLongestSubstring("c"));
    assertEquals(3, lengthOfLongestSubstring("abc"));
    assertEquals(1, lengthOfLongestSubstring("c"));
    assertEquals(0, lengthOfLongestSubstring(""));
    assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    assertEquals(4, lengthOfLongestSubstring("abcbadbb"));
    assertEquals(4, lengthOfLongestSubstring("abcbadbb"));
    assertEquals(4, lengthOfLongestSubstring("abcbadbb"));
    assertEquals(4, lengthOfLongestSubstring("abcbadbb"));
    assertEquals(7, lengthOfLongestSubstring("abcbefgadbb"));
  }

}
