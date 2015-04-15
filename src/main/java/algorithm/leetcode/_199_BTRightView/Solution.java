package algorithm.leetcode._199_BTRightView;

import java.util.LinkedList;
import java.util.List;

import algorithm.leetcode.TreeNode;

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
    
}
