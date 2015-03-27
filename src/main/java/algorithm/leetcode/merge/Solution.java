package algorithm.leetcode.merge;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/** Definition for singly-linked list. **/

public class Solution {
    
    public static class ListNode implements Iterator<ListNode> {
	int val;
	ListNode next;
	
	ListNode(int x) {
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
	
	static public ListNode create(int ... vals) {
	    ListNode root = null;
	    ListNode cur = null;
	    for(int val: vals){
		if (root==null){
		    root = new ListNode(val);
		    cur=root;
		}
		else{
		    cur.setNext(new ListNode(val));
		    cur=cur.next();
		}
	    }
	    return root;
	}
	
	public int size() {
	    int size = 1;
	    ListNode cur= this;
	    while (cur.hasNext()) {
		cur=cur.next();
		size++;
	    }
	    return size;
	}
	
	public int[] toArray(){
	  int[] a= new int[size()];
	  ListNode cur= this;
	  a[0]=cur.getVal();
	  int i=0;
	  while(cur.hasNext()){
	      cur=cur.next();
	      a[++i]=cur.getVal();
	  }
	  return a;  
	}
	
	@Override
        public boolean hasNext() {
	    if (next !=null) return true;
	    return false;
        }

        public ListNode next() {
	    return next;
        }

	@Override
        public void remove() {
        }
	
	ListNode merge(ListNode node){
	    ListNode node = new ListNode(0);
	    return node;
	}
    }
    
    public ListNode mergeKLists(List<ListNode> lists) {
	return null;
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
	return n2;
    }
    
    @Test
    public void testCreate(){
	int[] a1 = {4,5,9,10};
	ListNode n1= ListNode.create(a1);
	assertEquals (4,n1.size());
	int[] a =n1.toArray();
	assertReflectionEquals (a, a1);
    }
    
    @Test
    public void testMerge(){
	int[] a1 = {4,5,9,10};
	int[] a2 = {3,7,8,10};
	
	ListNode n1= ListNode.create(a1);
	ListNode n2= ListNode.create(a2);
        ListNode n3 = n1.merge(n2);
    }
    
    
}
