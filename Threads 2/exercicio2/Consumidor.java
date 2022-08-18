package threads2.exercicio2;

public class Consumidor implements Runnable {
	private Deposito deposito;
	private int tempoRetirada;

	public Consumidor(Deposito deposito, int tempoRetirada) {
		this.deposito = deposito;
		this.tempoRetirada = tempoRetirada;
	}

	public void run() {
		while (true) {
			try {
				deposito.retirar();
				System.out.println("Consumidor " + Thread.currentThread().getName() + " retirou caixa");
				Thread.sleep(tempoRetirada * 1000);
				System.out.println("Consumidor " + Thread.currentThread().getName() + " pode retirar nova caixa");
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}
