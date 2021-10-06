package implementation;

public class IterativeReverseArray {
	public static int[] iterativeReverseArray(int[] A, int i, int j) {
		while (i < j) {
				int aux = A[i];
				A[i] = A[j];
				A[j] = aux;
				
				i += 1;
				j -= 1; 
			}
		return A;
	}
}