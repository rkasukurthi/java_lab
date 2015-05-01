package algorithm.leetcode._191_NumberOf1Bits;

import static org.junit.Assert.*;

import org.junit.Test;

public class Solution {
    /**
     * Write a function that takes an unsigned integer and returns the number of
     * ’1' bits it has (also known as the Hamming weight).
     * 
     * For example, the 32-bit integer ’11' has binary representation
     * 00000000000000000000000000001011, so the function should return 3.
     * 
     * Credits: Special thanks to @ts for adding this problem and creating all
     * test cases.
     * 
     * @see http://en.wikipedia.org/wiki/Hamming_weight
     * 
     * @param n
     * @return
     */
    
    // Even Simpler
    public int hammingWeight(int n) {
	int i = 0;
	while (n != 0) {
	    i += n & 1;
	    n >>>= 1;
	}
	return i;
    }
    
    // take care of long
    public long hammingWeight4(long n) {
	int i = 0;
	while (n != 0) {
	    i += n & 1;
	    n >>>= 1;
	}
	return i;
    }
    
    // Solution 2
    public int hammingWeight1(int n) {
	int count = 0;
	while (n != 0) {
	    n = n & (n - 1);
	    count++;
	}
	return count;
    }
    
    /** Solution 3 **/
    public int hammingWeight3(long n) {
	String s = Long.toBinaryString(n);
	System.out.println(s);
	int count=0;
	for(char c: s.toCharArray()){
	    if (c=='1'){
		count++;
	    }
	}
	return count;
    }
    
    @Test
    public void testCase1() {
	assertEquals(1, hammingWeight(4));
	assertEquals(1, hammingWeight(8));
    }
    
    @Test
    public void testCase2() {
	assertEquals(3, hammingWeight(7));
	assertEquals(0, hammingWeight(0));
    }
    
    @Test
    public void testCase3() {
	assertEquals(32, hammingWeight(-1));
	assertEquals(32, hammingWeight1(-1));
	assertEquals(32, hammingWeight3(-1));
    }
    
    @Test
    public void testCase4() {
//	assertEquals(10, hammingWeight4(789012340567L));
	assertEquals(64, hammingWeight3(789012340567L));
	
	
    }
    
    @Test
    public void testCase5() {
	String s = Integer.toBinaryString((int)789012340567L);
	System.out.println(s);
	String s6 = Long.toBinaryString(0xFFFFFFFF00000000L);
	System.out.println("0xFFFFFFFFL= " + s6);
	
	String s2 = Integer.toBinaryString((int)(789012340567L & 0xFFFFFFFF00000000L));
	System.out.println(s2);
	String s1 = Long.toBinaryString(789012340567L);
	System.out.println(s1);
	String s4 = Long.toBinaryString(-1L);
	System.out.println(s4);
    }
    
}
