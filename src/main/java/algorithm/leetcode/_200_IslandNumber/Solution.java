package algorithm.leetcode._200_IslandNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class Solution {
    public int numIslands(char[][] grid) {
	if (grid == null || grid.length == 0)
	    return 0;
	
	int count = 0;
	int cols = grid.length;
	int rows = grid[0].length;
	for (int i = 0; i < cols; i++) {
	    for (int j = 0; j < rows; j++) {
		if (grid[i][j] == '1') {
		    mark(i, j, grid);
		    count++;
		}
	    }
	}
	return count;
    }
    
    void mark(int i, int j, char[][] grid) {
	if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || grid[i][j] == 'x')
	    return;
	grid[i][j] = 'x';
	mark(i - 1, j, grid);
	mark(i + 1, j, grid);
	mark(i, j - 1, grid);
	mark(i, j + 1, grid);
    }
    
    @Test
    public void testCase1() {
	char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
	        { '0', '0', '0', '0', '0' } };
	assertEquals(1, numIslands(grid));
    }
    
    @Test
    public void testCase2() {
	char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
	        { '0', '0', '0', '1', '1' } };
	assertEquals(3, numIslands(grid));
    }
    
    @Test
    public void testCase3() {
	char[][] grid = { {} };
	assertEquals(0, numIslands(grid));
    }
    
    @Test
    public void testCase4() {
	char[][] grid = new char[1][1];
	grid[0][0] = '1';
	assertEquals(1, numIslands(grid));
    }
    
    @Test
    public void testCase5() {
	char[][] grid = new char[1][1];
	grid[0][0] = '1';
	assertEquals(1, numIslands(grid));
    }
    
    @Test
    public void testCase6() {
	assertEquals(0, numIslands(null));
    }
    
}
