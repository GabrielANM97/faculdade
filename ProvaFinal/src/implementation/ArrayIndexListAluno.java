package implementation;

import exceptions.AlunoIndexNotFoundException;
import interfaces.IndexList;

public class ArrayIndexListAluno implements IndexList {

	private AlunoIndex[] A;

	private int capacity = 16;

	private int size = 0;


	// cria uma instancia de AlunoIndex chamado A com o tamanho de capacity
	public ArrayIndexListAluno() { A = new AlunoIndex[capacity]; }
	
	// retorna o tamanho do vetor
	public int size() { return size; }

	// verifica se o vetor está vazio, retornando true ou false
	public boolean isEmpty() { return size() == 0; }

	
	public void add(AlunoIndex index) {

		// verifica se a capacidade é igual ao tamanho do vetor
		if (size == capacity) {

			// duplica a capacidade
			capacity *= 2;
			
			// cria um AlunoIndex chamado B
			AlunoIndex[] B = (AlunoIndex[]) new Object[capacity];

			// percorre o vetor do indice zero até o valor do size 
			for (int i = 0; i < size; i++) {
				
				// atribui cada valor do vetor A ao vetor B, retirando as posicoes nao usadas
				B[i] = A[i];
			}

			// atribui o vetor B ao vetor A
			A = B;

		}
		
		// verifica se não há valores no vetor 
		if (size == 0) {
			
			// adiciona o valor informado na primeira posicao
			A[0] = index;
		}
		else {
			
			// percorre todo o vetor partindo da posicao final até o indice 1
			for (int i = size; i > 0; i--) {
				
				// verifica se o RA informado é menor que o valor do vetor
				if(A[i-1].getRA() > index.getRA()) {
					
					// substitui a posição atual da lista pela posição subsequente.
					A[i] = A[i - 1];
					
					/// substitui a posição atual da lista pelo valor informado
					A[i - 1] = index;
				}
				else {
					
					// atribui o valor informado para posicao seguinte 
					A[i] = index;
					break;
				}
			}
		}
		size++;
	}


	public void remove(long RA) {
		
		// percorre todo o vetor partindo da posição 0 até o final.
		for(int i = 0; i < size; i++) {
			
			// vefirica se o RA informado é maior ou igual a algum RA dentro da lista.
			if(A[i].getRA() >= 	RA) {
				
				// substitui a posição atual da lista pela posição subsequente.
				A[i] = A[i + 1];
			}
		}
		
		size--;
	}
	
	public Aluno binarySearch(long RA) {
	    int start = 0;         //Posição inicial do vetor.
	    int middle = 0;          //Posição do meio do vetor.
	    int end = size() - 1;  //Posição final do vetor.
	    Aluno aluno = null;
	    
	    /* Enquanto a posição do inicio for menor ou igual a posição do fim,
	      procura o valor de x dentro do vetor. */
	    while(start <= end) {
	    	middle = (end + start) / 2; //Encontra o meio do vetor.
	    	
	      
	    	/* Se o valor que está no meio do vetor é igual ao valor procurado, 
	        	imprime que encontrou o valor e para de pesquisar. */
	    	if(A[middle].getRA() == RA) {
	    		aluno = A[middle].getAluno();
	    		break;
	    	}
	      
	      /* Este if serve para diminuir o tamanho do vetor pela métade. */
	      /* Se o valor que está no meio do vetor for menor que o valor de x, 
	      	então o inicio do vetor será igual a posição do meio + 1. */
	    	if(A[middle].getRA() < RA) {
	    		start = middle + 1;
	    	} else {
	    		/* Se o valor que está no meio do vetor for maior que o valor de x, 
	          		então o fim do vetor será igual a posição do meio - 1. */
	    		end = middle - 1;
	    	}
	    }
	    
	    // Caso não encontre o valor pesquisado dentro do vetor, lança uma exception.
	    if(start > end) {
	    	throw new AlunoIndexNotFoundException("O RA digitado não corresponde a nenhum aluno do banco de dados");
	    }
	    
	    return aluno;
	}


	public String toString() {

		String toReturn = "(";

		if (size() == 0) return "()";

		for (int i = 0; i < size(); i++) toReturn += A[i].toString() + ",\n";

		return toReturn.substring(0, toReturn.length() - 2) + ")";

	}
}
