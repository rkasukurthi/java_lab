package algorithm.leetcode._221_MaximalSquare;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing all 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0
 * 
 * Return 4.
 * 
 * @author zluo
 *
 */
public class Solution {
    
    public int maximalSquare(char[][] matrix) {
	if (matrix==null || matrix.length==0) return 0;
	int maxLine = 0;
	int[][] cache;
	cache = new int[matrix.length + 1][matrix[0].length + 1];
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[0].length; j++) {
		if (matrix[i][j] == '1') {
		    cache[i + 1][j + 1] = Math.min(Math.min(cache[i][j], cache[i + 1][j]), cache[i][j + 1]) +1;
		    if (cache[i + 1][j + 1] > maxLine) {
			maxLine = cache[i + 1][j + 1];
		    }
		}
	    }
	}
	return maxLine * maxLine;
    }
    
    @Test
    public void test0() {
	char[][] matrix= new char[][]{};
	
	assertEquals(0, maximalSquare(matrix));
	
    }
    @Test
    public void test1() {
	
	assertEquals(4, maximalSquare(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
		{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));
	
    }
    
    @Test
    public void test2() {
	assertEquals(9, maximalSquare(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
	        { '1', '1', '1', '1', '1' }, { '1', '0', '1', '1', '1' } }));
    }
}
