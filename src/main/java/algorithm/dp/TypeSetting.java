package algorithm.dp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TypeSetting {

	String input = "To Sherlock Holmes she is always the woman. I have seldom heard him mention her under any other name. In his eyes she eclipses and predominates the whole of her sex. It was not that he felt any emotion akin to love for Irene Adler. All emotions, and that one particularly, were abhorrent to his cold, precise but admirably balanced mind. He was, I take it, the most perfect reasoning and observing machine that the world has seen, but as a lover he would have placed himself in a false position. He never spoke of the softer passions, save with a gibe and a sneer. They were admirable things for the observer--excellent for drawing the veil from men's motives and actions. But for the trained reasoner to admit such intrusions into his own delicate and finely adjusted temperament was to introduce a distracting factor which might throw a doubt upon all his mental results. Grit in a sensitive instrument, or a crack in one of his own high-power lenses, would not be more disturbing than a strong emotion in a nature such as his. And yet there was but one woman to him, and that woman was the late Irene Adler, of dubious and questionable memory.";
	int length = 80;

	public String[] normalFormat(String input, int length) {
		List<String> list = new ArrayList<String>();
		String[] a = input.split(" ");
		for(int i=0; i<a.length; i++){
			
		}
		return null;
	}

	public String[] dpFormat(String input, int M) {
		String words[] = input.split(" ");
		int n = words.length;
		int lens[] = new int[n+1];
		for(int i=1;i<=n; i++) {
		    lens[i] = words[i-1].length();
		    if (lens[i]>M) { 
		    }
		}
		
		int infty = M*M*2;

		// compute S_ij
		int S[][] = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
		    S[i][i] = M - lens[i];
		    for(int j=i+1; j<=n; j++) {
			S[i][j] = S[i][j-1] - lens[j] - 1;
			if (S[i][j]<0) {
			    while(j<=n) { S[i][j++] = infty; }
			}
		    }
		}

		// compute best_0,...,best_n
		int best[] = new int[n+1];
		int choice[] = new int[n+1];
		best[0] = 0;
		for(int i=1;i<=n;i++) {
		    int min = infty;
		    int ch  = 0;
		    for(int j=0;j<i;j++) {
			int t = best[j] + S[j+1][i]*S[j+1][i];
			if (t<min) { min = t; ch = j;}
		    }
		    best[i] = min;
		    choice[i] = ch;
		}

		for(int i=0;i<=n;i++) {
		    System.out.println(i + " best: " + best[i] + " ch " + choice[i]);
		}

		// backtrack to output linebreaks
		int end = n;
		int start   = choice[end]+1;
		String lines[] = new String[n];
		int cnt = 0;
		while (end>0) {
		    StringBuffer buf = new StringBuffer();
		    for(int j=start; j<=end; j++) {
			buf.append(words[j-1] + " ");
		    }
		    lines[cnt++] = buf.toString();
		    end = start-1;
		    start = choice[end]+1;
		}

		for(int j=cnt-1; j>=0; j-- ) {
		    System.out.println(lines[j]);
		}
//		return lines;
		return lines;
	}

	public int calculatePenalty(String[] result, int length) {
		int penalty = 0;
		for (int i = 0; i < result.length; i++) {
			penalty += Math.pow(length - result[i].length(), 2);
		}
		return penalty;
	}

	public void print(String[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.println(result);
		}
	}

	@Test
	public void testPenalty() {
		String[] result = { "1234567890", "1234", "1234567", "12345678" };
		assertEquals(0 + 36 + 9 + 4, calculatePenalty(result, 10));
	}

	@Test
	public void  testDpFormat(){
		String[] result = dpFormat(input, 80);
	}
	
}
