package algorithm.leetcode._146_LRUCache;
/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 *http://www.javaspecialists.eu/archive/Issue073.html
 */

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
public class LRUCache {
    private Map<Integer, Integer> map;
    private int capacity;
    
    public LRUCache(int capacity) {
	map=new LinkedHashMap<Integer, Integer>(capacity, 1, true); //set access order to true
	this.capacity = capacity;
    }
    
    public int get(int key) {
	if (!map.containsKey(key)) return -1;
	return map.get(key);
    }
    
    public void set(int key, int value) {
	if (!map.containsKey(key) && (map.size() == capacity)) {
	    map.remove(map.keySet().iterator().next());
	}
	map.put(key, value);
    }

    
    @Test
    public void test2() {
	assertEquals(-1, get(0));
	set(1, 1);
	set(2, 2);
	set(3, 3);
	get(1);
	set(4, 4);
	assertEquals(-1, get(2));
    }
}
