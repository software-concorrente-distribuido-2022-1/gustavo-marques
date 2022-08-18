package exercicio3;

public class ThreadDeposito extends Thread {
	private ControlaAcesso monitor;
	private double valor;

	public ThreadDeposito(double valor, ControlaAcesso monitor) {
		this.monitor = monitor;
		this.valor = valor;
	}

	public void run() {
		monitor.request();
		monitor.depositarSaldo(valor);
		monitor.imprimirSaldo();
		monitor.release();
	}
}
