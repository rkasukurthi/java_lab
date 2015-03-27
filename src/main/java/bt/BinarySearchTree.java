package bt;
/**
 * Binary Search Tree is a special binary tree structure where left leaf less than node, right leaf great than node.
 *Inserting/Building a BST
*Finding maximum value node in BST
Finding minimum value node in BST
Inorder Traversal of BST
Preorder Traversal of BST
Postorder Traversal of BST
- See more at: http://www.javabeat.net/binary-search-tree-traversal-java/#sthash.5ItbXs9y.dpuf
 * 
 * @author zluo
 *
 */
public class BinarySearchTree {
  public Node root;
   public void insert(int value) {
     Node node=Node.valueOf(value);
     if (root==null) {
       root =node;
       return;
     }
     
     insertRec(root, node);
   }
   
   /** insert a node **/
   public void insertRec(Node root, Node node) {
     if (root.value>node.value) {
       if (root.left==null) {
         root.left=node;
         return;
       }
       else {
         insertRec(root.left,node);
       }
     }
     else {
       if (root.right==null) {
         root.right=node;
         return;
       }
       else {
         insertRec(root.right,node);
       }
     }
   }
   
   /** Find minimun **/
   public int findMin() {
     if (root==null) {
       return 0;
     }
     Node currNode=root;
     while(currNode.left!=null) {
       currNode=currNode.left;
     }
    return currNode.value;
     
   }
   
   /** Find maximun **/
   public int findMax() {
     if (root==null) {
       return 0;
     }
     Node currNode=root;
     while(currNode.right!=null) {
       currNode=currNode.right;
     }
     return currNode.value;
   }
   
   /** Inorder Tranversal **/
   
   public void printInOrder() {
     printInOrderRec(root);
   }
   
   private void printInOrderRec(Node node) {
     if (node==null) return;
     printInOrderRec(node.left);
     System.out.println(node.value + ",");
     printInOrderRec(node.right);
   }
   
   
   
}
