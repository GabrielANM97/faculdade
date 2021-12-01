package interfaces;

import implementation.Aluno;
import implementation.AlunoIndex;

public interface IndexList {

	public int size();


	public boolean isEmpty();


	public void add(AlunoIndex index);

	
	public void remove(long RA);
	
	
	public Aluno binarySearch(long RA); 

}
