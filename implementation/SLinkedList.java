package implementation;

public class SLinkedList {
	protected Node head; // nodo cabeça da lista
	protected Node tail; // nodo cabeça da lista

	protected long size; // número de nodos da lista

	// Construtor default que cria uma lista vazia
	public SLinkedList() {
		head = tail = null;
		size = 0;
	}

	public String toString() {
		String s;
		Node p = head;
		Node t = tail;
		
		s = "";
		
		if (p != null) {
			s = "[";
			while (p != null) {
				s += p.getElement();
				s += ", ";
				p = p.getNext();
			}
			if (s.length() > 1)
				s = s.substring(0, s.length() - 2);
			s = s + "]";
		}
		
		if (t != null && size < 2) {
			s = "[";
			s += t.getElement();
			s += "]"; 	
		}

		if (s == "") {
			s = "[]";
		}
		
		return s;
	}
		


	public void addHead(String elem) {
		Node v = new Node(elem, null);
		v.setNext(head);  // faz com que next de v aponte para o mesmo lugar que head
		head = v;         //  faz com que head aponte para o mesmo lugar que v
		size = size + 1;  // incrementa o nodo contador
	}

	public void addTail(String elem) {
		Node t = new Node(elem, null);
		size = size + 1;
		if (size < 2)
			tail = t;
		else {
			if (size > 1 && size < 3)
				head = tail;
			tail.setNext(t);
			tail = t;
		}
	}
	
	public void removeFirst() {
		Node aux;
		if (this.head == null)
			throw new EmptySLinkedList("Simply linked list is empty");
		
		aux = this.head.getNext();
		
		this.head.setNext(null);
		
		this.head = aux;
	}
}
