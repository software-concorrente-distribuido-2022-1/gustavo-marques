import java.net.*;
import java.util.Arrays;
import java.io.*;

class Conexao extends Thread {

	private Socket socketCliente;

	Conexao(Socket aSocketCliente) throws IOException {
		this.socketCliente = aSocketCliente;
	}

	public void run() {
		PrintWriter saida = null;
		BufferedReader entrada = null;

		InetAddress endCliente = this.socketCliente.getInetAddress();

		String nome = null;
		String nivel = null;
		double salarioBruto = 0.0;
		int qtdDependentes = 0;
		double salarioLiquido = 0.0;
		String situacao = null;
		String[] mensagem = null;

		try {
			saida = new PrintWriter(this.socketCliente.getOutputStream(), true);
			entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));

			mensagem = entrada.readLine().split(",");
			nome = mensagem[0];
			nivel = mensagem[1];
			salarioBruto = Double.parseDouble(mensagem[2]);
			qtdDependentes = Integer.parseInt(mensagem[3]);

			if (nivel.toUpperCase().equals("A")) {
				if (qtdDependentes > 0) {
					salarioLiquido = salarioBruto * 0.92;
				} else {
					salarioLiquido = salarioBruto * 0.97;
				}
			} else if (nivel.toUpperCase().equals("B")) {
				if (qtdDependentes > 0) {
					salarioLiquido = salarioBruto * 0.90;
				} else {
					salarioLiquido = salarioBruto * 0.95;
				}
			} else if (nivel.toUpperCase().equals("C")) {
				if (qtdDependentes > 0) {
					salarioLiquido = salarioBruto * 0.85;
				} else {
					salarioLiquido = salarioBruto * 0.92;
				}
			} else if (nivel.toUpperCase().equals("D")) {
				if (qtdDependentes > 0) {
					salarioLiquido = salarioBruto * 0.83;
				} else {
					salarioLiquido = salarioBruto * 0.90;
				}
			}

			saida.println("Nome: " + nome);
			saida.println("Nivel: " + nivel.toUpperCase());
			saida.println("Salario liquido: R$" + String.format("%.2f", salarioLiquido));

			System.out.println(
					"Cliente " + endCliente.getHostAddress() + " atendido com a mensagem " + Arrays.toString(mensagem));

			socketCliente.close();
			saida.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("Erro E/S " + e);
		}
	}
}

public class Servidor {
	public static void main(String[] args) throws IOException {

		final int portaDefault = 8080;
		int porta;

		Socket socketCliente = null;
		ServerSocket socketServidor = null;

		if ((args.length == 1))
			porta = Integer.parseInt(args[0]);
		else
			porta = portaDefault;

		while (true) {
			try {
				socketServidor = new ServerSocket(porta);
				break;
			} catch (IOException e) {
				porta++;
			}
		}

		System.out.println("\nServidor ativado. " + "Aguardando Cliente na porta " + porta + "...\n");

		while (true) {

			socketCliente = null;
			try {
				socketCliente = socketServidor.accept();
			} catch (IOException e) {
				System.err.println("Erro de E/S " + e);
				System.exit(1);
			}

			new Conexao(socketCliente).start();
		}
	}
}
