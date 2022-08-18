package exercicio3;

public class ThreadAtualizacao extends Thread {
	private ControlaAcesso monitor;

	public ThreadAtualizacao(ControlaAcesso monitor) {
		this.monitor = monitor;
	}

	public void run() {
		monitor.request();
		monitor.atualizarSaldo(0.1);
		monitor.imprimirSaldo();
		monitor.release();
	}

}
