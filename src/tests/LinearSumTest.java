package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static implementation.LinearSum.linearSum;

public class LinearSumTest {
	@Test
	void test() {
		int[] A = {1, 2, 3};
		
		int x = linearSum(A, 3);
		
		assertEquals(6, x, "6");
	}
}
