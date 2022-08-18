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
		String sexo = null;
		int idade = 0;
		String[] mensagem = null;

		try {
			saida = new PrintWriter(this.socketCliente.getOutputStream(), true);
			entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));

			mensagem = entrada.readLine().split(",");
			nome = mensagem[0];
			sexo = mensagem[1];
			idade = Integer.parseInt(mensagem[2]);

			saida.println("Nome: " + nome);
			if (sexo.toLowerCase().equals("masculino")) {
				if (idade >= 18) {
					saida.println("Maior de idade");
				} else {
					saida.println("Menor de idade");
				}
			} else if (sexo.toLowerCase().equals("feminino")) {
				if (idade >= 21) {
					saida.println("Maior de idade");
				} else {
					saida.println("Menor de idade");
				}
			}

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
