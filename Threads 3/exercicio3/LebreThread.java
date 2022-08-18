package Threads3.exercicio3;

public class LebreThread extends Thread {
	private int numeroLebre;
	private int qtdPulos = 0;
	private int distanciaPercorrida = 0;

	public LebreThread(int numeroLebre) {
		this.numeroLebre = numeroLebre;
	}

	public int getNumeroLebre() {
		return numeroLebre;
	}

	public int getQtdPulos() {
		return qtdPulos;
	}

	public void run() {
		int distanciaPulo;
		while (true) {
			distanciaPulo = (int) ((Math.random() * (4 - 1)) + 1);
			qtdPulos = qtdPulos + 1;
			System.out.println("Lebre " + numeroLebre + " saltou " + distanciaPulo + " metros");
			distanciaPercorrida = distanciaPercorrida + distanciaPulo;
			if (distanciaPercorrida >= 20) {
				System.out.println("Lebre " + numeroLebre + " finalizou a corrida");
				Corrida.addLebreColocacao(this);
				return;
			}
			yield();
		}
	}
}
