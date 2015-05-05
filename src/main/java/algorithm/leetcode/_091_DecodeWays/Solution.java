package algorithm.leetcode._091_DecodeWays;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * 
 * Note: 1. 0 in first character 2. 0 in the middle or in last condition, so the
 * iteration have to be from last ->
 * 
 * @author zluo
 *
 */
public class Solution {
	Map<String, Integer> map = new HashMap<String, Integer>();
	public int numDecodings(String s) {

		if (s.equals("") || s.substring(0, 1).equals("0"))
			return 0;
		if (s.length() == 1)
			return 1;
		if (s.length() == 2) {
			int i = Integer.parseInt(s);
			if (i > 26) {
				if (i % 10 == 0) {
					return 0;
				} else {
					return 1;
				}
			} else {
				if (i == 10 || i == 20) {
					return 1;
				} else {
					return 2;
				}
			}
		}
		if (map.get(s) != null)  return map.get(s);  //cache intermediate result
		int result = numDecodings(s.substring(1));
		if (Integer.parseInt(s.substring(0, 2)) <= 26) {
			result += numDecodings(s.substring(2));
		}
		map.put(s, result);
		return result;
	}

	@Test
	public void test1() {
		assertEquals(2, Integer.valueOf("02").intValue());
		assertEquals(0, numDecodings(""));
		assertEquals(0, numDecodings("0"));
		assertEquals(0, numDecodings("00"));
		assertEquals(0, numDecodings("01"));
		assertEquals(0, numDecodings("000"));
		assertEquals(1, numDecodings("110"));
		assertEquals(1, numDecodings("1"));
		assertEquals(1, numDecodings("102"));
		assertEquals(1, numDecodings("1020"));
		assertEquals(2, numDecodings("12"));
		assertEquals(1, numDecodings("327"));
		assertEquals(1, numDecodings("32789"));
		assertEquals(2, numDecodings("312"));
	}

	@Test
	public void test2() {
		assertEquals(0, numDecodings("0"));
	}

	@Test
	public void test3() {
		assertEquals(1, numDecodings("110"));
		/*
		 * assertEquals(1, numDecodings("1")); assertEquals(1,
		 * numDecodings("102")); assertEquals(1, numDecodings("1020"));
		 * assertEquals(2, numDecodings("12")); assertEquals(1,
		 * numDecodings("327")); assertEquals(1, numDecodings("32789"));
		 * assertEquals(2, numDecodings("312"));
		 */
	}

	@Test
	public void test4() {
		assertEquals(3, numDecodings("111"));
	}

	@Test
	public void test5() {
		assertEquals(
				0,
				numDecodings("6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
	}

	@Test
	public void test6() {
		assertEquals(0, numDecodings("230"));
	}
}
