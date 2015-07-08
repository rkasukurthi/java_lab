package algorithm.leetcode._094_BinaryTreeInorder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import algorithm.leetcode.TreeNode;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> result = new ArrayList<Integer>();
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode cur = root;
	while(true){
	   while (cur !=null){
	       stack.push(cur); 
	       cur=cur.left;
	   }
	   if (stack.isEmpty()){
	       break;
	   }
	   cur = stack.pop();
	   result.add(cur.val);
           cur =cur.right;	   
	}
	return result;
    }
    
    @Test
    public void test1() {
	TreeNode root = new TreeNode(10);
	TreeNode.insert(root, 5);
	TreeNode.insert(root, 50);
	TreeNode.insert(root, 1);
	TreeNode.insert(root, 40);
	TreeNode.insert(root, 100);
	System.out.println(Arrays.toString(inorderTraversal(root).toArray()));
    }
}
