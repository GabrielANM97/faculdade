package interfaces;

import exceptions.EmptyStackException;
import implementation.Aluno;

public interface Stack {
	
	public int size();
	
	
	public boolean isEmpty();
	
	
	public Aluno top() throws EmptyStackException;
	
	
	public void push(Aluno element);
	
		
	public Aluno pop() throws EmptyStackException;

}