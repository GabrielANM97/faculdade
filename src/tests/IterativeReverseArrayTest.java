package tests;

import static implementation.IterativeReverseArray.iterativeReverseArray;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class IterativeReverseArrayTest {
	@Test
	void test() {
		int[] A = {1, 2, 3, 4, 5};
		int[] reverseA = {5, 4, 3, 2, 1};
		int[] parcialReverseA = {1, 4, 3, 2, 5};
		
		int[] x = iterativeReverseArray(A.clone(), 0, 4);
		
		assertTrue(Arrays.equals(reverseA, x));
		
		int[] y = iterativeReverseArray(A.clone(), 2, 2);
		
		assertTrue(Arrays.equals(A, y));
		
		int[] z = iterativeReverseArray(A.clone(), 4, 3);
		
		assertTrue(Arrays.equals(A, z));
		
		int[] w = iterativeReverseArray(A.clone(), 1, 3);
		
		assertTrue(Arrays.equals(parcialReverseA, w));
	}
}
