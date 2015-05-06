package algorithm.leetcode._206_ReverseLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
	ListNode temp =null;
	ListNode previous =null;
	while (head !=null){
	    temp=head.next;
	    head.next=previous;
	    previous=head;
	    if (temp==null) return head;
	    head=temp;
	}
	return head;
    }
    
    @Test
    public void test1() {
	ListNode node = ListNode.create(5,4,3,2,1);
	ListNode reverse =reverseList(node);
	assertEquals(1, reverse.val);
	assertEquals(2, reverse.next.val);
	assertEquals(3, reverse.next.next.val);
	assertEquals(4, reverse.next.next.next.val);
	assertEquals(5, reverse.next.next.next.next.val);
    }
}
