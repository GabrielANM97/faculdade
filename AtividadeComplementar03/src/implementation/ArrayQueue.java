package implementation;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;
import interfaces.Queue;


public class ArrayQueue<E> implements Queue<E> {
	protected int n;
	
	public static final int N = 1000;
		
	public int f;
	
	public int r;
	
	protected E Q[];
	
	
	public ArrayQueue() {
		this(N);
	}
	
	@SuppressWarnings("unchecked")
	
	public ArrayQueue(int cap) {
	
		n = cap;
	
		Q = (E[]) new Object[n];
	
	}

	public int size() {
		return (n - f + r) % n;
	}
	
	public boolean isEmpty() {
		return (f == r);
	}
	
	public E front() throws EmptyQueueException {
		if (this.isEmpty()) throw new EmptyQueueException("Queue is empty");
		
		return Q[f];
	}
	
	public E dequeue() throws EmptyQueueException {
		if (this.isEmpty()) throw new EmptyQueueException("Queue is empty");
		
		E temp = Q[f];
		
		Q[f] = null;
		
		f = (f + 1) % n;
		
		return temp;
	}
	
	public void enqueue(E element) throws FullQueueException {
		if (this.size() == (n - 1)) throw new FullQueueException("Queue is full");
		
		Q[r] = element;
		
		r = (r + 1) % n;
	} 
	
	public String toString() {

		String s;

		s = "[";

		if (size() > 0) s += Q[0];

		if (size() > 1) {

			for (int i = 1; i <= size() - 1; i++) {

				s += ", " + Q[i];

			}
		}

		return s + "]";

	}
}
