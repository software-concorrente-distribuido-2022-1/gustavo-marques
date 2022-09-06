import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Deposito extends UnicastRemoteObject implements Metodos{
	
	protected Deposito() throws RemoteException {
		super();
	}

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

		items--;
		System.out.println("Caixa retirada: Sobram " + items + " caixas");
		this.notifyAll();
		return (items);
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

		items++;
		System.out.println("Caixa armazenada: Passaram a ser " + items + " caixas");
		this.notifyAll();
		return (items);
	}

	public static void main(String[] args)  {
		try {
			Metodos obj = new Deposito();
			Naming.rebind("//localhost/Deposito", obj);
			System.out.println("Servidor bound in registry");
		} catch (Exception e) {
			System.out.println("Servidor err: " + e.getMessage());
            e.printStackTrace();
		}
	}
}
