package algorithm.leetcode._142_LinkedListCycleII;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.leetcode.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii-solution.html
 * 
 * @author zluo
 *
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
	ListNode fast = head;
	ListNode slow = head;
	while (true) {
	    if (fast == null)
		return null;
	    fast = fast.next;
	    if (fast == null)
		return null;
	    fast = fast.next;
	    slow = slow.next;
	    if (fast == slow)
		break;
	}
	slow = head;
	while (slow != fast) {
	    slow = slow.next;
	    fast = fast.next;
	}
	return slow;
	
    }
    
    @Test
    public void test() {
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node2;
	
	assertTrue(node2 == detectCycle(node1));
	assertEquals(1, node1.val);
	assertEquals(2, node1.next.val);
	assertEquals(3, node1.next.next.val);
	assertEquals(4, node1.next.next.next.val);
	assertEquals(2, node1.next.next.next.next.val);
	
    }
}
