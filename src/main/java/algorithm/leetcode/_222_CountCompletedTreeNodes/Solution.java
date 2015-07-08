package algorithm.leetcode._222_CountCompletedTreeNodes;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.leetcode.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * @author zluo
 *
 */
public class Solution {
   int count=0;
   public int countNodes(TreeNode root) {
        count(root);
        return count;
    }
    
   public void count(TreeNode node){
       if (node==null) return;
       if (node.left==null && node.right==null){
	   count++;
	   return;
       }
       int leftHeight= height(node.left);
       int rightHeight= height(node.right);
       
       if (leftHeight==rightHeight){
	   count += 1 << leftHeight;
	   count(node.right);
       }else{
	   count += 1 << rightHeight;
	   count(node.left);
       }
   }
   
   public int height(TreeNode node){
       int height=0;
       while (node !=null){
	   node=node.left;
	   height++;
       }
       return height;
   }
   
   public void count1(TreeNode node){
       if (node !=null){
	   count++;
	   count(node.left);
	   count(node.right);
       }
   }
   
    @Test
    public void test1() {
	TreeNode root = new TreeNode(1);
	root.left=new TreeNode(2);
	root.right=new TreeNode(3);
	assertEquals(3, countNodes(root));
    }
    
    @Test
    public void test2() {
	TreeNode root = new TreeNode(1);
	root.left=new TreeNode(2);
	assertEquals(2, countNodes(root));
    }
}
