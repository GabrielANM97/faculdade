package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static implementation.ReverseArray.reverseArray;

public class ReverseArrayTest {
	@Test
	void test() {
		int[] A = {1, 2, 3, 4, 5};
		int[] reverseA = {5, 4, 3, 2, 1};
		int[] parcialReverseA = {1, 4, 3, 2, 5};
		
		int[] x = reverseArray(A.clone(), 0, 4);
		
		assertTrue(Arrays.equals(reverseA, x));
		
		int[] y = reverseArray(A.clone(), 2, 2);
		
		assertTrue(Arrays.equals(A, y));
		
		int[] z = reverseArray(A.clone(), 4, 3);
		
		assertTrue(Arrays.equals(A, z));
		
		int[] w = reverseArray(A.clone(), 1, 3);
		
		assertTrue(Arrays.equals(parcialReverseA, w));
	}
	

}
