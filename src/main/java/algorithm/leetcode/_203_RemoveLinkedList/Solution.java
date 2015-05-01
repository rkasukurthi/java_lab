package algorithm.leetcode._203_RemoveLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 *  Return: 1 --> 2 --> 3 --> 4 --> 5
 *  
 *  This is a example that recurrsion will call at the end of the linkedlist, then return one by one.
 *  the current linkedList point is stored in the stacktrace.
 *  
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
	if (head==null) return null;
	head.next =removeElements(head.next,val);
        return head.val==val? head.next: head;
    }
    
    @Test
    public void test(){
	ListNode head = ListNode.create(1,2,6,3,4,5,6);
	ListNode node =removeElements(head, 6);
	assertEquals(node.val, 1);
	assertEquals(node.next.val, 2);
	assertEquals(node.next.next.val, 3);
    }
    
}