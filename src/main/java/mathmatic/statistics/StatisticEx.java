package mathmatic.statistics;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * A standard approach to shuffling the elements of an array is to write some
 * code as described below. As of Java 2 the java.util.Collections class
 * contains a static shuffle(list) method, which is described at the bottom.
 * 
 * @author zluo
 * 
 */
public class StatisticEx {

	static int[] cards = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 1, 2, 3, 4,
			5, 6, 7, 8, 9, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,};

	static int win = 0;
	static int lose = 0;
	static Stack<Integer> stack = new Stack<Integer>();

    static int[] winList = new int[21];
    static int[] loseList = new int[21];
    static int[] safeList = new int[21];
    static int[] twoCardsList= new int[21];
				
	static void shuffle() {
		Random rgen = new Random();

		for (int i = 0; i < cards.length; i++) {
			int randomPosition = rgen.nextInt(cards.length);
			int temp = cards[i];
			cards[i] = cards[randomPosition];
			cards[randomPosition] = temp;
		}
	}

	public static void main(String[] args) {
				
	for(int j=0; j<1000; j++)
	{
		shuffle();
		for (int i = 0; i < cards.length; i++) {
			int value = cards[i];
            
			count(value);
//			System.out.print(" " + i);
		}
	}
	System.out.printf("\nWin: %d Lose: %d Rate: %3.2f", win, lose, + win*100.0/lose);
	for(int i=10; i<21; i++)
	{
		String.format("\nC(%d) W(%d) S(%d) L(%d) W/L(%3.2f) S/L(%3.2f) (W+S)/L(%3.2f)", i,  winList[i], safeList[i], loseList[i], 
				winList[i]*1.0/loseList[i],safeList[i]*1.0/loseList[i],(winList[i]+safeList[i])*1.0/loseList[i]);
		System.out.printf("\nC(%d) W(%d) S(%d) L(%d) W/L(%3.2f) S/L(%3.2f) (W+S)/L(%3.2f)", i,  winList[i], safeList[i], loseList[i], 
				winList[i]*1.0/loseList[i],safeList[i]*1.0/loseList[i],(winList[i]+safeList[i])*1.0/loseList[i]);
		
	}
	}

	public static void count(int i) {
        
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(i);
		if (i==1)temp.add(11);
		
		while (!stack.empty()) {
			int value = stack.pop();
			int result = value + i;
			if (result == 21) {
				winList[value]=winList[value]+1;
				win++;
			} else if (result > 21) {
				loseList[value]=loseList[value]+1;
				lose++;
			} else {
				temp.add(result);
				safeList[value]=safeList[value]+1;
				if (i==1)
                {
                	result=value +11;
                	if (result == 21) {
                		winList[value]=winList[value]+1;
        				win++;
                	}
                	else if (result < 21)
                	{
                        safeList[value]=safeList[value]+1;
                		temp.add(result);
                	}
                }
			}
		}

		for(Integer result: temp)
		{
			stack.push(result);
		}
	}
	
}
