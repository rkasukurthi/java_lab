package algorithm.leetcode._173_BSTIterator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author zluo
 *
 */
public class Solution {
    
    @Test
    public void test1() {
	assertEquals(1, f(1));
    }
}
