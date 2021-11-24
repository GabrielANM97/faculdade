package interfaces;

import implementation.AlunoIndex;

public interface IndexList{

	public int size();


	public boolean isEmpty();


	public void add(AlunoIndex e);


	public AlunoIndex remove(int i);

}
