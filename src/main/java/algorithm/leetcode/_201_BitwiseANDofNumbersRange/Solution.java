package algorithm.leetcode._201_BitwiseANDofNumbersRange;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in
 * this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * Explaination The idea is to use a mask to find the leftmost common digits of m and n. Example:
 * m=1110001, n=1110111, and you just need to find 1110000 and it will be the answer.
 * 
 * find the leftmost common digits of m and n, but not
 * "leftmost common digits of all 1's for m and n", E.g. m=1110111, n=1110101 and answer is 1110100
 * 
 * @author zluo
 * 
 */
public class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    int i = 0;
    while (m != n) {
      m >>= 1; // m left shif one bit
      n >>= 1;
      i++;
    }
    return m << i;
  }
}
