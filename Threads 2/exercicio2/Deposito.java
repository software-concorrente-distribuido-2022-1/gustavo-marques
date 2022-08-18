package threads2.exercicio2;

public class Deposito {
	private int items = 0;
	private final int capacidade = 10;

	public synchronized void retirar() {
		while (items == 0) {
			try {
				System.out.println("Consumidor " + Thread.currentThread().getName() + " está esperando por caixa");
				this.wait();
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

		this.notifyAll();
		items--;
		System.out.println("Caixa retirada: Sobram " + items + " caixas");
	}

	public synchronized void colocar() {
		while (items == capacidade) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

		this.notifyAll();
		items++;
		System.out.println("Caixa armazenada: Passaram a ser " + items + " caixas");
	}

	public static void main(String[] args) {
		Deposito dep = new Deposito();
		Produtor p1 = new Produtor(dep, 2);
		Produtor p2 = new Produtor(dep, 3);
		Consumidor c1 = new Consumidor(dep, 3);
		Consumidor c2 = new Consumidor(dep, 4);
		Consumidor c3 = new Consumidor(dep, 5);

		Thread produtor1 = new Thread(p1);
		Thread produtor2 = new Thread(p2);
		produtor1.start();
		produtor2.start();

		Thread consumidor1 = new Thread(c1);
		Thread consumidor2 = new Thread(c2);
		Thread consumidor3 = new Thread(c3);
		consumidor1.start();
		consumidor2.start();
		consumidor3.start();

		System.out.println("Execução do main da classe Deposito terminada!");
	}
}
