package algorithm.leetcode._147_InsertionSortList;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.ListNode;

/** Sort a linked list using insertion sort. */
public class Solution {
	public ListNode insertionSortList(ListNode head) {
		ListNode sortedHead = new ListNode(-1);
		ListNode node ;
		while(head !=null){
		    node= head;
			head=head.next;
			node.next=null;   // fetch one node from list.
			insert(node, sortedHead);
		}
		return sortedHead.next;
	}
	
	public void insert(ListNode node, ListNode sortedHead){
		ListNode cur=sortedHead;
		while(cur.next !=null){
			if (node.val <cur.next.val){
				node.next=cur.next;
				cur.next=node;
				return;
			}
			cur=cur.next;
		}
		cur.next=node;
	}
	
	
	@Test
	public void test1(){
		ListNode head = ListNode.create(7,8,2,5,9,1,0,4,3,6);
		head = insertionSortList(head);
		int i=0;
		while(head.next()!=null){
			assertEquals(i, head.val);
			head=head.next();
			i++;
		}
	}

}
