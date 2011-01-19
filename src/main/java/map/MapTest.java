package map;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class MapTest extends TestCase {

public MapTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

/**
 * HashSet is a special use of HashMap, it use the item as the HashMap's key.
 * 
 */
	 public void testHashSet()
	{
		Set set=new HashSet();
		set.add("1");
		set.add("1");
	}
	 
	 

}
