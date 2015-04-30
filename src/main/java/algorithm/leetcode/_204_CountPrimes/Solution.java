package algorithm.leetcode._204_CountPrimes;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.Test;
/**
 * Count the number of prime numbers less than a non-negative number, n
 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * @author zluo
 *
 */
public class Solution {
 
 public int countPrimes1(int n) {
     int num=0;
     if (n>2) num= 1;
     if (n>3) num= 2;
     if (n>5) num= 3;
     int i=1;
     while (i<n){
	 if (!((i%2==0) ||(i%3==0) ||(i%5==0))) {
	     if (isPrime(i)) num ++;
	 }
	 i++;
     }
    return num;
 }
 
 boolean isPrime(int n){
    int n1=(int)Math.sqrt(n);
    if (n==n1*n1) return false;
    int i=1;
    while(i < n1){
	i+=6;
	if ((n%i==0)&& (n!=i)) return false;
    }
    return true;
 }
 
 public int countPrimes(int n) {
     BitSet bs = new BitSet(n);
     bs.set(0); bs.set(1);
     int ind = 0, count = 0;
     while(ind < n){
         ind = bs.nextClearBit(ind + 1);
         if(ind >= n)
             return count;
         count++;
         for(int i = 2 * ind; i < n; i += ind)
             bs.set(i);
     }
     return count;
 }
 
 @Test
 public void test1(){
     assertEquals(4,countPrimes(10));
/*     assertEquals(3,countPrimes(7));
     assertEquals(4,countPrimes(11));
     assertEquals(5,countPrimes(13));
     assertEquals(6,countPrimes(17));
     assertEquals(7,countPrimes(18));*/
 }
 
}
