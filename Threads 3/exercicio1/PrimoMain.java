package Threads3.exercicio1;

public class PrimoMain {

	public static void main(String[] args) {
		NumeroPrimo np1 = new NumeroPrimo(1000000, 30000000);
		NumeroPrimo np2 = new NumeroPrimo(90000000, 120000000);
		
		np1.start();
		np2.start();
	}

}
