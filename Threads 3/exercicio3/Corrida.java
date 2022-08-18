package Threads3.exercicio3;

import java.util.ArrayList;

public class Corrida extends Thread {
	private static ArrayList<LebreThread> colocacao = new ArrayList<LebreThread>();

	public static void addLebreColocacao(LebreThread lebre) {
		Corrida.colocacao.add(lebre);
	}

	public void run() {
		LebreThread l1 = new LebreThread(1);
		LebreThread l2 = new LebreThread(2);
		LebreThread l3 = new LebreThread(3);
		LebreThread l4 = new LebreThread(4);
		LebreThread l5 = new LebreThread(5);

		l1.start();
		l2.start();
		l3.start();
		l4.start();
		l5.start();

		try {
			l1.join();
			l2.join();
			l3.join();
			l4.join();
			l5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String texto = "\nFIM DA CORRIDA!\nVencendora: Lebre " + colocacao.get(0).getNumeroLebre();
		texto = texto + "\n\nColocação";
		int posicao = 0;
		for (LebreThread lebre : colocacao) {
			posicao = posicao + 1;
			texto = texto + "\n" + posicao + "º Lugar: Lebre " + lebre.getNumeroLebre() + " - " + lebre.getQtdPulos()
					+ " pulos";
		}
		System.out.println(texto);
	}
}
