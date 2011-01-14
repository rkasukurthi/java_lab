package pattern.creational.singleton;

import junit.framework.TestCase;

public class SingletonExample1Test extends TestCase{

	/**
	 * This test case will test the instnace get from the singleton pattern are the same object.
	 */
	public void testSameObjectsForexample1()
	{
        // This declartion is not work, since contractor are private.  
		//		SingletonExample1 se1 = new SingletonExample1();
		
		SingletonExample1 se1 = SingletonExample1.getInstance();
		SingletonExample1 se2 = SingletonExample1.getInstance();
		
		// test se1==se2
		
		assertTrue(se1==se2);
	}
	
	public void testSameObjectsForexample2()
	{
        // This declartion is not work, since contractor are private.  
		//		SingletonExample1 se1 = new SingletonExample1();
		
		SingletonExample2 se1 = SingletonExample2.getInstance();
		SingletonExample2 se2 = SingletonExample2.getInstance();
		
		// test se1==se2
		
		assertTrue(se1==se2);
	}
    /**
     * If we can using class.forName to get the new instance ?
     * Even though we can get the Class, but we still can not instatiation it, it will throw runtime exception 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    
	public void testForName() 
	{
	  String className = SingletonExample1.class.getName();
	  try {
		SingletonExample1 se1= (SingletonExample1) Class.forName(className).newInstance();
	} catch (InstantiationException e) {
		assertTrue(true);
	} catch (IllegalAccessException e) {
		assertTrue(true);
	} catch (ClassNotFoundException e) {
		assertTrue(true);
	}
	}
}
