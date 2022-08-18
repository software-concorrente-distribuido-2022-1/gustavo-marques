package Threads3.exercicio1;

public class NumeroPrimo extends Thread {
	private long numeroInicial, numeroFinal, tempoInicial, tempoFinal;
	private int qtdPrimos = 0;

	public NumeroPrimo(long numeroInicial, long numeroFinal) {
		this.numeroInicial = numeroInicial;
		this.numeroFinal = numeroFinal;
	}

	public void run() {
		tempoInicial = System.currentTimeMillis();
		for (long i = numeroInicial; i <= numeroFinal; i++) {
			if (i == 2) {
				System.out.println("Número primo entre " + numeroInicial + " e " + numeroFinal + ": 2");
				qtdPrimos++;
			} else if (!(i % 2 == 0) && i > 2) {
				long valorLimite = (long) Math.floor(Math.sqrt(i));
				boolean ePrimo = true;
				for (long j = 3; j <= valorLimite; j++) {
					if (i % j == 0) {
						ePrimo = false;
						break;
					}
				}
				if (ePrimo) {
					System.out.println("Número primo entre " + numeroInicial + " e " + numeroFinal + ": " + i);
					qtdPrimos++;
				}
			}
		}
		tempoFinal = System.currentTimeMillis();
		String texto = "Quantidade de números primos entre " + numeroInicial + " e " + numeroFinal + ": " + qtdPrimos
				+ "\n" + tempoGasto();
		System.out.println(texto);
	}

	private String tempoGasto() {
		int segundos = 0;
		int minutos = 0;
		int horas = 0;
		String texto = "Tempo gasto: ";

		segundos = (int) ((tempoFinal - tempoInicial) / 1000);
		if (segundos >= 60) {
			minutos = segundos / 60;
			segundos = segundos % 60;
		}
		if (minutos >= 60) {
			horas = minutos / 60;
			minutos = minutos % 60;
		}

		if (horas > 0) {
			texto = texto + horas + " horas " + minutos + " minutos " + segundos + " segundos";
		} else {
			if (minutos > 0) {
				texto = texto + minutos + " minutos " + segundos + " segundos";
			} else {
				texto = texto + segundos + " segundos";
			}
		}
		return texto;
	}
}
