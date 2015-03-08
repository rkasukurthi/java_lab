package algorithm.dp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TypeSetting {

  String input =
      "To Sherlock Holmes she is always the woman. I have seldom heard him mention her under any other name. In his eyes she eclipses and predominates the whole of her sex. It was not that he felt any emotion akin to love for Irene Adler. All emotions, and that one particularly, were abhorrent to his cold, precise but admirably balanced mind. He was, I take it, the most perfect reasoning and observing machine that the world has seen, but as a lover he would have placed himself in a false position. He never spoke of the softer passions, save with a gibe and a sneer. They were admirable things for the observer--excellent for drawing the veil from men's motives and actions. But for the trained reasoner to admit such intrusions into his own delicate and finely adjusted temperament was to introduce a distracting factor which might throw a doubt upon all his mental results. Grit in a sensitive instrument, or a crack in one of his own high-power lenses, would not be more disturbing than a strong emotion in a nature such as his. And yet there was but one woman to him, and that woman was the late Irene Adler, of dubious and questionable memory.";
  int length = 80;


  /**
   * Normal formatting will
   * 
   * @param input
   * @param length
   * @return
   */
  public int[] normalFormat(String input, int length) {
    int start = 0;
    int end = 0;
    int a[] = new int[(int) ((input.length() / length) * 1.5)];
    int line = 1;
    while (start < input.length() - 1) {
      end = start + length;
      if (end >= input.length() - 1) {
        a[line++] = input.length() - 1;
        return a;
      }
      while (input.charAt(end) != ' ') {
        end--;
      }
      a[line++] = end;
      start = end + 1;
    }
    return a;
  }

  public String[] dpFormat(String input, int length) {
    return null;
  }

  public int calculatePenalty(String[] result, int length) {
    int penalty = 0;
    for (int i = 0; i < result.length; i++) {
      penalty += calculatePenalty(result[i], length);
    }
    return penalty;
  }

  public int calculatePenalty(String result, int length) {
    return (int) Math.pow(length - result.length(), 2);
  }

  public void print(int[] a) {
    int p=0;
    for (int i = 0; i < a.length; i++) {
      int s= i==0?a[i]:a[i]+1;
      int e=a[i + 1];
      if (e==0) break;
        int m=length-(e-s);
        System.out.print("\n" +input.substring(s, e));
        for(int j=0;j<m;j++) {
          System.out.print(" ");
        }
        p+=m*m;
        System.out.print("| "+ m*m);
      }
    System.out.print("\n");
    
    for(int j=0;j<length;j++) {
      System.out.print("-");
    }
    
    System.out.println("+ " + p);
    
  }

  @Test
  public void testPenalty() {
    String[] result = {"1234567890", "1234", "1234567", "12345678"};
    assertEquals(0 + 36 + 9 + 4, calculatePenalty(result, 10));
  }

  @Test
  public void testNormalFormat() {
    int[] a = normalFormat(input, 80);
    System.out.println(Arrays.toString(a));
    print(a);
  }

}
