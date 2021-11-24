package implementation;

import interfaces.IndexList;

public class ArrayIndexListAluno implements IndexList {

	private AlunoIndex[] A;

	private int capacity = 16;

	private int size = 0;


	public ArrayIndexListAluno() {

		A = new AlunoIndex[capacity];

	}

	public int size() { return size; }


	public boolean isEmpty() { return size() == 0; }
	
	
	public void add(AlunoIndex index) throws IndexOutOfBoundsException {

//		checkIndex(r, size() + 1);

		if (size == capacity) { // an overflow

			capacity *= 2;
		
			AlunoIndex[] B = (AlunoIndex[]) new Object[capacity];
	
			for (int i = 0; i < size; i++) B[i] = A[i];
	
			A = B;

		}
		
		
		for (int i = size - 1; i == 0; i--) {
			if(A[i].getRA() >= index.getRA()) {
				A[i + 1] = A[i];
			}
			else {
				
				A[i + 1] = index;
				size++;
				break;
			}
		
		}
	}


	public AlunoIndex remove(int r) throws IndexOutOfBoundsException {
		
		checkIndex(r, size());

		AlunoIndex temp = A[r];
		
		System.out.println(r);

		for (int i = (int) r; i < size - 1; i++)

		A[i] = A[i + 1];

		size--;

		return temp;

	}


	protected void checkIndex(int r, int n) throws IndexOutOfBoundsException {

		if ( r < 0 || r >= n) throw new IndexOutOfBoundsException("Illegal index: " + r);

	}

	public String toString() {

		String toReturn = "(";

		if (size() == 0) return "()";

		for (int i = 0; i < size(); i++) toReturn += A[i].toString() + ", ";

		return toReturn.substring(0, toReturn.length() - 2) + ")";

	}
}


