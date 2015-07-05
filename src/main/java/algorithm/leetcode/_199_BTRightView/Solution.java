package algorithm.leetcode._199_BTRightView;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the
 * nodes you can see ordered from top to bottom.
 * 
 * For example: Given the following binary tree, 1 <--- / \ 2 3 <--- \ \ 5 4 <--- You should return
 * [1, 3, 4].
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import algorithm.leetcode.TreeNode;

/**
 * * @author zluo
 * 
 */
public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new LinkedList<Integer>();
    if (root != null) {
      List<TreeNode> layers = new ArrayList<TreeNode>();
      layers.add(root);
      while (layers.size() > 0) {
        list.add(layers.get(layers.size() - 1).val);
        layers = findNextLayer(layers);
      }
    }
    return list;
  }

  public List<TreeNode> findNextLayer(List<TreeNode> nodes) {
    List<TreeNode> list = new ArrayList<TreeNode>();
    for (TreeNode node : nodes) {
      if (node.left != null) {
        list.add(node.left);
      }
      if (node.right != null) {
        list.add(node.right);
      }
    }
    return list;
  }

  @Test
  public void test1() {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(3);
    node.left.right = new TreeNode(5);
    node.right.right = new TreeNode(4);
    List list = rightSideView(node);
    assertEquals(1, list.get(0));
    assertEquals(3, list.get(1));
    assertEquals(4, list.get(2));
  }
}
