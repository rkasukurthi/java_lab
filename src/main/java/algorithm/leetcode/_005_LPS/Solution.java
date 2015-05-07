package algorithm.leetcode._005_LPS;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * http://www.geeksforgeeks.org/dynamic-programming-set-12
 * 
 * -longest-palindromic-subsequence/
 * 
 * @author zluo
 *
 */
public class Solution {
	
		    private int maxLength = 1;
		    private int maxIndex = 0;
		    char[] sa;
		    int length;
		    public String longestPalindrome(String str) { //O(N^2), space O(1)
		        length = str.length();
		        sa=str.toCharArray();
		        for (int i=0; i<length; i++) {
		            // find longest odd palindrome with center i
		            findPalindrome(i, 0);
		            // find longest even palindrome with center i
		            findPalindrome(i, 1);
		        }
		        return str.substring(maxIndex, maxIndex+maxLength);
		    }

		    private void findPalindrome( int i, int shift) {
		      int left = i;
		      int right= i+shift;
		      while (left >= 0 && right < length && sa[left] == sa[right]) {
		        if ((right - left + 1) > maxLength) {
		          maxLength = right - left + 1;
		          maxIndex = left;
		        }
		        left--;
		        right++;
		    }
		   }

	
	
    int[][] mapi;
    int[][] mapj;
    public String longestPalindrome1(String s) {
	mapi = new int[s.length()][s.length()];
	mapj = new int[s.length()][s.length()];
	sa = s.toCharArray();
	lps(0, s.length() - 1);
	return s.substring(mapi[0][s.length() - 1],mapj[0][s.length() - 1]);
    }
    
    /** SubString Range **/
    void lps( int i, int j) {
	if (mapi[i][j] !=0) return;
	int i0 = i, j0 = j;
	while (sa[i] == sa[j]) {
	    if (i == j || i + 1 == j) {
		mapi[i0][j0] = i0;
		mapj[i0][j0] = j0+1;
		return;
	    }
	    ++i;
	    --j;
	}
	
	lps(i0, j0 - 1);
	lps(i0 + 1, j0);
	
	if (mapj[i0][j0 - 1]-mapi[i0][j0 - 1] > mapj[i0+1][j0]-mapi[i0+1][j0]) {
	    mapi[i0][j0]=mapi[i0][j0 - 1];
	    mapj[i0][j0]=mapj[i0][j0 - 1];
	} else {
	    mapi[i0][j0]=mapi[i0+1][j0];
	    mapj[i0][j0]=mapj[i0+1][j0];
	}
    }
    
 /*   *//** SubSequence **//*
    String lpsequence(String s, int i, int j) {
	int key = i * 31 + j;
	if (map.get(key) != null)
	    return map.get(key);
	String str;
	if (i == j) {
	    map.put(key, s.substring(i, i + 1));
	} else if (s.charAt(i) == s.charAt(j) && i + 1 == j) {
	    map.put(key, s.substring(i, j + 1));
	} else if (s.charAt(i) == s.charAt(j)) {
	    map.put(key, s.substring(i, i + 1) + lps(s, i + 1, j - 1) + s.substring(j, j + 1));
	} else {
	    String s1 = lps(s, i, j - 1);
	    String s2 = lps(s, i + 1, j);
	    if (s1.length() > s2.length()) {
		map.put(key, s1);
	    } else {
		map.put(key, s2);
	    }
	}
	return map.get(key);
	
    }*/
    
    // @Test
    public void test1() {
	assertEquals("BABCBAB", longestPalindrome("BBABCBCAB"));
    }
    
    @Test
    public void test2() {
	// assertEquals("aaabaaa", longestPalindrome("aaaabaaa"));
	assertEquals("aaabaaa", longestPalindrome("aaabaaaa"));
    }
    
    @Test
    public void test3() {
	// assertEquals("aaabaaa", longestPalindrome("aaaabaaa"));
	assertEquals(
	        "ranynar",
	        longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
    
    @Test
    public void test4() {
	String test ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	String testResult ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String result = longestPalindrome(test); 
	assertEquals(testResult.length(), result.length()); 
	assertEquals(testResult, result); 
    }
    @Test
    public void test5() {
	assertEquals("aaaaaa", 
		longestPalindrome("aaaaaa"));
    }
    
}