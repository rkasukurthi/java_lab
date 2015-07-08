package datastructure.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.TreeNode;

/**
 * Count BST nodes that lie in a given range
Given a Binary Search Tree (BST) and a range, count number of nodes that lie in the given range.

Examples:

Input:
        10
      /    \
    5       50
   /       /  \
 1       40   100
Range: [5, 45]

Output:  3
There are three nodes in range, 5, 10 and 40
 * @author zluo
 *
 */
public class CountBSTNodes {
    int count=0;
    public int count(TreeNode node, int left, int right){
	 countNodes(node, left, right);
	 return count;
    }
    public void countNodes(TreeNode node, int left, int right){
	if (node !=null){
	    if (node.val>=left && node.val<=right) count++;
	    countNodes(node.left, left, right);
	    countNodes(node.right, left, right);
	}
    }
    
    @Test
    public void test(){
	TreeNode root = new TreeNode(10);
	TreeNode.insert(root, 5);
	TreeNode.insert(root, 50);
	TreeNode.insert(root, 1);
	TreeNode.insert(root, 40);
	TreeNode.insert(root, 100);
	
	assertEquals(3, count(root, 5,45));
    }
    
    
}
