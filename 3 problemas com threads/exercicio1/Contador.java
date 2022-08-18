package exercicio1;

public class Contador extends Thread {

	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
		System.out.println("Programa finalizado");
	}
}
