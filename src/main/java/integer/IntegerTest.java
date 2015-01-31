package integer;

import org.junit.Test;

public class IntegerTest {
	
	@Test
	public void testBitCount(){

		     int i = -1;
		     System.out.println("Number = " + i);
		    
		     /* returns the string representation of the unsigned integer value 
		     represented by the argument in binary (base 2) */
		     System.out.println("Binary = " + Integer.toBinaryString(i));

		     // returns the number of one-bits 
		     System.out.println("Number of one bits = " + Integer.bitCount(i)); 
		   }

}
