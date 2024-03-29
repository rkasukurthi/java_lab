package algorithm.leetcode._002_AddTwoNumbers;

import org.junit.Test;

import algorithm.leetcode.ListNode;
import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 }
 * 
 * [Review] 24/04/2015 It's possible to get rid of root? yes. handle some conditions in front, then reduce
 * if/else in the rest of code.
 * 
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	if (l1==null) return l2;
	ListNode result=l1;
	while (l1 !=null && l2!=null){
	    add(l1, l2.val);
	    l2=l2.next;
	    if (l1.next !=null){
		l1 =l1.next;
	    }else{
		break;
	    }
	}
	if (l2 !=null)	l1.next=l2;
	return result;
    }
    
    /**
     * Recurrsion when sum great than 10. 
     * @param result
     * @param operand
     */
    private void add(ListNode result, int operand){
	int i =result.val + operand;
	if (i<10){
	    result.val=i;
	}
	else{
	    result.val=i%10;
	    if (result.next==null){
		result.next= new ListNode(1);
	    }else{
		add(result.next,1);
	    }
	}
    }
    
    @Test
    public void testIncrementalResult(){
	ListNode n1 = ListNode.create(9,9,9);
	ListNode ret = ListNode.create(8,0,0,1);
	add(n1,9);
	assertReflectionEquals(ret.toArray(), n1.toArray());
    }

    @Test
    public void testCase0(){
	ListNode n1 = ListNode.create(2);
	ListNode n2 = ListNode.create(5,6);
	ListNode ret =ListNode.create(7,6);
	assertReflectionEquals(ret.toArray(), addTwoNumbers(n1, n2).toArray());
    }
    

    
    @Test
    public void testCase1(){
	ListNode n1 = ListNode.create(2,4,3);
	ListNode n2 = ListNode.create(5,6,4);
	ListNode ret =ListNode.create(7,0,8);
	assertReflectionEquals(ret.toArray(), addTwoNumbers(n1, n2).toArray());
    }
    
    /** Test null **/
    @Test
    public void testCase2(){
	/** Both are null **/
	ListNode n1 = null;
	ListNode n2 = null;
	ListNode ret =null;
	assertNull(addTwoNumbers(n1, n2));
      
	/** n1 are null **/
	n1 = null;
	n2 = ListNode.create(5,6,4);
	ret =n2;
	assertReflectionEquals(ret.toArray(), addTwoNumbers(n1, n2).toArray());
	
	/** n2 are null **/
	n1 = ListNode.create(2,4,3);
	n2 = null;
	ret =n1;
	assertReflectionEquals(ret.toArray(), addTwoNumbers(n1, n2).toArray());
    
    }
    
    /** n1 and n2 are not in same digits**/
    @Test
    public void testCase3(){
	ListNode n1 = ListNode.create(2,4);
	ListNode n2 = ListNode.create(5,6,9);
	ListNode ret =ListNode.create(7,0,0,1);
	assertReflectionEquals(ret, addTwoNumbers(n1, n2));
    }
    
    @Test
    public void testCase4(){
	ListNode n1 = ListNode.create(9,9,9);
	ListNode n2 = ListNode.create(5,6);
	ListNode ret =ListNode.create(4,6,0,1);
	assertReflectionEquals(ret.toArray(), addTwoNumbers(n1, n2).toArray());
    }
}