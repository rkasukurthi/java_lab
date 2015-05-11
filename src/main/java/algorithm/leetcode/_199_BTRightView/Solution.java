package algorithm.leetcode._199_BTRightView;
/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import algorithm.leetcode.TreeNode;

/**
 * 
 * @author zluo
 *
 */
public class Solution {
    List<Integer> list = new LinkedList<Integer>();
    int layers = 0;
    public List<Integer> rightSideView(TreeNode root) {
	
	if (root != null) {
	    pushNode(root);
	}
	return list;
    }
    
    public void pushNode(TreeNode node){
	list.add(node.val);
	layers++;
    }
    
    @Test
    public void test1(){
	TreeNode node = new TreeNode(1);
	node.left = new TreeNode(2);
	node.right = new TreeNode(3);
	node.left.right= new TreeNode(5);
	node.right.right= new TreeNode(4);
	List list = rightSideView(node);
	assertEquals(1,list.get(0));
	assertEquals(3,list.get(1));
	assertEquals(4,list.get(2));
    }
}
