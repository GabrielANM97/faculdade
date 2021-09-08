package implementation;

public class DLinkedList {
	
	protected DNode header;
	protected DNode trailer;
	
	protected long size;
	
	public DLinkedList() {
		header = trailer = null;
		size = 0;
	}
	
	public String toString() {
		String s;
		DNode t = trailer;
		
		s = "";
		
		if (trailer != null) {
			s = "]";
			while (t.getPrev() != null) {
				s = t.getPrev().getElement() + s;
				s = "," + s;
				t = t.getPrev();
				size += 1;
			}
			if (s.length() > 1)
				s = s.substring(1, s.length());
			s = "[" + s;
		}

		if (s == "") {
			s = "[]";
		}
		
		return s;
	}

	public void addLast(DNode v) {
		if (size < 1) {
			DNode x = new DNode(null, null, null);
			trailer = x;
		}
		DNode aux;
		size += 1;

		if (size < 2) {
			v.setNext(trailer);
			trailer.setPrev(v);
		}
		else {
			aux = trailer.getPrev();
			trailer.setPrev(v);
			aux.setNext(v);
			v.setPrev(aux);
			v.setNext(trailer);	
		}
	}

	public DNode getLast() {
		return trailer.getPrev();
	}

	public void addBefore(DNode v, DNode z) {
		DNode aux;
		
		aux = v.getPrev();
		
		z.setNext(v);
		
		v.setPrev(z);
		
		aux.setNext(z);
		
		z.setPrev(aux);	
		
	}

}
