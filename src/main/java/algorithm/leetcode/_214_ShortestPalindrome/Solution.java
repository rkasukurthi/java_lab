package algorithm.leetcode._214_ShortestPalindrome;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * http://www.zrzahid.com/longest-palindromic-substring-in-linear-time/
 * @author zluo
 *
 */
public class Solution {
 public String shortestPalindrome(String s) {
       return null; 
 }
	
	@Test
	public void test1(){
		assertEquals("aaacecaaa",shortestPalindrome("aacecaaa"));
		assertEquals("dcbabcd",shortestPalindrome("abcd"));
	}
}
