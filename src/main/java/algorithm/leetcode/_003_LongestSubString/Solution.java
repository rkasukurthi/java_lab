package algorithm.leetcode._003_LongestSubString;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author zluo
 *
 */
public class Solution {
    
    public int lengthOfLongestSubstring(String s) {
	int maxLength=0;
	/** Key is the current string, Value is the previous key**/
	Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
	char[] a =s.toCharArray();
	int i=0;
	int start=0;
	int end=0;
        for(char c: a){
        }
	return maxLength;
    }
    
    
    @Test
    public void testCase1(){
	assertEquals(1, lengthOfLongestSubstring("bbbbbb"));
	assertEquals(0, lengthOfLongestSubstring(""));
	assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
	assertEquals(4, lengthOfLongestSubstring("abcbadbb"));
    }
    
}
