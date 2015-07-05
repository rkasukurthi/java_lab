package algorithm.leetcode._226_InvertBinaryTree;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import algorithm.leetcode.TreeNode;
/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * @author zluo
 *
 */
public class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root !=null) {
      TreeNode tmp= invertTree(root.left);
      root.left=invertTree(root.right);
      root.right=tmp;
    }
    return root;
  }
  
   @Test
   public void test1() {
   TreeNode node = new TreeNode(4);
   node.left = new TreeNode(2);
   node.right = new TreeNode(7);
   node.left.left = new TreeNode(1);
   node.left.right = new TreeNode(3);
   node.right.left = new TreeNode(6);
   node.right.right = new TreeNode(9);
   node = invertTree(node);
   assertEquals(4, node.val);
   assertEquals(7, node.left.val);
   assertEquals(2, node.right.val);
   assertEquals(9, node.left.left.val);
   assertEquals(6, node.left.right.val);
   assertEquals(3, node.right.left.val);
   assertEquals(1, node.right.right.val);
   }
}
