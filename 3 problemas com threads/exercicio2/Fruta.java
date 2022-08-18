package exercicio2;

public class Fruta extends Thread {
	private String nome;

	public Fruta(String nome) {
		this.nome = nome;
	}

	public void run() {
		System.out.println(nome);
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
