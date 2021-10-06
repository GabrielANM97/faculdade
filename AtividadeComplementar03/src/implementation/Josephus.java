package implementation;

import exceptions.EmptyQueueException;
import interfaces.Queue;

public class Josephus {

	public static <E> E Josephus(Queue<E> Q, int k) throws EmptyQueueException {

		if (Q.isEmpty()) return null;
	
		while (Q.size() > 1) {
	
			System.out.println(" Queue: " + Q + " k = " + k);
	
			for (int i = 0; i < k; i++) Q.enqueue(Q.dequeue());
	
			E e = Q.dequeue();
	
			System.out.println(" " + e + " is out");
	
		}
	
		return Q.dequeue();
	
	}


	public static <E> Queue<E> buildQueue(E a[]) {

		Queue<E> Q = new NodeQueue<E>();

		for (int i = 0; i < a.length; i++) Q.enqueue(a[i]);

		return Q;

	}

	public static void main(String[] args) throws EmptyQueueException {

		String[] a1 = { "Alice", "Bob", "Cindy", "Doug", "Ed", "Fred" };
		
		String[] a2 = { "Gene", "Hope", "Irene", "Jack", "Kim", "Lance" };
		
		String[] a3 = { "Mike", "Roberto" };
		
		System.out.println("First winner is " + Josephus(buildQueue(a1), 3));
		
		System.out.println("Second winner is " + Josephus(buildQueue(a2), 10));
		
		System.out.println("Third winner is " + Josephus(buildQueue(a3), 7));
		
	}
}
