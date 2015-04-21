package algorithm.leetcode._141_LinkedListCycle;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @see http://codingfreak.blogspot.com/2012/09/detecting-loop-in-singly-linked-list_22.html
 * @author zluo
 *
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
	if (head == null || head.next == null)
	    return false;
	if (head.next == head)
	    return true;
	ListNode nextNode = head.next;
	head.next = head;
	boolean isCycle = hasCycle(nextNode);
	return isCycle;
    }
    
    @Test 
    public void test(){
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	node1.next=node2;
	node2.next=node3;
	node3.next=node4;
	node4.next=node2;
	
	assertTrue(hasCycle(node1));
	assertEquals(1,node1.val);
	assertEquals(2,node1.next.val);
	assertEquals(3,node1.next.next.val);
	assertEquals(4,node1.next.next.next.val);
	assertEquals(2,node1.next.next.next.next.val);
	
    }
}
