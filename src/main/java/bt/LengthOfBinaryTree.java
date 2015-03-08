package bt;

import static org.junit.Assert.*;

import org.junit.Test;

public class LengthOfBinaryTree {
  
  public int depth(Node node) {
    if (node==null) {
      return 0;
    }
    else {
      return 1 + Math.max(depth(node.left), depth(node.right));
    }
  }
  
  
  @Test
  public void testLength(){
     Node root = new Node(3);
     root.setLeft(Node.valueOf(3));
     root.setRight(Node.valueOf(4));
     root.getRight().setLeft(Node.valueOf(5));
     
     assertEquals(3, depth(root));
  }

}
