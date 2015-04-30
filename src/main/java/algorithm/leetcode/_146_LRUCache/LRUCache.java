package algorithm.leetcode._146_LRUCache;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 *
 */
public class LRUCache {
    private Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    private int capacity;
    
    public LRUCache(int capacity) {
	this.capacity = capacity;
    }
    
    public int get(int key) {
	if (!map.containsKey(key)) return -1;
	int val;
	    val = map.get(key);
	    set(key, val);
	return val;
    }
    
    public void set(int key, int value) {
	if (!map.containsKey(key) && (map.size() == capacity)) {
	    map.remove(map.keySet().iterator().next());
	}
	map.remove(key);
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
