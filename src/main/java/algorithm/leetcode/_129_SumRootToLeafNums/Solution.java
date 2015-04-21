package algorithm.leetcode._129_SumRootToLeafNums;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author zluo
 *
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
	return sum(root, 0);
    }
    
    int sum(TreeNode node, int curVal) {
	if (node == null) return 0;
	curVal = curVal * 10 + node.val;
	if (node.left == null && node.right == null) {
	    return curVal;
	}
	return sum(node.left, curVal) + sum(node.right, curVal);
    }
    
    @Test
    public void test0() {
	TreeNode root = new TreeNode(1);
	
	assertEquals(1, sumNumbers(root));
	
    }
    
    @Test
    public void test1() {
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	
	assertEquals(25, sumNumbers(root));
	
    }
    
    @Test
    public void test2() {
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.left.right = new TreeNode(3);
	
	assertEquals(123, sumNumbers(root));
    }
    
}
