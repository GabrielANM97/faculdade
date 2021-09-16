package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static implementation.BinaryFib.binaryFib;

public class BinaryFibTest {
	@Test
	void test() {
		assertEquals(5, binaryFib(5));
		assertEquals(233, binaryFib(13));
	}
}
