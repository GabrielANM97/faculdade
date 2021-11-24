package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import exceptions.EmptyStackException;
import exceptions.FullStackException;
import implementation.Aluno;
import implementation.ArrayIndexListAluno;
import implementation.ArrayStackAluno;

public class ArrayStackTest {
	
	ArrayIndexListAluno index = new ArrayIndexListAluno();
	ArrayStackAluno a = new ArrayStackAluno(2, index);

	@Test
	void pilhaAlunos() {
		
		Aluno aluno1 = new Aluno(202156785, "Zé das Coves", "Tão Tão Distante", 945657897, "01/01/1990");

		a.push(aluno1);

		assertEquals("[" + aluno1.toString() + "]", a.toString());
		
		Aluno aluno2 = new Aluno(202156786, "Zé das Cove", "Tão Tão Tão Distante", 945657896, "02/01/1990");
		
		a.push(aluno2);

		assertEquals("[" + aluno1.toString() + ",\n\n" + aluno2.toString() + "]", a.toString());

		Aluno aluno3 = new Aluno(202156787, "Zé das Cenouras", "Tão Tão Tão Tão Distante", 945657898, "03/01/1990");
		
		assertThrows(FullStackException.class, () -> { a.push(aluno3); });

		assertEquals(aluno2, a.pop());

		assertEquals("[" + aluno1.toString() + "]", a.toString());

		assertEquals(aluno1, a.pop());

		assertEquals("[]", a.toString());

		assertTrue(a.isEmpty());

		assertThrows(EmptyStackException.class, () -> { a.pop(); });
	}
}
