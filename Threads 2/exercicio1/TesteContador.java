package threads2.exercicio1;

public class TesteContador {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread contador = new Thread(new Contador());
			contador.start();
		}
	}

}
