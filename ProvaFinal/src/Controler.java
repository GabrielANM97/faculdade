import java.util.Scanner;

import exceptions.AlunoIndexNotFoundException;
import exceptions.EmptyStackException;
import exceptions.FullStackException;
import implementation.Aluno;
import implementation.AlunoIndex;
import implementation.ArrayIndexListAluno;
import implementation.ArrayStackAluno;

public class Controler {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayIndexListAluno indexList = new ArrayIndexListAluno();
		int numero;
		System.out.println("Seja bem vindo ao SGBD!!!!");

		System.out.println("Qual o tamanho da pilha de alunos que você deseja adicionar??");
		ArrayStackAluno<Aluno> pilha = new ArrayStackAluno<Aluno>(scanner.nextInt());

		System.out.println("Digite '1' para adicionar um novo aluno ao banco de dados");
		System.out.println("Digite '2' para listar todos os alunos dentro do banco de dados");
		System.out.println("Digite '3' para buscar um aluno no banco de dados");
		System.out.println("Digite '4' para excluir um aluno do banco de dados");
		System.out.println("Digite '0' para encerrar o programa");
		
		while(true) {
			
			numero = scanner.nextInt();
			
			if (numero == 0) {break;}
			
			if (numero == 1) {
				
				try {
					long RA=0, celular=0;
					String nome="", endereco="", dataNasc="";
					
					System.out.println("Digite o RA do aluno");
					RA = scanner.nextLong();
					
					scanner.nextLine();
					
					System.out.println("Digite o nome do aluno");
					nome = scanner.nextLine();
					
					System.out.println("Digite o endereço do aluno");
					endereco = scanner.nextLine();
					
					System.out.println("Digite o número de celular do aluno");
					celular = scanner.nextLong();
					
					scanner.nextLine();
					
					System.out.println("Digite a data de nascimento do aluno");
					dataNasc = scanner.next();
					
					Aluno aluno = new Aluno(RA, nome, endereco, celular, dataNasc);
					AlunoIndex index = new AlunoIndex(aluno.getRA(), aluno);
					
					pilha.push(aluno);
					indexList.add(index);
				} catch(FullStackException e) {
					System.out.println("O limite de alunos no banco de dados foi atingido");
				}
			}
			
			if (numero == 2) {
				System.out.println(pilha.toString());
			}
			
			if (numero == 3) {
				try {
					System.out.println("Digite o RA do aluno");
					System.out.println(indexList.binarySearch(scanner.nextLong()));
				} catch(AlunoIndexNotFoundException e) {
					System.out.println(e.getMessage());
				} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("O banco de dados está vazio");
				}
			}
			
			if (numero == 4) {
				try {
					indexList.remove(pilha.pop().getRA());
					System.out.println("Aluno removido");
				} catch(EmptyStackException e) {
					System.out.println("O banco de dados está vazio");
				}
			}
			
			
			System.out.println("\nDigite um novo numero");
		}
		
		scanner.close();
	}

}
