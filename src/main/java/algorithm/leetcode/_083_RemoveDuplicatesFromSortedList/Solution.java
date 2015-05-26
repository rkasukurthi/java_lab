package algorithm.leetcode._083_RemoveDuplicatesFromSortedList;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.ListNode;

public class Solution {
   public ListNode deleteDuplicates(ListNode head) {
       ListNode next=head; 
       while(next !=null && next.next!=null){
          if(next.val==next.next.val){
              next.next=next.next.next;
	   }else{
	       next=next.next;
	   }
       }
       return head;       
    }
	
	@Test
	public void test1(){
	    ListNode head =ListNode.create(1,1,1,1,3,3);
		assertEquals(3,deleteDuplicates(head).next.val);
	}
	@Test
	public void test2(){
	    ListNode head =ListNode.create(1,2,2);
	    assertEquals(2,deleteDuplicates(head).next.val);
	    assertEquals(null,deleteDuplicates(head).next.next);
	}
}
