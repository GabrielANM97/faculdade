package implementation;

public class AlunoIndex {
	protected long RA;
	protected Aluno aluno;
	
	public AlunoIndex(long RA, Aluno aluno) {
		this.RA = RA;
		this.aluno = aluno;
	}
	
	// Geters
	public long getRA() { return RA; }
	
	public Aluno getAluno() { return aluno; }
	
	// Seters
	public void setRA(long RA) { this.RA = RA; }
	
	public void setAluno(Aluno aluno) { this.aluno = aluno; }
	
	public String toString() {
		return "O numero de RA " + RA + " corresponde ao aluno: " + aluno;
	}
}
