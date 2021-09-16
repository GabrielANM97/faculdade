package implementation;

public class BinarySum {
	public static int binarySum(int[] A, int i, int n) {
		if (n == 1) {
			return A[i];
		}
		if (n % 2 == 0) 
			return binarySum(A, i, (n / 2)) + binarySum(A, i + (n / 2), (n / 2));
		else {
			return binarySum(A, i, (n / 2)) + binarySum(A, i + (n / 2), (n / 2) + 1);
		}
	}
}
