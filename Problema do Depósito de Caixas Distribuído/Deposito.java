public class Deposito {
	private int items = 0;
	private final int capacidade = 10;

	public synchronized int retirar() {
		while (items == 0) {
			try {
				System.out.println(Thread.currentThread().getName() + " esta esperando por caixa");
				this.wait();
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

		this.notifyAll();
		items--;
		System.out.println("Caixa retirada: Sobram " + items + " caixas");
		return (items - 1);
	}

	public synchronized int colocar() {
		while (items == capacidade) {
			try {
				System.out.println(Thread.currentThread().getName() + " esta esperando");
				this.wait();
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

		this.notifyAll();
		items++;
		System.out.println("Caixa armazenada: Passaram a ser " + items + " caixas");
		return (items);
	}
}
