package algorithm.leetcode._108_ConvertSortedArrayToBST;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * @author zluo
 *
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
	return addTreeNode(0, num.length-1, num);
    }
    
    public TreeNode addTreeNode(int s, int e, int[] num){
	if (s>e) return null;
	TreeNode node = new TreeNode(num[(s+e)/2]);
	node.left=addTreeNode(s,(s+e)/2-1, num);
	node.right= addTreeNode((s+e)/2+1, e, num);
	return node;
    }
    
    @Test
    public void test(){
	int[] a ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	TreeNode node = sortedArrayToBST(a);
    }
    
    @Test
    public void test1(){
	int[] a ={1};
	TreeNode node = sortedArrayToBST(a);
	assertEquals(1, node.val);
    }
    
    @Test
    public void test2(){
	int[] a ={1,2,3};
	TreeNode node = sortedArrayToBST(a);
	assertEquals(2, node.val);
	assertEquals(1, node.left.val);
	assertEquals(3, node.right.val);
    }
    @Test
    public void test3(){
	int[] a ={};
	TreeNode node = sortedArrayToBST(a);
	assertEquals(null, node);
    }
    
    @Test
    public void test4(){
	int[] a ={1,2,3,4};
	TreeNode node = sortedArrayToBST(a);
	assertEquals(2, node.val);
	assertEquals(1, node.left.val);
	assertEquals(3, node.right.val);
	assertEquals(4, node.right.right.val);
    }
    @Test
    public void test5(){
	int[] a ={1,2,3,4,5};
	TreeNode node = sortedArrayToBST(a);
	assertEquals(3, node.val);
	assertEquals(1, node.left.val);
	assertEquals(2, node.left.right.val);
	assertEquals(4, node.right.val);
	assertEquals(5, node.right.right.val);
    }
}
