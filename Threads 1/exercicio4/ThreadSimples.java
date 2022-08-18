package aula_29.exercicio4;

//Definição da classe pública ThreadSimples
//Classe principal que define a classe Loop e a classe main
public class ThreadSimples {

	// Definição do método estático mensagem que recebe uma string como paramêtro
	static void mensagem(String messagem) {
		// A variável do tipo string nomeThread recebe como string o nome desta thread
		String nomeThread = Thread.currentThread().getName();
		// O sistema imprime no console o nome da thread e a mensagem passada no
		// paramêtro
		System.out.println(nomeThread + " " + messagem);
	}

	/*
	 * Definição da classe privada e estática Loop que implementa a interface
	 * Runnable
	 */
	/*
	 * Classe que vai ser executada como uma thread separada da thread main para
	 * imprimir um texto divido em quatro partes
	 */
	private static class Loop implements Runnable {
		// Deefinição do método run herdado da interface Runnable
		public void run() {
			// Definição de uma variável do tipo vetor de string chamada info que recebe
			// quatro strings
			String info[] = { "Java", "é uma boa linguagem.", "Com threads,", "é melhor ainda." };
			// Começo do bloco try-catch
			try {
				// Definição de um loop que executa o tamanho do vetor info vezes
				for (int i = 0; i < info.length; i++) {
					// Esta thread fica no estado de sleep por 4 segundos
					Thread.sleep(4000);
					// É chamado o método mensagem passando a string na posição i do vetor info como
					// paramêtro
					mensagem(info[i]);
				}
				// Catch que captura se ocorrer uma interrupção da thread
			} catch (InterruptedException e) {
				// É chamado o método mensagem passando a string "Nada feito!" como paramêtro
				mensagem("Nada feito!");
			}
		}
	}

	// Definição da classe main fazendo um throws da exceção de interrupção
	/*
	 * Classe main que vai criar uma instância da classe Loop
	 * e ficar esperando ou até sua execução completa ou um
	 * exceder um tempo limite
	 */
	public static void main(String args[]) throws InterruptedException {
		/*
		 * Definição de uma variável do tipo long chamada paciencia que recebe como
		 * valor a multiplicação dos números 1000, 60 e 60
		 */
		long paciencia = 1000 * 60 * 60;
		// Um if que verifica se foi passado argumentos ao executar o main
		if (args.length > 0) {
			// Começo do bloco try-catch
			try {
				/*
				 * A variável paciencia recebe como valor a multiplicação do número passado como
				 * argumento com o número 1000
				 */
				paciencia = Long.parseLong(args[0]) * 1000;
				// Catch que captura se o argumento passado não for um número
			} catch (NumberFormatException e) {
				/*
				 * O sistema printa uma mensagem de erro com a string "Argumento deve ser um
				 * inteiro."
				 */
				System.err.println("Argumento deve ser um inteiro.");
				// O programa é finalizado
				System.exit(1);
			}
		}
		/*
		 * É chamado o método mensagem passando a string "Iniciando a thread Loop" como
		 * paramêtro
		 */
		mensagem("Iniciando a thread Loop");
		/*
		 * Definição de uma variável do tipo long chamada inicio que recebe o horário do
		 * sistema em milissegundos
		 */
		long inicio = System.currentTimeMillis();
		// Criação de uma nova thread chamada t usando a classe Loop
		Thread t = new Thread(new Loop());
		// Iniciando a thread t
		t.start();
		/*
		 * É chamado o método mensagem passando a string
		 * "Esperando que a thread Loop termine" como paramêtro
		 */
		mensagem("Esperando que a thread Loop termine");
		// Loop que é executado enquanto a thread t estiver viva
		while (t.isAlive()) {
			/*
			 * É chamado o método mensagem passando a string "Ainda esperando..." como
			 * paramêtro
			 */
			mensagem("Ainda esperando...");
			// A thread main suspende sua execução até que a thread t execute por 1 segundo
			t.join(1000);

			/*
			 * Um if que verifica se o tempo de execução do programa excedeu o valor da
			 * váriavel paciencia e se a thread t ainda está viva
			 */
			if (((System.currentTimeMillis() - inicio) > paciencia) && t.isAlive()) {
				/*
				 * É chamado o método mensagem passando a string "Cansado de esperar!" como
				 * paramêtro
				 */
				mensagem("Cansado de esperar!");
				// A thread t é interrompida
				t.interrupt();
				// A thread main suspende sua execução até que a thread t termine sua execução
				t.join();
			}
		}
		// É chamado o método mensagem passando a string "Finalmente!" comoparamêtro
		mensagem("Finalmente!");
	}
}
