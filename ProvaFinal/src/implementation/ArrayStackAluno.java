package implementation;


import exceptions.EmptyStackException;
import exceptions.FullStackException;
import interfaces.Stack;

public class ArrayStackAluno implements Stack {
	
	protected int capacity;
	
	public static final int CAPACITY = 1000;
	
	protected Aluno S[];
	
	protected int top = -1;
	
	protected ArrayIndexListAluno index;
	
	public ArrayStackAluno(ArrayIndexListAluno index) {
	
		this(CAPACITY, index); 
	}
	
	
	public ArrayStackAluno(int cap, ArrayIndexListAluno index) {
	
		capacity = cap;
	
		S = new Aluno[capacity];
		this.index = index;
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
		
		AlunoIndex alunoIndex = new AlunoIndex(element.getRA(), element);
		
		index.add(alunoIndex);
	
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
		
//		index.remove(element.getRA());
		
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
