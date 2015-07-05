package algorithm.leetcode._025_ReverseNodeInK;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author zluo
 *
 */
public class Solution {
    public int f(int i) {
	return i;
    }
    
    @Test
    public void test1() {
	assertEquals(1, f(1));
    }
}
