package algorithm.leetcode._023_mergeKlists;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import org.junit.Test;
import algorithm.leetcode.ListNode;
/**
 * From 9.47 -9:52 (5 min)
 * @author zluo
 *
 */
public class MergeTwoSortedListPractice1 {
  public ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur =dummy;
    dummy.next=l1;
    while (l1!=null && l2!=null){
	if (l1.val < l2.val){
	    l1=l1.next;
	}else{
	    ListNode next =l2.next;
	    l2.next=cur.next;
	    cur.next=l2;
	    l2=next;
	}
	cur=cur.next;
    }
    
    if (l2 !=null){
       cur.next=l2;	
    }
    return dummy.next;
  }
  
  @Test
  public void testMerge() {
    int[] a1 = {4, 5, 9, 10};
    int[] a2 = {3, 7, 8, 10};
    int[] a3 = {3, 4, 5, 7, 8, 9, 10, 10};
    ListNode n1 = ListNode.create(a1);
    ListNode n2 = ListNode.create(a2);
    ListNode n3 = merge(n1, n2);
    assertReflectionEquals(a3, n3.toArray());
  }
}
