package implementation;


public class DNode {
	protected String element; // String armazenada pelo nodo protected
	DNode next, prev; // Ponteiros para o nodo seguinte e o anterior

	// Construtor que cria um nodo com os campos fornecidos
	public DNode(String e, DNode p, DNode n) { element = e; prev = p; next = n;}

	// Retorna o elemento deste nodo
	public String getElement() { return element; }
	// Retorna o nodo anterior a este
	public DNode getPrev() { return prev; }
	// Retorna o nodo seguinte a este
	public DNode getNext() { return next; }

	// Atribui o elemento deste nodo
	public void setElement(String newElem) { element = newElem;}
	// Atribui o nodo anterior deste nodo
	public void setPrev(DNode newPrev) { prev = newPrev; }
	// Atribui o nodo seguinte a este nodo
	public void setNext(DNode newNext) { next = newNext; }
}

