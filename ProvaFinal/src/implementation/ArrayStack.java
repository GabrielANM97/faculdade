package implementation;


import exceptions.EmptyStackException;
import exceptions.FullStackException;
import interfaces.Stack;

@SuppressWarnings("hiding")
public class ArrayStack<Aluno> implements Stack<Aluno> {
	
	protected int capacity;
	
	public static final int CAPACITY = 1000;
	
	protected Aluno S[];
	
	protected int top = -1;
	
	public ArrayStack() {
	
		this(CAPACITY); 
	}
	
	@SuppressWarnings("unchecked")
	
	public ArrayStack(int cap) {
	
		capacity = cap;
	
		S = (Aluno[]) new Object[capacity];
	
	}
	
	public int size() {
	
		return (top + 1);
	
	}
	
	public boolean isEmpty() {
	
		return (top < 0);
	
	}
	
	public void push(Aluno element) throws FullStackException {
	
		if (size() == capacity)
			throw new FullStackException("Stack is full.");
	
		S[++top] = element;
	
	}
	
	public Aluno top() throws EmptyStackException {

		if (isEmpty()) throw new EmptyStackException("Stack is empty.");

		return S[top];

	}

	public Aluno pop() throws EmptyStackException {

		Aluno element;

		if (isEmpty()) throw new EmptyStackException("Stack is empty.");

		element = S[top];

		S[top--] = null;

		return element;

	}

	public String toString() {

		String s;

		s = "[";

		if (size() > 0) s += S[0];

		if (size() > 1) {

			for (int i = 1; i <= size() - 1; i++) {

				s += ",\n\n" + S[i];

			}
		}

		return s + "]";

	}

}
