package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import implementation.Aluno;

public class AlunoTest {
	Aluno aluno = new Aluno(202156785, "Zé das Coves", "Tão Tão Distante", 945657897, "01/01/1990");
	
	@Test
	void getersTest() {
		assertEquals(202156785, aluno.getRA());
		assertEquals("Zé das Coves", aluno.getNome());
		assertEquals("Tão Tão Distante", aluno.getEndereco());
		assertEquals(945657897, aluno.getCelular());
		assertEquals("01/01/1990", aluno.getDataDeNascimento());
	}
	
	@Test
	void setersTest() {
		aluno.setRA(202156786);
		assertEquals(202156786, aluno.getRA());
		
		aluno.setNome("Zé das Cove");
		assertEquals("Zé das Cove", aluno.getNome());
		
		aluno.setEndereco("Tão Tão Tão Distante");
		assertEquals("Tão Tão Tão Distante", aluno.getEndereco());
		
		aluno.setCelular(945657896);
		assertEquals(945657896, aluno.getCelular());
		
		aluno.setDataDeNascimento("02/01/1990");;
		assertEquals("02/01/1990", aluno.getDataDeNascimento());
	}
	
	@Test
	void toStringTest() {
		assertEquals("RA: 202156785" + "\n" 
	+ "Nome: Zé das Coves" + "\n" 
	+ "Endereço: Tão Tão Distante" + "\n" 
	+ "Celular: 945657897" + "\n" 
	+ "Data de nascimento: 01/01/1990", aluno.toString());
	}

}
