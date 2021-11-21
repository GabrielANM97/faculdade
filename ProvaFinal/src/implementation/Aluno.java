package implementation;

public class Aluno {
	
	private long RA;
	
	private String nome;
	
	private String endereco;
	
	private long celular;
	
	private String dataDeNascimento;
	
	public Aluno(long RA, String nome, String endereco, long celular, String dataDeNascimento) {
		this.RA = RA;
		this.nome = nome;
		this.endereco = endereco;
		this.celular = celular;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	// Geters
	public long getRA() { return RA; }
	
	public String getNome() { return nome; }
	
	public String getEndereco() { return endereco; }
	
	public long getCelular() { return celular; }
	
	public String getDataDeNascimento() { return dataDeNascimento; }
	
	// Seters
	public void setRA(long RA) { this.RA = RA; }
	
	public void setNome(String nome) { this.nome = nome; }
	
	public void setEndereco(String endereco) { this.endereco = endereco; }
	
	public void setCelular(long celular) { this.celular = celular; }
	
	public void setDataDeNascimento(String dataDeNascimento) { this.dataDeNascimento = dataDeNascimento; }
	
	public String toString() {
		return "RA: " + RA + "\n" + "Nome: " + nome + "\n" + "Endereço: " + endereco + "\n" + "Celular: " + celular + "\n" + "Data de nascimento: " + dataDeNascimento;
	}

}
