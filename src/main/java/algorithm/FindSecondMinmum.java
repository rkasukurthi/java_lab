package algorithm;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class FindSecondMinmum {

	public int[] findMinAndSecond(int[] a) {
		Stack s = new Stack();
		int[] r = { a[0], Integer.MAX_VALUE };
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				s.push(min);
				min = a[i];
			}
		}
		r[0] = min;
		r[1] = (int) s.pop();
		return r;
	}

	@Test
	public void testFindMinAndSecondCase1() {
		int[] a = { 2, 1, 5, 7, 4, 2, 2, 2, 1 };
		int r[] = findMinAndSecond(a);
		assertEquals(1, r[0]);
		assertEquals(2, r[1]);
	}
	
	@Test
	public void testFindMinAndSecondCase2() {
		int[] a = { 2, 1, 5, 7, 4, 2, 2, 2, 1 };
		int r[] = findMinAndSecond(a);
		assertEquals(1, r[0]);
		assertEquals(2, r[1]);
	}

	@Test
	public void testFindMinAndSecondCase3() {
		int[] a = { 2, 1, 5, 7, 4, 2, 2, 2, 1 };
		int r[] = findMinAndSecond(a);
		assertEquals(1, r[0]);
		assertEquals(2, r[1]);
	}
	
	@Test
	public void testFindMinAndSecondCase4() {
		int[] a = { 1, 3, 2, 5, 7, 4, 2, 2, 2, 1 };
		int r[] = findMinAndSecond(a);
		assertEquals(1, r[0]);
		assertEquals(2, r[1]);
	}
	
	@Test
	public void testFindMinAndSecondCase5() {
		int[] a = { 2, 3, 5, 7, 4, 2, 2, 2, 1 };
		int r[] = findMinAndSecond(a);
		assertEquals(1, r[0]);
		assertEquals(2, r[1]);
	}
	
	@Test
	public void testFindMinAndSecondCase6() {
		int[] a = { 1, 2, 5, 7, 4, 2, 2, 2, 1 };
		int r[] = findMinAndSecond(a);
		assertEquals(1, r[0]);
		assertEquals(2, r[1]);
	}
	
	@Test
	public void testFindMinAndSecondCase7() {
		int[] a = { 1, 1, 1, 1, 1, 2 };
		int r[] = findMinAndSecond(a);
		assertEquals(1, r[0]);
		assertEquals(2, r[1]);
	}
	
	@Test
	public void testFindMinAndSecondCase8() {
		int[] a = { 2, 2, 2, 2, 1 };
		int r[] = findMinAndSecond(a);
		assertEquals(1, r[0]);
		assertEquals(2, r[1]);
	}
	
	@Test
	public void testFindMinAndSecondCase9() {
		int[] a =  { 1, 1, 1, 1, 1 };
		int r[] = findMinAndSecond(a);
		assertEquals(1, r[0]);
		assertEquals(2, r[1]);
	}

}
