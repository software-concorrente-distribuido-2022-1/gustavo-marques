package aplicacao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Gerador {

	public static int numeroInteiro(int minimo, int maximo) {
		if (minimo >= maximo) {
			return 0;
		}
		final Random random = new Random();
		return random.nextInt(maximo - minimo) + minimo;
	}

	public static String nome() {
		ArrayList<String> nomes = new ArrayList<String>(Arrays.asList("Maria", "Jose", "Ana", "Joao", "Francisca",
				"Antonio", "Antonia", "Francisco", "Adriana", "Carlos", "Juliana", "Paulo", "Marcia", "Pedro",
				"Fernanda", "Lucas", "Patricia", "Luiz", "Aline", "Marcos"));
		ArrayList<String> sobrenomes = new ArrayList<String>(Arrays.asList("Silva", "Santos", "Oliveira", "Souza",
				"Rodrigues", "Ferreira", "Alves", "Pereira", "Lima", "Gomes", "Costa", "Ribeiro", "Martins", "Carvalho",
				"Almeida", "Lopes", "Soares", "Fernandes", "Vieira", "Barbosa"));

		String nome = nomes.get(numeroInteiro(0, nomes.size() - 1)) + " "
				+ sobrenomes.get(numeroInteiro(0, sobrenomes.size() - 1)) + " "
				+ sobrenomes.get(numeroInteiro(0, sobrenomes.size() - 1));
		return nome;
	}

	public static String titulo() {
		ArrayList<String> substantivos = new ArrayList<String>(
				Arrays.asList("Coracao", "Saudade", "Felicidade", "Tristeza", "Mundo", "Pai", "Mae", "Filho", "Filha",
						"Vida", "Amor", "Cidade", "Campo", "Tempo", "Pessoa"));
		ArrayList<String> adjetivos = new ArrayList<String>(
				Arrays.asList("Estranho", "Complexo", "Pesado", "Nostalgico", "Eterno", "Doce", "Rico", "Pobre",
						"Inesperado", "Alegre", "Violento", "Belo", "Rapido", "Grave", "Desajeitado"));

		String titulo = substantivos.get(numeroInteiro(0, substantivos.size() - 1));
		int temAdjetivo = numeroInteiro(1, 10);
		if (temAdjetivo % 2 == 0) {
			titulo = titulo + " " + adjetivos.get(numeroInteiro(0, adjetivos.size() - 1));
		}
		return titulo;
	}

	public static Time tempo(int horaMin, int horaMax, int minutoMin, int minutoMax, int segundoMin, int segundoMax) {
		LocalTime lt = LocalTime.of(numeroInteiro(horaMin, horaMax), numeroInteiro(minutoMin, minutoMax),
				numeroInteiro(segundoMin, segundoMax));
		return Time.valueOf(lt);
	}

	public static Date data(int anoMin, int anoMax) {
		int ano = numeroInteiro(anoMin, anoMax);
		int mes = numeroInteiro(1, 12);
		int dia;
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			dia = numeroInteiro(1, 30);
		} else if (mes == 2) {
			if (ano % 4 == 0) {
				dia = numeroInteiro(1, 29);
			} else {
				dia = numeroInteiro(1, 28);
			}
		} else {
			dia = numeroInteiro(1, 31);
		}

		return Date.valueOf(LocalDate.of(ano, mes, dia));
	}

	public static String cpf() {
		ArrayList<Integer> cpf = new ArrayList<Integer>();
		while (!validarCPF(cpf)) {
			cpf.clear();
			for (int i = 0; i < 11; i++) {
				cpf.add(numeroInteiro(0, 9));
			}
		}
		String cpfAux = cpf.toString().replaceAll(", ", "").replace("]", "").replace("[", "");
		return cpfAux;
	}

	private static boolean validarCPF(ArrayList<Integer> cpf) {
		if (cpf.isEmpty()) {
			return false;
		}
		int multiplicacao = (cpf.get(0) * 10) + (cpf.get(1) * 9) + (cpf.get(2) * 8) + (cpf.get(3) * 7)
				+ (cpf.get(4) * 6) + (cpf.get(5) * 5) + (cpf.get(6) * 4) + (cpf.get(7) * 3) + (cpf.get(8) * 2);
		int verificador = (multiplicacao * 10) % 11;
		if (verificador == 10) {
			verificador = 0;
		}
		if (verificador != cpf.get(9)) {
			return false;
		}
		multiplicacao = (cpf.get(0) * 11) + (cpf.get(1) * 10) + (cpf.get(2) * 9) + (cpf.get(3) * 8) + (cpf.get(4) * 7)
				+ (cpf.get(5) * 6) + (cpf.get(6) * 5) + (cpf.get(7) * 4) + (cpf.get(8) * 3) + (cpf.get(9) * 2);
		verificador = (multiplicacao * 10) % 11;
		if (verificador == 10) {
			verificador = 0;
		}
		if (verificador != cpf.get(10)) {
			return false;
		}
		return true;
	}
}
