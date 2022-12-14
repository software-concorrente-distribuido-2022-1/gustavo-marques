import java.net.*;
import java.util.Arrays;
import java.io.*;

class Conexao {

	private Socket socketCliente;

	Conexao(Socket aSocketCliente) throws IOException {
		this.socketCliente = aSocketCliente;
	}

	public void iniciar() {
		PrintWriter saida = null;
		BufferedReader entrada = null;

		InetAddress endCliente = this.socketCliente.getInetAddress();

		int idade = 0;
		int tempoServico = 0;
		String aposentadoria = null;
		String[] mensagem = null;

		try {
			saida = new PrintWriter(this.socketCliente.getOutputStream(), true);
			entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));

			mensagem = entrada.readLine().split(",");
			idade = Integer.parseInt(mensagem[0]);
			tempoServico = Integer.parseInt(mensagem[1]);

			if (idade >= 65) {
				aposentadoria = "Ja pode se aposentar";
			} else if (tempoServico >= 30) {
				aposentadoria = "Ja pode se aposentar";
			} else if (idade >= 60 && tempoServico >= 25) {
				aposentadoria = "Ja pode se aposentar";
			} else {
				aposentadoria = "Ainda nao pode se aposentar";
			}

			saida.println(aposentadoria);

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
				socketServidor.close();
				System.exit(1);
			}

			new Conexao(socketCliente).iniciar();
		}
	}
}
