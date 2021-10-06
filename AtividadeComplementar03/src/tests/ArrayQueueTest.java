package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;
import implementation.ArrayQueue;

class ArrayQueueTest {
	
	static final ArrayQueue<Integer> fila = new ArrayQueue<Integer>(3); 
	
	@Test
	void filaInteiros() {
		fila.enqueue(5);
		
		assertEquals("[5]", fila.toString(), "Deve imprimir [5]");
		
		fila.enqueue(2);
		
		assertEquals("[5, 2]", fila.toString(), "Deve imprimir [5, 2]");
		
		assertEquals(2, fila.size(), "Deve retornar o tamanho 2");
				
		assertThrows(FullQueueException.class, () -> { fila.enqueue(2); });
		
		assertEquals(5, fila.dequeue(), "Deve desenfileirar 5");
		
		assertEquals(2, fila.front(), "O primeiro elemento deve ser 2");
		
		assertEquals(2, fila.dequeue(), "Deve desenfileirar 2");
		
		assertThrows(EmptyQueueException.class, () -> { fila.dequeue(); } );
		
		assertTrue(fila.isEmpty());
	}
	
}
