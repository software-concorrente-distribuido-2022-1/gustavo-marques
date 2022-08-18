package threads2.exercicio2;

public class Produtor implements Runnable {
	private Deposito deposito;
	private int tempoProducao;

	public Produtor(Deposito deposito, int tempoProducao) {
		this.deposito = deposito;
		this.tempoProducao = tempoProducao;
	}

	public void run() {
		while (true) {
			try {
				deposito.colocar();
				Thread.sleep(tempoProducao * 1000);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}
