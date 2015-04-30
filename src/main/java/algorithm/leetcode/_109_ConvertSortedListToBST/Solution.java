package algorithm.leetcode._109_ConvertSortedListToBST;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.leetcode.ListNode;
import algorithm.leetcode.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
	return null;
	
    }
    
    @Test
    public void test5(){
	ListNode head = ListNode.create(1,2,3,4,5);
	TreeNode node = sortedListToBST(head);
	assertEquals(3, node.val);
	assertEquals(1, node.left.val);
	assertEquals(2, node.left.right.val);
	assertEquals(4, node.right.val);
	assertEquals(5, node.right.right.val);
    }
    
    @Test
    public void test(){
	ListNode head = ListNode.create(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15); 
    }
    
}
