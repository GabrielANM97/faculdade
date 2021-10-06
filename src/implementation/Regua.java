package implementation;

public class Regua {
	// desenha uma marca sem rótulo
	public static void drawOneTick(int tickLength) {  drawOneTick(tickLength, -1);  }
	// desenha uma marca
	public static void drawOneTick(int tickLength, int tickLabel) {
		for (int i = 0; i < tickLength; i++) System.out.print("-");
		if (tickLabel >= 0) System.out.print(" " + tickLabel);
		System.out.print("\n");
	}
	public static void drawTicks(int tickLength) {
		// desenha marcas de certo comprimento
		if (tickLength > 0) { // para quando o comprimento chega a 0
			drawTicks(tickLength - 1); // desenha recursivamente as marcas da esquerda
			drawOneTick(tickLength); // desenha a marca central
			drawTicks(tickLength - 1); // desenha recursivamente as marcas da direita
		}
	}
	public static void drawRuler(int nInches, int majorLength) {// desenha a régua
		drawOneTick(majorLength, 0); // desenha a marca 0 e seu rótulo
		for (int i = 1; i <= nInches; i++) {
			drawTicks(majorLength - 1); // desenha as marcas para esta polegada
			drawOneTick(majorLength, i); // desenha a marca i e seu rótulo
		}
	}

	public static void main(String[] args) {
		drawRuler(1, 5);
	}
}
