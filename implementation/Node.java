package implementation;

public class Node {
	private String element; // assumimos: os elementos são strings
	private Node next;

	// Cria um nodo com um dado elemento e o próximo nodo
	public Node(String s, Node n) {
		element = s;
		next = n;
	}

	// Retorna o elemento deste nodo
	public String getElement() {
		return element;
	}

	// Retorna o próximo elemento deste nodo
	public Node getNext() {
		return next;
	}

	// Métodos modificadores:
	// Define o elemento deste nodo
	public void setElement(String newElem) {
		element = newElem;
	}

	// Define o próximo elemento deste nodo
	public void setNext(Node newNext) {
		next = newNext;
	}

}
