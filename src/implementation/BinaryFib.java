package implementation;

public class BinaryFib {
	public static int binaryFib(int k) {
		if (k <= 1)
			return k;
		else {
			return binaryFib(k - 1) + binaryFib(k - 2);
		}
	}
}
