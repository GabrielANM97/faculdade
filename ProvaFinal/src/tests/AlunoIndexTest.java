package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import implementation.Aluno;
import implementation.AlunoIndex;

public class AlunoIndexTest {
	
	Aluno aluno = new Aluno(202156758, "Fulano", "Hollywood", 945657879, "21/01/1970");
	Aluno aluno2 = new Aluno(202156879, "Beltrano", "Catanduva", 945657666, "12/11/1980");
	
	AlunoIndex index = new AlunoIndex(aluno.getRA(), aluno);
	
	@Test
	void getersTest() {
		assertEquals(202156758, index.getRA());
		assertEquals(aluno, index.getAluno());
	}
	
	@Test
	void setersTest() {
		index.setRA(202156666);
		assertEquals(202156666, index.getRA());
		
		index.setAluno(aluno2);
		assertEquals(aluno2, index.getAluno());
	}
	
	@Test
	void toStringTest() {
		assertEquals("O numero de RA 202156758 corresponde ao aluno " + "RA: 202156758" + "\n" 
	+ "Nome: Fulano" + "\n" 
	+ "Endereço: Hollywood" + "\n" 
	+ "Celular: 945657879" + "\n" 
	+ "Data de nascimento: 21/01/1970", index.toString());
	}
	
}
