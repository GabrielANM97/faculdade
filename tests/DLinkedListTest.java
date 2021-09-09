package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import implementation.DLinkedList;
import implementation.DNode;

class DLinkedListTest {
	@Test
	void test() {
		DNode z, v;
		DLinkedList l = new DLinkedList();
//		assertEquals("[]", l.toString(), "[]");

		z = new DNode("BWI", null, null);
		l.addLast(z);
		assertEquals("[BWI]", l.toString(), "[BWI]");

		z = new DNode("SFO", null, null);
		l.addLast(z);
		assertEquals("[BWI,SFO]", l.toString(), "[BWI,SFO]");

		z = new DNode("JFK", null, null);
		l.addLast(z);
		assertEquals("[BWI,SFO,JFK]", l.toString(), "[BWI,SFO,JFK]");

		v = l.getLast(); // Pega o último node.
		assertEquals("JFK", v.getElement(), "JFK");

		z = new DNode("PVD", null, null);
		l.addBefore(v, z);
		assertEquals("[BWI,SFO,PVD,JFK]", l.toString(), "[BWI,SFO,PVD,JFK]");
	}
}