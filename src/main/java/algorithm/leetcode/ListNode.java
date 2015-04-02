package algorithm.leetcode;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
    next = null;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public ListNode setNext(ListNode next) {
    this.next = next;
    return next;
  }

  static public ListNode create(int... vals) {
    ListNode root = null;
    ListNode cur = null;
    for (int val : vals) {
      if (root == null) {
        root = new ListNode(val);
        cur = root;
      } else {
        cur.setNext(new ListNode(val));
        cur = cur.next;
      }
    }
    return root;
  }

  public int size() {
    int size = 1;
    ListNode cur = this;
    while (cur.hasNext()) {
      cur = cur.next;
      size++;
    }
    return size;
  }

  public int[] toArray() {
    int[] a = new int[size()];
    ListNode cur = this;
    a[0] = cur.getVal();
    int i = 0;
    while (cur.hasNext()) {
      cur = cur.next;
      a[++i] = cur.getVal();
    }
    return a;
  }

  public boolean hasNext() {
    if (next != null)
      return true;
    return false;
  }

  public ListNode next() {
    return next;
  }

  public void remove() {}
}
