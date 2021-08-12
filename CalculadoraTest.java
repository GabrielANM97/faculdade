package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculadora.Calculadora;

class CalculadoraTest {

	@Test
	void somaTeste() {
		Calculadora calc = new Calculadora();
		assertEquals(2.0, calc.soma(1.0, 1.0), "Deve Resultar 2.0");
	}
	
	@Test
	void subtracaoTeste() {
		Calculadora calc = new Calculadora();
		assertEquals(2.0, calc.subtracao(3.0, 1.0), "Deve Resultar 2.0");
	}
	
	@Test
	void multiplicacaoTeste() {
		Calculadora calc = new Calculadora();
		assertEquals(2.0, calc.multiplicacao(2.0, 1.0), "Deve Resultar 2.0");
	}
	
	@Test
	void divisaoTeste() {
		Calculadora calc = new Calculadora();
		assertEquals(2.0, calc.divisao(4.0, 2.0), "Deve Resultar 2.0");
	}
	
	@Test
	void potenciaTeste() {
		Calculadora calc = new Calculadora();
		assertEquals(2.0, calc.potencia(2.0, 1.0), "Deve Resultar 2.0");
	}

}
