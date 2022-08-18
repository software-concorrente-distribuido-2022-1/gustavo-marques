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

		double nota1 = 0.0;
		double nota2 = 0.0;
		double nota3 = 0.0;
		double media = 0.0;
		String situacao = null;
		String[] mensagem = null;

		try {
			saida = new PrintWriter(this.socketCliente.getOutputStream(), true);
			entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));

			mensagem = entrada.readLine().split(",");
			nota1 = Double.parseDouble(mensagem[0]);
			nota2 = Double.parseDouble(mensagem[1]);
			nota3 = Double.parseDouble(mensagem[2]);

			media = (nota1 + nota2) / 2;
			if (media >= 7.0) {
				situacao = "Aprovado";
			} else if (media > 3.0 && media < 7.0) {
				media = (media + nota3) / 2;
				if (media >= 5.0) {
					situacao = "Aprovado";
				} else {
					situacao = "Reprovado";
				}
			} else {
				situacao = "Reprovado";
			}

			saida.println(situacao);

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
