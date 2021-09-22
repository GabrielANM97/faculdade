package implementation;

public class LinearFibonacci {
	
	public static FibonacciAux linearFibonacci(int k) {
		int i;
		int j;
		
		FibonacciAux aux = new FibonacciAux();
		if (k <= 1) {
			aux.setI(k);
			
			aux.setJ(0);
			
			return aux;
		}
		else {
			i = linearFibonacci(k - 1).getI();
			
			j = linearFibonacci(k - 1).getJ();
		
			aux.setI(i + j);
			
			aux.setJ(i);
		}
		
		return aux;
	}
}
