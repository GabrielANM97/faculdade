package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.EmptyStackException;
import implementation.NodeStack;

class NodeStackTest {
	
	static final NodeStack<Integer> a = new NodeStack<Integer>();
	static final NodeStack<String> b = new NodeStack<String>();
		
	@Test
	void pilhaInteiros() {
	
		a.push(7);
		
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");
		
		a.push(9);
		
		assertEquals("[9, 7]", a.toString(), "Deve imprimir [9, 7]");
		
		a.push(1);
		
		assertEquals("[1, 9, 7]", a.toString(), "Deve imprimir [1, 9, 7]");
				
		assertEquals(1, a.pop(), "Deve ter desempilhado 1");
		
		assertEquals("[9, 7]", a.toString(), "Deve imprimir [9, 7]");
		
		assertEquals(9, a.pop(), "Deve ter desempilhado 9");
		
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");
		
		assertEquals(7, a.pop(), "Deve ter desempilhado 7");
		
		assertEquals("[]", a.toString(), "Deve imprimir []");
		
		assertTrue(a.isEmpty());
		
		assertThrows(EmptyStackException.class, () -> { a.pop(); });
	
	}
	
	@Test
	void pilhaInteirosInvertida() {
		
		a.push(7);
				
		a.push(9);
				
		a.push(1);
				
		assertEquals("[7, 9, 1]", a.invertePilha().toString(), "Deve imprimir [7, 9, 1]");
	}
	
	@Test
	void mathExpressionTest() {
		assertTrue(b.checkMathExpression("({[7 + 2]})"));
		assertTrue(b.checkMathExpression("[(5 + x)/4 – 2*(y + z)]"));
		assertFalse(b.checkMathExpression(")(( )){([( 7 - 1 )])}"));
		assertFalse(b.checkMathExpression("({[ 1 + 1])}"));
		assertFalse(b.checkMathExpression("("));
	}

}