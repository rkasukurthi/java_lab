package pattern.creational.singleton;

/**
 * First style of singleton example, has a private static instance
 * @author zluo
 *
 */

public class SingletonExample2 {
	
	private static SingletonExample2 instance;
	
	/**
	 * make the contructor private, prevent instance creating from using the new keyword.
	 */
	private SingletonExample2() {
		super();
	}

    /**
     * In this case, using lazy load, and synchronied the getInstance method.
     * @return
     */
	static synchronized public SingletonExample2 getInstance()
	{
		if (instance==null) 
		{
			instance = new SingletonExample2();
		}
		return instance;
	}

}
