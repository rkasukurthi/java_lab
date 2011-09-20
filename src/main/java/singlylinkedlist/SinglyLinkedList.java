package singlylinkedlist;

/**
 * A singly linked list is made of nodes where each node has a pointer to the
 * next node (or null to end the list). A singly linked list is often used as a
 * stack (or last in first out queue (LIFO)) because adding a new first element,
 * removing the existing first element, and examining the first element are very
 * fast O(1) operations.
 * 
 * @author zluo
 * 
 *         When working with singly linked list, you are typically given a link
 *         to the first node. Common operations on a singly linked list are
 *         iterating through all the nodes, adding to the list, or deleting from
 *         the list. Algorithms for these operations generally require a well
 *         formed linked list. That is a linked list without loops or cycles in
 *         it.
 * 
 * 
 *         If a linked list has a cycle:
 * 
 *         The malformed linked list has no end (no node ever has a null
 *         next_node pointer) The malformed linked list contains two links to
 *         some node
 * 
 *         Iterating through the malformed linked list will yield all nodes in
 *         the loop multiple times A malformed linked list with a loop causes
 *         iteration over the list to fail because the iteration will never
 *         reach the end of the list. Therefore, it is desirable to be able to
 *         detect that a linked list is malformed before trying an iteration.
 *         This article is a discussion of various algorithms to detect a loop
 *         in a singly linked list.
 */

class Node {
	private int value;
	private Node next;

	Node next() {
		return next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}

public class SinglyLinkedList {

	Node start;
	Node end;

	public int traverse()
	{
		int sum=0;
		
		Node current=start;
		Node previous=null;
		
		while(current !=null)
		{
		  sum += current.getValue();
		  
		}
		
		return sum;
	}

	public void add(Node node) {

	}

	/**
	 * Best solution Catch Loops in Two Passes O(n) time complexity
	 * 
	 * Simultaneously go through the list by ones (slow iterator) and by twos
	 * (fast iterator). If there is a loop the fast iterator will go around that
	 * loop twice as fast as the slow iterator. The fast iterator will lap the
	 * slow iterator within a single pass through the cycle. Detecting a loop is
	 * then just detecting that the slow iterator has been lapped by the fast
	 * iterator.
	 */
//	boolean hasCircle(Node startNode) {
//		Iterator i = l.begin(), j = l.begin();
//		while (true) {
//			// increment the iterators, if either is at the end, you're done, no
//			// circle
//			if (i.hasNext())
//				i = i.next();
//			else
//				return false;
//
//			// second iterator is travelling twice as fast as first
//			if (j.hasNext())
//				j = j.next();
//			else
//				return false;
//			if (j.hasNext())
//				j = j.next();
//			else
//				return false;
//
//			// this should be whatever test shows that the two
//			// iterators are pointing at the same place
//			if (i.getObject() == j.getObject()) {
//				return true;
//			}
//		}
//	}

}
