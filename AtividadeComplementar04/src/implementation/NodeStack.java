package implementation;

import exceptions.EmptyStackException;
import interfaces.Stack;

public class NodeStack<E> implements Stack<E> {

	protected Node<E> top;
	
	protected Node<E> tail;

	protected int size;

	public NodeStack() {

		top = null;

		size = 0;

	}

	public int size() {return size; }

	public boolean isEmpty() {

		return (top == null);

	}

	public void push(E elem) {

		Node<E> v = new Node<E>(elem, top);

		top = v;

		size++;

	}

	public E top() throws EmptyStackException {

		if (isEmpty()) throw new EmptyStackException("Stack is empty.");

		return top.getElement();

	}

	public E pop() throws EmptyStackException {

		Node<E> aux = top;

		if (isEmpty()) throw new EmptyStackException("Stack is empty.");

		E temp = top.getElement();

		top = top.getNext();

		aux.setNext(null);

		size--;

		return temp;
		
	}
	
	public NodeStack<E> invertePilha() {
		
		NodeStack<E> pilha_aux = new NodeStack<E>();
		
		while (size > 0) {
			
			Node<E> aux = top;
			
			this.pop();
			
			pilha_aux.push(aux.getElement());
		}
		
		return pilha_aux;
		
	} 
	
	
	public String toString() {

		String s;

		Node<E> p = top;

		s = "[";

		while (p != null) {

			s += p.getElement();

			s += ", ";

			p = p.getNext();

		}

		if (s.length() > 1)

			s = s.substring(0, s.length() - 2);

		return s + "]";
	}
	
	public Boolean checkMathExpression(String mathExpression) {
		
		NodeStack<Character> openCharList = new NodeStack<Character>();

		char aux;
		
		char firstChar = mathExpression.charAt(0);
		
		if (firstChar == 41 || firstChar == 93 || firstChar == 125)
			return false;
		
		
		for (int i = 0; i < mathExpression.length(); i++) {
			aux = mathExpression.charAt(i);
			if (aux == 40 || aux == 123 || aux == 91 || aux == 93 || aux == 125 || aux == 41) {
				if (aux == 40 || aux == 123 || aux == 91) {
					openCharList.push(mathExpression.charAt(i));

				}
				else {
					char top = openCharList.top();
					if (top == 40 && aux == 41 || top == 123 && aux == 125 || top == 91 && aux == 93) {
						openCharList.pop();
					}
				}
			}
		}
		
		if (openCharList.size == 0)
			return true;
		else 
			return false;
		
	}

}			
				