package algorithm.mathResolver;
import static org.junit.Assert.*;

import org.junit.Test;


public class MathResolverTest {
	
	
	@Test
	public void testIsMeet()
	{
		MathResolver mr= new MathResolver();
		System.out.println(mr.findPossibility(20).size());
		assertTrue (mr.findPossibility(20).size()==2);
		assertTrue (mr.findPossibility(1).size()==4);
		assertTrue (mr.findPossibility(25).size()==2);
	}
	
	@Test
	public void testPossibility()
	{
		assertTrue (MathResolver.isSquare(1,3));
		assertTrue (MathResolver.isSquare(1,8));
		assertTrue (MathResolver.isSquare(2,23));
		assertTrue (MathResolver.isSquare(4,32));
		assertTrue (MathResolver.isSquare(8,41));
	}

}
