package algorithm.leetcode._022_GenerateParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author zluo
 * 
 */
public class Solution {
  public void findParenthesis(char[] solution, int pos, int sum, List<String> result) {
    if (pos == solution.length || sum > 0) {
        if (sum == 0) {
            result.add(new String(solution));
        }
        return;
    }
    solution[pos] = '(';
    findParenthesis(solution, pos + 1, sum - 1, result);
    solution[pos] = ')';
    findParenthesis(solution, pos + 1, sum + 1, result);
}

public List<String> generateParenthesis(int n) {
    ArrayList<String> result = new ArrayList<String>();
    char[] solution = new char[n * 2];
    solution[0] = '(';
    findParenthesis(solution, 1, -1, result);
    return result;
}
  
@Test
public void test() {
  generateParenthesis(2);
}

}
