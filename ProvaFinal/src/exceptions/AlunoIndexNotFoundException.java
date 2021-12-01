package exceptions;

@SuppressWarnings("serial")

public class AlunoIndexNotFoundException extends RuntimeException{
	
	public AlunoIndexNotFoundException(String err) {
		super(err);
	}
	
}
