package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static implementation.BinarySum.binarySum;

public class BinarySumTest {
	@Test
	void test() {
		int[] A = {1, 2, 3, 4, 5};
		
		int x = binarySum(A, 1, 4);
		
		assertEquals(14, x);	
	}
}
