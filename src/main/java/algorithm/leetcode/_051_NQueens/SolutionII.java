package algorithm.leetcode._051_NQueens;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * @author zluo
 * 
 */
public class SolutionII {
  private final Set<Integer> occupiedCols = new HashSet<Integer>();
  private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
  private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();
  int n = 0;
  int count = 0;

  public int totalNQueens(int n) {
    this.n = n;
    totalNQueensHelper(0);
    return count;
  }

  private void totalNQueensHelper(int row) {
    for (int col = 0; col < n; col++) {
      if (isSafe(row, col)) {
        if (row == n - 1)
          count++;
        else {
          push(row, col);
          totalNQueensHelper(row + 1);
          pop(row, col);
        }
      }
    }
  }

  boolean isSafe(int row, int col) {
    if (occupiedCols.contains(col))
      return false;
    int diag1 = row - col;
    if (occupiedDiag1s.contains(diag1))
      return false;
    int diag2 = row + col;
    if (occupiedDiag2s.contains(diag2))
      return false;
    return true;
  }

  void push(int row, int col) {
    occupiedCols.add(col);
    occupiedDiag1s.add(row - col);
    occupiedDiag2s.add(row + col);
  }

  void pop(int row, int col) {
    occupiedCols.remove(col);
    occupiedDiag1s.remove(row - col);
    occupiedDiag2s.remove(row + col);
  }


  @Test
  public void test() {
    assertEquals(2, totalNQueens(4));
  }
}
