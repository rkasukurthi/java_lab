package pattern.creational.singleton;
/**
 * First style of singleton example, has a private static instance
 * @author zluo
 *
 */

public class SingletonExample1 {
	
	private static SingletonExample1 instance = new SingletonExample1();
	
	/**
	 * make the contructor private, prevent instance creating from using the new keyword.
	 */
	private SingletonExample1() {
		super();
	}


	static public SingletonExample1 getInstance()
	{
		return instance;
	}

}
