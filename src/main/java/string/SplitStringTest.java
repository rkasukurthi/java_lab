package string;

import junit.framework.TestCase;

public class SplitStringTest extends TestCase {
	

	public SplitStringTest(String name) {
		super(name);
	}

	public void testSingleString()
	{
		String test1="test1";
		
		assertEquals(test1.split(",").length, 1);
		assertEquals(test1.split(",")[0], "test1");
	}
	public void testEmptyString()
	{
		String test1="";
		
		assertEquals(test1.split(",").length, 1);
		assertEquals(test1.split(",")[0], "");
	}
	
	public void testSingleSeparator()
	{
		String test1=",";
		
		assertEquals(test1.split(",").length, 0);
	}

	public void testSingleStringWithSeparator()
	{
		String test1="test1,";
		
		assertEquals(test1.split(",").length, 1);
		assertEquals(test1.split(",")[0], "test1");
	}

	public void testStringWithSeparator()
	{
		String test1="test1,test2";
		
		assertEquals(test1.split(",").length, 2);
		assertEquals(test1.split(",")[0], "test1");
		assertEquals(test1.split(",")[1], "test2");
	}

	public void testNullArray()
	{
		String[] array= new String[0];
		
		for(String s: array)
		{
			System.out.println(s);
		}
	}

}
