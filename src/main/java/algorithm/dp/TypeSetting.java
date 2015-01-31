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

	public String[] dpFormat(String input, int length) {
		return null;
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

	
	
}
