package algorithm.leetcode._022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MySolution {


  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();
    char[] solution = new char[n * 2];
    int underLimit = 0 - n;
    solution[0] = '(';
    findParenthesis(solution, 1, -1,result);
    return result;
  }

  public void findParenthesis(char[] solution, int pos, int sum, List<String> result) {
    if (sum > 0 || sum < (0-solution.length/2))
      return;
    
    if (pos == solution.length) {
      if (sum == 0)
        result.add(new String(solution));
      return;
    }

    solution[pos] = '(';
    findParenthesis(solution,pos + 1, sum - 1,result);

    solution[pos] = ')';
    findParenthesis(solution,pos + 1, sum + 1,result);
  }

  @Test
  public void test() {
    System.out.println(generateParenthesis(3));
  }
}
