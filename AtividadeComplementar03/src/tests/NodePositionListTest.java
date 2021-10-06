package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import exceptions.InvalidPositionException;
import implementation.NodePositionList;

import interfaces.Position;

class NodePositionListTest {
	
	NodePositionList<Integer> l = new NodePositionList<Integer>();


	@Test
	void test() {

		assertEquals("[]", l.toString(), "[]");

		l.addFirst(8);

		assertEquals("[8]", l.toString(), "[8]");

		Position<Integer> p1 = l.first();

		assertEquals(8, p1.element(), "8");

		assertEquals("[8]", l.toString(), "[8]");

		l.addAfter(p1, 5);

		assertEquals("[8, 5]", l.toString(), "[8, 5]");

		Position<Integer> p2 = l.next(p1);

		assertEquals(5, p2.element(), "5");	
		
		assertEquals("[8, 5]", l.toString(), "[8, 5]");
		
		l.addBefore(p2, 3);
		
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
		
		Position<Integer> p3 = l.prev(p2);
		
		assertEquals(3, p3.element(), "3");
		
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
		
		l.addFirst(9);
		
		assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");
		
		p2 = l.last();
		
		assertEquals(5, p2.element(), "5");
		
		assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");
		
		assertEquals(9, l.remove(l.first()), "9");
		
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
		
		assertEquals(3, l.set(p3, 7), "3");
		
		assertEquals("[8, 7, 5]", l.toString(), "[8, 7, 5]");
		
		l.addAfter(l.first(), 2);
		
		assertEquals("[8, 2, 7, 5]", l.toString(), "[8, 2, 7, 5]");

	}
	
	@Test
	void inverteNodePositionListTest() {		
		l.addFirst(5);
		
		Position<Integer> p1 = l.first();
		
		l.addAfter(p1, 2);
		
		Position<Integer> p2 = l.next(p1);
		
		l.addAfter(p2, 7);
		
		assertEquals("[5, 2, 7]", l.toString(), "Deve imprimir [5, 2, 7]");
				
		assertEquals("[7, 2, 5]", l.inverteNodePositionList().toString(), "Deve imprimir [7, 2 , 5]");
	}
	
	
	@Test
	void makeFirstTest() {
		l.addFirst(3);
		
		Position<Integer> p1 = l.first();
		
		l.addAfter(p1, 4);
		
		Position<Integer> p2 = l.next(p1);
		
		l.addAfter(p2, 11);
		
		l.makeFirst(p2);
		
		assertEquals("[4, 3, 11]", l.toString(), "Deve imprimir [4, 3, 11]");
		
	}
	
	@Test
	void invalidPosition() {
		NodePositionList<Integer> aux = new NodePositionList<Integer>();
		
		l.addFirst(2);
		
		Position<Integer> p1 = l.first();
		
		l.addAfter(p1, 1);
		
		Position<Integer> p2 = l.next(p1);
		
		l.addAfter(p2, 17);
		
		aux.addFirst(3);
		
		Position<Integer> p1_aux = aux.first();
		
		aux.addAfter(p1_aux, 4);
		
		Position<Integer> p2_aux = aux.next(p1_aux);
		
		aux.addAfter(p2_aux, 11);
		
		assertThrows(InvalidPositionException.class, () -> { aux.addAfter(p1, l.first().element()); } );
		
	}
}
