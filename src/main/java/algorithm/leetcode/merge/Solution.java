package algorithm.leetcode.merge;

import static org.junit.Assert.assertEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This question is very common in distributed systems, sorted list from different client to merge
 * together in a central server on it. There are two general approaches to this question, the
 * following description and analysis of the complexity of eleven. The first approach is easier to
 * think of, is somewhat similar to MergeSort idea is to divide and conquer, friends do not
 * understand MergeSort See merge sort - Wikipedia, is a more classic O(nlogn) sorting algorithm, it
 * is quite important. The idea is to be divided into two sub-tasks, and then recursively Praying
 * task, and finally back to come back. This topic is so, first k a list in half, and then continue
 * to divide, to know the remaining two will be combined list, will use Merge Two Sorted Lists This
 * question merge, unfamiliar friends can review it. Code is as follows:
 * 
 * We analyze the time complexity of the above algorithm. Assuming a total of k a list, the maximum
 * length of each list is n, then the running time to meet the recursive formula T (k) = 2T (k / 2)
 * + O (n * k). According to the main theorem can be calculated in the total complexity of the
 * algorithm is O (nklogk). If you do not understand the main theorem of friends, you can see the
 * main theorem - Wikipedia. Space complexity of the case is recursive stack size O (logk). Next we
 * look at the second method. This method uses a stack data structure, the idea is more difficult to
 * imagine, but in fact, the principle is relatively simple. Maintain a heap of size k, each taking
 * the smallest element into the top of the heap of the results, and then read the next element of
 * the element into the heap, again maintaining good. Because each list is ordered, each is to
 * present k smallest elements, so when all lists are read over, this time all the elements on the
 * results from small to large list. Each element of this algorithm is to be read once, that is, k *
 * n times, then every element of the new element should be inserted to read the complexity of the
 * heap to be logk, so the total time complexity is O (nklogk). Space complexity is the size of the
 * heap, that is O (k). Code is as follows:
 * 
 * @author zluo
 * 
 */
public class Solution {
  /**
   * function merge(left, right) var list result while notempty(left) and notempty(right) if
   * first(left) <= first(right) append first(left) to result left = rest(left) else append
   * first(right) to result right = rest(right) // either left or right may have elements left while
   * notempty(left) append first(left) to result left = rest(left) while notempty(right) append
   * first(right) to result right = rest(right) return result
   * 
   * @param n1
   * @param n2
   * @return
   */

  public ListNode mergeKLists(List<ListNode> lists) {
    if (lists == null || lists.size() == 0)
      return null;
    return mergeKLists(lists, 0, lists.size() - 1);
  }

  private ListNode mergeKLists(List<ListNode> lists, int l, int r) {
    if (l < r) {
      int m = (l + r) / 2;
      return merge(mergeKLists(lists, l, m), mergeKLists(lists, m + 1, r));
    }
    return lists.get(l);
  }

  /**
   * This is simple question, classic operations to a two linked list. Maintains two pointers
   * of two lists, using one list as the base, such as l1, l1 current
   * period so that if an element is relatively small, so you can move directly l1, l2 otherwise the
   * current element into the current element l1 the front. The time complexity of the algorithm is
   * O (m + n), m and n are the lengths of the two lists, the space complexity is O (1), the
   * following code:
   * 
   * @param l1
   * @param l2
   * @return
   */
  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    dummy.next = l1;
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        l1 = l1.next;
      } else {
        ListNode next = l2.next;
        cur.next = l2;
        l2.next = l1;
        l2 = next;
      }
      cur = cur.next;
    }
    if (l2 != null)
      cur.next = l2;
    return dummy.next;
  }

  /*
   * private ListNode merge(ListNode n1, ListNode n2) { ListNode n3 = null; ListNode cn3=null;
   * 
   * if (n1 != null && n2 != null) { if (n1.val > n2.val) { n3 = n2; n2 = n2.next; } else { n3 =n1;
   * n1 = n1.next; } cn3 = n3; }
   * 
   * while (n1 != null && n2 != null) { if (n1.val < n2.val) { cn3.next = n1; n1 = n1.next; } else {
   * cn3.next = n2; n2 = n2.next; } cn3 = cn3.next; }
   * 
   * if (n1 != null) { if (n3==null) { n3=n1; }else { cn3.next = n1; } return n3; }
   * 
   * if (n2 != null) { if (n3==null) { n3= n2; }else { cn3.next = n2; } return n3; } return n3; }
   */

  @Test
  public void testCreate() {
    int[] a1 = {4, 5, 9, 10};
    ListNode n1 = ListNode.create(a1);
    assertEquals(4, n1.size());
    int[] a = n1.toArray();
    assertReflectionEquals(a, a1);
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


  @Test
  public void testKList() {
    int[] a1 = {4, 5, 9, 10};
    int[] a2 = {3, 7, 8, 10};
    int[] a3 = {1, 2, 6, 14};
    int[] r = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 14};
    ListNode n1 = ListNode.create(a1);
    ListNode n2 = ListNode.create(a2);
    ListNode n3 = ListNode.create(a3);

    List<ListNode> listNodes = new ArrayList();
    listNodes.add(n1);
    listNodes.add(n2);
    listNodes.add(n3);

    assertReflectionEquals(r, mergeKLists(listNodes).toArray());
  }

  @Test
  public void testKListNull() {
    List<ListNode> listNodes = new ArrayList();
    assertEquals(null, mergeKLists(listNodes));

    int[] a1 = {4, 5, 9, 10};
    int[] a2 = {3, 7, 8, 10};
    int[] a3 = {1, 2, 6, 14};
    int[] r = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 14};
    ListNode n1 = ListNode.create(a1);
    ListNode n2 = ListNode.create(a2);
    ListNode n3 = ListNode.create(a3);
    listNodes.add(null);
    listNodes.add(n1);
    listNodes.add(null);
    listNodes.add(null);
    listNodes.add(null);
    listNodes.add(n2);
    listNodes.add(null);
    listNodes.add(null);
    listNodes.add(n3);
    listNodes.add(null);
    listNodes.add(null);
    listNodes.add(null);
    listNodes.add(null);

    assertReflectionEquals(r, mergeKLists(listNodes).toArray());
  }



}
