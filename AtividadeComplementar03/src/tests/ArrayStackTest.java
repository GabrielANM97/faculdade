package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import exceptions.EmptyStackException;
import exceptions.FullStackException;
import implementation.ArrayStack;

class ArrayStackTest {

	static final ArrayStack<Integer> a = new ArrayStack<Integer>(3);

	@Test
	void pilhaInteiros() {

		a.push(7);

		assertEquals("[7]", a.toString(), "Deve imprimir [7]");

		a.push(9);

		assertEquals("[7, 9]", a.toString(), "Deve imprimir [7, 9]");

		a.push(1);

		assertEquals("[7, 9, 1]", a.toString(), "Deve imprimir [7, 9, 1]");

		assertThrows(FullStackException.class, () -> { a.push(2); });

		assertEquals(1, a.pop(), "Deve ter desempilhado 1");

		assertEquals("[7, 9]", a.toString(), "Deve imprimir [7, 9]");

		assertEquals(9, a.pop(), "Deve ter desempilhado 9");

		assertEquals("[7]", a.toString(), "Deve imprimir [7]");

		assertEquals(7, a.pop(), "Deve ter desempilhado 7");

		assertEquals("[]", a.toString(), "Deve imprimir []");

		assertTrue(a.isEmpty());

		assertThrows(EmptyStackException.class, () -> { a.pop(); });
	}
	
	static final ArrayStack<String> pilhaString = new ArrayStack<String>(2);

	
	@Test
	void pilhaString() {
		
		pilhaString.push("ola");
		
		assertEquals("[ola]", pilhaString.toString(), "Deve imprimir [ola]");
		
		pilhaString.push("mundo");
		
		assertEquals("[ola, mundo]", pilhaString.toString(), "Deve imprimir [ola, mundo]");
		
		assertThrows(FullStackException.class, () -> { pilhaString.push("bonito"); });
		
		assertEquals("mundo", pilhaString.pop(), "Deve ter desempilhado mundo");
		
		assertEquals("[ola]", pilhaString.toString(), "Deve imprimir [ola]");
		
		assertEquals("ola", pilhaString.pop(), "Deve ter desempilhado ola");
		
		assertEquals("[]", pilhaString.toString(), "Deve imprimir []");
		
		assertTrue(pilhaString.isEmpty());
		
		assertThrows(EmptyStackException.class, () -> { pilhaString.pop(); });	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
