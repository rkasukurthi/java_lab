package map;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;

public class MapTest extends TestCase {
    
    public MapTest(String name) {
	super(name);
    }
    
    /**
     * HashSet is a special use of HashMap, it use the item as the HashMap's
     * key.
     * 
     */
    public void testHashSet() {
	Set set = new HashSet();
	set.add("1");
	set.add("1");
    }
    
    final int hash(int k) {
	int h = 211710003;
	h ^= k;
	
	// This function ensures that hashCodes that differ only by
	// constant multiples at each bit position have a bounded
	// number of collisions (approximately 8 at default load factor).
	h ^= (h >>> 20) ^ (h >>> 12);
	return h ^ (h >>> 7) ^ (h >>> 4);
    }
    
    /**
     * Returns index for hash code h.
     */
    static int indexFor(int h, int length) {
	// assert Integer.bitCount(length) == 1 :
	// "length must be a non-zero power of 2";
	return h & (length - 1);
    }
    
    @Test
    public void testHash() {
	int h = hash(15);
	System.out.println("Hash: " + h);
    }
    
}
