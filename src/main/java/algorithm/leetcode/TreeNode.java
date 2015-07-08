package algorithm.leetcode;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int x) {
	val = x;
    }
    
    public static TreeNode insert(TreeNode root, int key) {
	if (root == null){
	    return new TreeNode(key);
	}
        if (key < root.val){
            root.left= insert(root.left,key);
        }else if (key > root.val){
            root.right=insert(root.right, key);
        }
        return root;
    }
    
    public int size() {
	return size(this);
    }
    
    public static int size(TreeNode node) {
	if (node != null) {
	    return 1 + size(node.left) + size(node.right);
	} else {
	    return 0;
	}
    }
    
    static int[] arr;
    static int i = 0;

    /** Traverse a tree inorder, (left, root, right)  */
    public static int[] inOrder(TreeNode root) {
	arr = new int[root.size()];
	i = 0;
	inOrderRecur(root);
	return arr;
    }
    
    private static void inOrderRecur(TreeNode root) {
	if (root != null) {
	    inOrderRecur(root.left);
	    arr[i++] = root.val;
	    inOrderRecur(root.right);
	}
    }
    
    
    /** Traverse a tree preOrder, (root, left, right) */
    public static int[] preOrder(TreeNode root) {
	arr = new int[root.size()];
	i = 0;
	preOrderRecur(root);
	return arr;
    }
    
    private static void preOrderRecur(TreeNode root) {
	if (root != null) {
	    arr[i++] = root.val;
	    preOrderRecur(root.left);
	    preOrderRecur(root.right);
	}
    }
    
    /**Traverse a tree postOrder, (left, right, root)   */
    public static int[] postOrder(TreeNode root) {
	arr = new int[root.size()];
	i = 0;
	postOrderRecur(root);
	return arr;
    }
    
    private static void postOrderRecur(TreeNode root) {
	if (root != null) {
	    postOrderRecur(root.left);
	    postOrderRecur(root.right);
	    arr[i++] = root.val;
	}
    }
    
    /**Traverse a tree bfs, (layer by layer)   */
    static Queue<TreeNode> q = new LinkedList<TreeNode>();
    public static int[] bfs(TreeNode root) {
	arr = new int[root.size()];
	i = 0;
	
	q.clear();
	if (root !=null){
	    q.add(root);
	}

	while(!q.isEmpty()){
	    TreeNode node= q.poll();
	    arr[i++]=node.val;
	    if (node.left !=null){
		q.add(node.left);
            }
	    if (node.right !=null){
		q.add(node.right);
            }
	}
	return arr;
    }
    
    /** Searching a key */
    public static TreeNode search(TreeNode root, int key){
	if (root ==null || root.val==key) {
	   return root;
	}
	if (root.val < key) return search(root.left, key);
	return search(root.right, key);
    }
    
    /** Delete a Node 
     * 
     * we delete a node, there possibilities arise.
1) Node to be deleted is leaf: Simply remove from the tree.
              50                            50
           /     \         delete(20)      /   \
          30      70       --------->    30     70 
         /  \    /  \                     \    /  \ 
       20   40  60   80                   40  60   80
2) Node to be deleted has only one child: Copy the child to the node and delete the child
              50                            50
           /     \         delete(30)      /   \
          30      70       --------->    40     70 
            \    /  \                          /  \ 
            40  60   80                       60   80
3) Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. Note that inorder predecessor can also be used.
              50                            60
           /     \         delete(50)      /   \
          40      70       --------->    40    70 
                 /  \                            \ 
                60   80                           80
The important thing to note is, inorder successor is needed only when right child is not empty. In this particular case, inorder successor can be obtained by finding the minimum value in right child of the node.
     * 
     * */
    public static TreeNode delete(TreeNode root, int key){
	if (root ==null) return root;
	if (key < root.val){
	    root.left=delete(root.left,key);
	}else if (key > root.val){
	    root.right=delete(root.right,key);
	}
	else{
	    if (root.left==null){
		TreeNode temp = root.right;
		root.right=null;
		return temp;
	    }else if(root.right==null){
		TreeNode temp=root.left;
		root.left=null;
		return temp;
	    }
	    
	    TreeNode temp = minValueNode(root.right);
            root.val=temp.val; 	    
	    delete(root.right, temp.val);
	}
	return root;
    }
    
    private static TreeNode minValueNode(TreeNode node){
	TreeNode cur = node;
	while(cur.left!=null){
	    cur= cur.left;
	}
	return cur;
    }
    
    
    
    
    
    
    
    
    
}
