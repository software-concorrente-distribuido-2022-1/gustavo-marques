package aula_29.exercicio3;

public class ThreadSimples {
	public static void main(String args[]) throws InterruptedException {
		String info[] = { "Java", "é uma boa linguagem.", "Com threads", "é melhor ainda.", Thread.currentThread().getName()};
		for (int i = 0; i < info.length; i++) {
			Thread.sleep(4000);
			System.out.println(info[i]);
		}
	}
}
