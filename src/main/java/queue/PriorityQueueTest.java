package queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String... args) {
		PriorityQueue<String> pq = new PriorityQueue();
		pq.add("A");
		pq.add("B");
		pq.add("C");
		pq.add("D");
		
		System.out.println("After Using add method.");
		for (String s : pq) {
			System.out.println(s);
		}

		System.out.println("After Using poll method.");
		pq.poll();
		for (String s : pq) {
			System.out.println(s);
		}
		System.out.println("After Using remove method.");
		pq.remove("D");
		for (String s : pq) {
			System.out.println(s);
		}
	}
}
