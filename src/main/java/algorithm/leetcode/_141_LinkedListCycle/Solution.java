package algorithm.leetcode._141_LinkedListCycle;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * Let us take 2 pointers namely slow Pointer and fast Pointer to traverse a
 * Singly Linked List at different speeds. A slow Pointer (Also called Tortoise)
 * moves one step forward while fast Pointer (Also called Hare) moves 2 steps
 * forward Start Tortoise and Hare at the first node of the List. If Hare
 * reaches end of the List, return as there is no loop in the list. Else move
 * Hare one step forward. If Hare reaches end of the List, return as there is no
 * loop in the list. Else move Hare and Tortoise one step forward. If Hare and
 * Tortoise pointing to same Node return, we found loop in the List. Else start
 * with STEP-2.
 * 
 * @see http
 *      ://codingfreak.blogspot.com/2012/09/detecting-loop-in-singly-linked-
 *      list_22 .html
 * @author zluo
 *
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
	ListNode fast = head;
	ListNode slow = head;
	while (true) {
	    if (fast == null)
		return false;
	    fast = fast.next;
	    if (fast == null)
		return false;
	    fast = fast.next;
	    slow = slow.next;
	    if (fast == slow)
		return true;
	}
    }
    
    
    public boolean hasCycle1(ListNode head) {
        if (head==null||head.next==null) return false;
        else
        {
            ListNode slow=head;
            ListNode fast=head.next;
            while((System.identityHashCode(fast.next)!=System.identityHashCode(head) )&&(fast.next!=null))
            {
                fast=fast.next;
                fast=fast.next;
                slow=slow.next;
                if (slow==fast) return true;
            }
            return (fast.next==null);
        }
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
	
	assertTrue(hasCycle1(node1));
	assertEquals(1, node1.val);
	assertEquals(2, node1.next.val);
	assertEquals(3, node1.next.next.val);
	assertEquals(4, node1.next.next.next.val);
	assertEquals(2, node1.next.next.next.next.val);
	
    }
}
