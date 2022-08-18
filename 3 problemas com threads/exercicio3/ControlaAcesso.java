package exercicio3;

public class ControlaAcesso {
	private boolean ocupado = false;
	private Conta recurso;

	public ControlaAcesso(Conta conta) {
		recurso = conta;
	}

	public synchronized void release() {
		ocupado = false;
		notifyAll();
	}

	public synchronized void request() {
		while (ocupado) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ocupado = true;
	}

	public void depositarSaldo(double valor) {
		recurso.depositar(valor);
	}

	public void atualizarSaldo(double taxa) {
		recurso.atualizar(taxa);
	}

	public void imprimirSaldo() {
		recurso.imprimirSaldo();
	}
}
