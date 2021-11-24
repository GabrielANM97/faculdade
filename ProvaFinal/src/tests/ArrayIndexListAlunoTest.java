package tests;

import org.junit.jupiter.api.Test;

import implementation.Aluno;
import implementation.AlunoIndex;
import implementation.ArrayIndexListAluno;

public class ArrayIndexListAlunoTest {
	ArrayIndexListAluno indexList = new ArrayIndexListAluno();
	Aluno aluno = new Aluno(202156785, "Zé das Coves", "Tão Tão Distante", 945657897, "01/01/1990");
	Aluno aluno2 = new Aluno(202156784, "Zé das Coves", "Tão Tão Distante", 945657897, "01/01/1990");
	AlunoIndex alunoIndex = new AlunoIndex(aluno.getRA(), aluno);
	AlunoIndex alunoIndex2 = new AlunoIndex(aluno2.getRA(), aluno2);
	
	@Test
	public void testAdd() {
		indexList.add(alunoIndex);
		indexList.add(alunoIndex2);
//		indexList.remove(alunoIndex.getRA());
		
		System.out.println(indexList);
	}

}
