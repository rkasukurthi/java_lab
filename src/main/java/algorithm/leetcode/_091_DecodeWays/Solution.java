package algorithm.leetcode._091_DecodeWays;

import static org.junit.Assert.*;

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
 * @author zluo
 *
 */
public class Solution {
	
	public int numDecodings(String s) {
		if (s!=null && s.length()==0 ||"0".equals(s.substring(0,1))) return 0;
		int ret=1;
		int l=s.length()-1;
		for (int i=0; i<l; i++){
			ret*=f(i,s);
		}
		return ret;
	}
	
	int f(int st, String str){
		String s=str.substring(st,st+2);
		int i =Integer.valueOf(s);
		if (i==0) return 0;
		if (i!=20 && i<27 && i>10){
			return 2;
		}
		return 1;
	}
	
	
	
	@Test
	public void test1(){
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
	public void test2(){
		assertEquals(0, numDecodings("0"));
	}
}
