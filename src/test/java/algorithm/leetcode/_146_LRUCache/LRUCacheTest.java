package algorithm.leetcode._146_LRUCache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LRUCacheTest {
    @Test
    public void test2() {
	LRUCache cache = new LRUCache(2);
	assertEquals(-1, cache.get(2));
	cache.set(2, 6);
	assertEquals(-1, cache.get(1));
	cache.set(1, 5);
	cache.set(1, 2);
	assertEquals(2, cache.get(1));
	assertEquals(6, cache.get(2));
    }
    
    @Test
    public void test3() {
	LRUCache cache = new LRUCache(2);
	cache.set(2,1);
	cache.set(1,1);
	cache.set(2,3);
	cache.set(4,1);
	assertEquals(-1, cache.get(1));
	assertEquals(3, cache.get(2));
    }
}
