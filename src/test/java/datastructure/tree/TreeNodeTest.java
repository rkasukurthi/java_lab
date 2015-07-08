package datastructure.tree;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import algorithm.leetcode.TreeNode;

public class TreeNodeTest {
    @Test
    public void testSize() {
	TreeNode root = new TreeNode(0);
	root = TreeNode.insert(root, 1);
	assertEquals(0, root.val);
	assertEquals(1, root.right.val);
	assertEquals(2, root.size());
    }
    
    
    @Test
    public void testSizeTraverse() {
	TreeNode root = new TreeNode(5);
	root = TreeNode.insert(root, 3);
	root = TreeNode.insert(root, 7);
	root = TreeNode.insert(root, 2);
	root = TreeNode.insert(root, 9);
	root = TreeNode.insert(root, 6);
	root = TreeNode.insert(root, 8);
	root = TreeNode.insert(root, 1);
	root = TreeNode.insert(root, 4);
	assertEquals(9, root.size());
	
	System.out.println("[InOrder] " + Arrays.toString(TreeNode.inOrder(root)));
	System.out.println("[PreOrder] " + Arrays.toString(TreeNode.preOrder(root)));
	System.out.println("[PostOrder] " + Arrays.toString(TreeNode.postOrder(root)));
	System.out.println("[BFS] " + Arrays.toString(TreeNode.bfs(root)));
    }
    
    @Test
    public void testSizeDelete() {
	TreeNode root = new TreeNode(50);
	root = TreeNode.insert(root, 30);
	root = TreeNode.insert(root, 20);
	root = TreeNode.insert(root, 40);
	root = TreeNode.insert(root, 70);
	root = TreeNode.insert(root, 60);
	root = TreeNode.insert(root, 80);
	
	assertEquals(7, root.size());
	System.out.println("[InOrder] " + Arrays.toString(TreeNode.inOrder(root)));
	root= TreeNode.delete(root, 50);
        assertEquals(60, root.val);
        assertEquals(6, root.size());
	System.out.println("[InOrder] " + Arrays.toString(TreeNode.inOrder(root)));
	
	root= TreeNode.delete(root, 80);
	assertEquals(5, root.size());
	System.out.println("[InOrder] " + Arrays.toString(TreeNode.inOrder(root)));
	
	root= TreeNode.delete(root, 20);
	assertEquals(4, root.size());
	System.out.println("[InOrder] " + Arrays.toString(TreeNode.inOrder(root)));
    }
}
