package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import exceptions.AlunoIndexNotFoundException;
import implementation.Aluno;
import implementation.AlunoIndex;
import implementation.ArrayIndexListAluno;

public class ArrayIndexListAlunoTest {
	ArrayIndexListAluno indexList = new ArrayIndexListAluno();
	
	Aluno aluno = new Aluno(202156785, "Zé das Coves", "Tão Tão Distante", 945657897, "01/01/1990");
	Aluno aluno2 = new Aluno(202156783, "Zé das Coves", "Tão Tão Distante", 945657897, "01/01/1990");
	Aluno aluno3 = new Aluno(202156784, "Zé das Coves", "Tão Tão Distante", 945657897, "01/01/1990");
	Aluno aluno4 = new Aluno(202156780, "Zé das Coves", "Tão Tão Distante", 945657897, "01/01/1990");
	Aluno aluno5 = new Aluno(202156789, "Zé das Coves", "Tão Tão Distante", 945657897, "01/01/1990");
	

	AlunoIndex alunoIndex = new AlunoIndex(aluno.getRA(), aluno);
	AlunoIndex alunoIndex2 = new AlunoIndex(aluno2.getRA(), aluno2);
	AlunoIndex alunoIndex3 = new AlunoIndex(aluno3.getRA(), aluno3);
	AlunoIndex alunoIndex4 = new AlunoIndex(aluno4.getRA(), aluno4);
	AlunoIndex alunoIndex5 = new AlunoIndex(aluno5.getRA(), aluno5);
	
	long randomRA = 312321231;
	
	@Test
	public void testAdd() {
		// teste da insersão ordenada de um AlunoIndex dentro da lista.
		
		
		indexList.add(alunoIndex);
		assertEquals("(" + alunoIndex.toString() + ")", indexList.toString());
		
		indexList.add(alunoIndex2);
		assertEquals("(" + alunoIndex2.toString() + ",\n" + alunoIndex.toString() + ")", indexList.toString());

		indexList.add(alunoIndex3);
		assertEquals("(" + alunoIndex2.toString() + ",\n" + 
				alunoIndex3.toString() + ",\n" + alunoIndex.toString() + ")", indexList.toString());

		indexList.add(alunoIndex4);
		assertEquals("(" + alunoIndex4.toString() + ",\n" + alunoIndex2.toString() + ",\n" + 
				alunoIndex3.toString() + ",\n" + alunoIndex.toString() + ")", indexList.toString());

		
		indexList.add(alunoIndex5);
		assertEquals("(" + alunoIndex4.toString() + ",\n" + alunoIndex2.toString() + ",\n" + 
				alunoIndex3.toString() + ",\n" + alunoIndex.toString() + ",\n" + alunoIndex5.toString() + ")", indexList.toString());
		
		System.out.println(indexList.toString());
	}
	
	@Test
	public void testRemove() {
		// Teste da remoção de um AlunoIndex de dentro da lista a partir do RA.
				
		indexList.add(alunoIndex);
		indexList.add(alunoIndex2);
		indexList.add(alunoIndex3);
		indexList.add(alunoIndex4);
		indexList.add(alunoIndex5);	
		
		indexList.remove(alunoIndex5.getRA());
		assertEquals("(" + alunoIndex4.toString() + ",\n" + alunoIndex2.toString() + ",\n" + 
				alunoIndex3.toString() + ",\n" + alunoIndex.toString() + ")", indexList.toString());
		
		indexList.remove(alunoIndex4.getRA());
		assertEquals("(" + alunoIndex2.toString() + ",\n" + alunoIndex3.toString() + ",\n" + 
				alunoIndex.toString() + ")", indexList.toString());
		
		indexList.remove(alunoIndex3.getRA());
		assertEquals("(" + alunoIndex2.toString() + ",\n" + alunoIndex.toString() + ")", indexList.toString());
		
		indexList.remove(alunoIndex2.getRA());
		assertEquals("(" + alunoIndex.toString() + ")", indexList.toString());

		indexList.remove(alunoIndex.getRA());
		assertEquals("(" + ")", indexList.toString());

 	}
	
	
	@Test
	public void testBinarySearch() {
		// Testa a busca binaria de um AlunoIndex dentro da lista a partir do RA.
		
		indexList.add(alunoIndex);
		indexList.add(alunoIndex2);
		indexList.add(alunoIndex3);
		indexList.add(alunoIndex4);
		indexList.add(alunoIndex5);
		
		assertThrows(AlunoIndexNotFoundException.class, () -> { indexList.binarySearch(randomRA); });
		
		assertEquals(aluno, indexList.binarySearch(alunoIndex.getRA()));
		
		assertEquals(aluno2, indexList.binarySearch(alunoIndex2.getRA()));

		assertEquals(aluno3, indexList.binarySearch(alunoIndex3.getRA()));
		
		assertEquals(aluno4, indexList.binarySearch(alunoIndex4.getRA()));
		
		assertEquals(aluno5, indexList.binarySearch(alunoIndex5.getRA()));
	}

}
