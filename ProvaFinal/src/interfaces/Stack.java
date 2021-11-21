package interfaces;

import exceptions.EmptyStackException;

public interface Stack<Aluno> {
	
	public int size();
	
	
	public boolean isEmpty();
	
	
	public Aluno top() throws EmptyStackException;
	
	
	public void push(Aluno element);
	
		
	public Aluno pop() throws EmptyStackException;

}