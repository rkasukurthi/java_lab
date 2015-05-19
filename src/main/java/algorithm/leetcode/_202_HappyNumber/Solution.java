package algorithm.leetcode._202_HappyNumber;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
 */

public class Solution {
    /**
     * we can simply adapt the Floyd Cycle detection algorithm. I believe that
     * many people have seen this in the Linked List Cycle detection problem.
     * The following is my code:
     * 
     */
    public boolean isHappy(int n) {
	int slow=n, fast=n;
	slow =convert(slow);
	fast =convert(fast);
	fast =convert(fast);
	if (fast==1) return true;

	while (slow !=fast){
	    fast = convert(fast);
	    if (fast==1) return true;
	    fast  = convert(fast);
	    if (fast==1) return true;
	    slow =convert(slow);
	}
	return false;
    }
    
    private int convert(int n) {
	int sum=0,n1=0;
	while (n >= 10) {
	    n1=n%10;
	    sum +=n1*n1;
	    n=n/10;
	}
	sum +=n*n;
	return sum;
    }
    
    @Test
    public void test() {
	assertTrue(isHappy(19));
    }
    
}
