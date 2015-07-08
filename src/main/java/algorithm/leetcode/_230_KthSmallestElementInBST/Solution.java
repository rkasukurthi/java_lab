package algorithm.leetcode._230_KthSmallestElementInBST;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * 
 * The idea is traverse the tree inOrder, so the tree is sorted
 * 
 * @author zluo
 *
 */
public class Solution {
    int k = 0;
    int value = 0;
    
    public int kthSmallest(TreeNode root, int k) {
	this.k = k;
	try {
	    inOrder(root);
	} catch (Exception e) {
	}
	return value;
    }
    
    void inOrder(TreeNode node) throws Exception {
	if (node == null)
	    return;
	inOrder(node.left);
	if (--k == 0) {
	    value = node.val;
	    throw new Exception();
	}
	inOrder(node.right);
    }
    @Test
    public void test1() {
	
	TreeNode root = new TreeNode(10);
	TreeNode.insert(root, 5);
	TreeNode.insert(root, 50);
	TreeNode.insert(root, 1);
	TreeNode.insert(root, 40);
	TreeNode.insert(root, 100);
	
	assertEquals(1, kthSmallest(root, 1));
	assertEquals(5, kthSmallest(root, 2));
	assertEquals(10, kthSmallest(root, 3));
	assertEquals(40, kthSmallest(root, 4));
	assertEquals(50, kthSmallest(root, 5));
	assertEquals(100, kthSmallest(root, 6));
    }
}
