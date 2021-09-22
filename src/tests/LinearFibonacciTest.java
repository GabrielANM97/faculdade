package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import implementation.LinearFibonacci;

public class LinearFibonacciTest {
	
	@Test
	void test() {
		
		assertEquals(5, LinearFibonacci.linearFibonacci(5).getI());
		assertEquals(3, LinearFibonacci.linearFibonacci(5).getJ());		
		}

}
