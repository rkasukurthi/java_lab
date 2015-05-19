package algorithm.leetcode._076_MinWindowSubstring;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author zluo
 *
 */
public class Solution {
    public String minWindow(String s, String t) {
	return null;
    }
    
    @Test
    public void test1() {
	assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
    }
}
