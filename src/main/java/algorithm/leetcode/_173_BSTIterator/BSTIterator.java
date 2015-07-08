package algorithm.leetcode._173_BSTIterator;

import java.util.Stack;

import algorithm.leetcode.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author zluo
 *
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
	pushLeftNodes(root);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
	return !stack.isEmpty();
    }
    
    /** @return the next smallest number */
    public int next() {
	TreeNode node = stack.pop();
	pushLeftNodes(node.right);
	return node.val;
    }
    
    /** push all left node to the stack */
    private void pushLeftNodes(TreeNode node) {
	while (node != null) {
	    stack.push(node);
	    node = node.left;
	}
    }
}