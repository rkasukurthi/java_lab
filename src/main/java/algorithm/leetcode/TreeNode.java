package algorithm.leetcode;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  public static TreeNode insert(TreeNode root, int val) {
    TreeNode newNode = new TreeNode(val);
    if (root == null)
      return newNode;
    TreeNode current = root;
    TreeNode parent;
    while (true) {
      parent = current;
      if (val < current.val) {
        current = current.left;
        if (current == null) {
          parent.left = newNode;
          return root;
        }
      } else {
        current = current.right;
        if (current == null) {
          parent.right = newNode;
          return root;
        }
      }
    }
  }
}
