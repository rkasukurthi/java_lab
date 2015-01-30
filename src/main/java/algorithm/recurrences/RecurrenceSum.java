package algorithm.recurrences;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecurrenceSum {
	
	public int sum(int n){
	 if (0==n) return 0;
	 else return n + sum(n-1);
	}

	@Test
	public void test(){
		assertEquals(6, sum(3));
	}
	
}
