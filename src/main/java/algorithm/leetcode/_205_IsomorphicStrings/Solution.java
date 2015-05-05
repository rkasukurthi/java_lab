package algorithm.leetcode._205_IsomorphicStrings;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * @author zluo
 *
 */
public class Solution {
    
    public boolean isIsomorphic(String s, String t) {
	char[] maps = new char[128];
	char[] mapt = new char[128];
	for (int i = 0; i < s.length(); i++) {
	    if ((maps[s.charAt(i)] != 0 && maps[s.charAt(i)] != t.charAt(i)) || (mapt[t.charAt(i)] != 0 && mapt[t.charAt(i)] != s.charAt(i))) {
		return false;
	    }
	    maps[s.charAt(i)] = t.charAt(i);
	    mapt[t.charAt(i)] = s.charAt(i);
	}
	return true;
    }
    
    
    @Test
    public void test4() {
	assertEquals(true, isIsomorphic("ab", "ca"));
    }
    
    @Test
    public void test5() {
	assertEquals(false, isIsomorphic("aa", "ab"));
    }
    
    @Test
    public void test0() {
	assertEquals(false, isIsomorphic("ab", "aa"));
    }
    
    // @Test
    public void test1() {
	assertTrue(isIsomorphic("egg", "add"));
    }
    
    // @Test
    public void test2() {
	assertEquals(false, isIsomorphic("foo", "bar"));
    }
    
    // @Test
    public void test3() {
	assertEquals(true, isIsomorphic("paper", "title"));
    }
}
