package algorithm.leetcode._005_LPS;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * http://www.geeksforgeeks.org/dynamic-programming-set-12
 * -longest-palindromic-subsequence/
 * 
 * @author zluo
 *
 */
public class Solution {
	Map<Integer, String> map = new HashMap<Integer, String>();

	public String longestPalindrome(String s) {
		return lps(s, 0, s.length() - 1);
	}

	/** SubString **/
	String lps(String s, int i, int j) {
		int i0 = i, j0 = j;
		int key = i * 31 + j;
		while (s.charAt(i) == s.charAt(j)) {
			if (i == j || i + 1 == j) {
				map.put(key, s.substring(i0, j0 + 1));
				return map.get(key);
			}
			++i;
			--j;
		}

		String s1 = lps(s, i0, j0 - 1);
		String s2 = lps(s, i0 + 1, j0);
		if (s1.length() > s2.length()) {
			map.put(key, s1);
		} else {
			map.put(key, s2);
		}
		return map.get(key);

	}

	/** SubSequence **/
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
			map.put(key,
					s.substring(i, i + 1) + lps(s, i + 1, j - 1)
							+ s.substring(j, j + 1));
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

	}

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
		assertEquals("aaabaaa", longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
}
