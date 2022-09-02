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

		int valor = 0;
		int naipe = 0;
		String nome = null;
		String[] mensagem = null;

		try {
			saida = new PrintWriter(this.socketCliente.getOutputStream(), true);
			entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));

			mensagem = entrada.readLine().split(",");
			valor = Integer.parseInt(mensagem[0]);
			naipe = Integer.parseInt(mensagem[1]);

			switch (valor) {
			case 1:
				nome = "As de ";
				break;
			case 2:
				nome = "Dois de ";
				break;
			case 3:
				nome = "Tres de ";
				break;
			case 4:
				nome = "Quatro de ";
				break;
			case 5:
				nome = "Cinco de ";
				break;
			case 6:
				nome = "Seis de ";
				break;
			case 7:
				nome = "Sete de ";
				break;
			case 8:
				nome = "Oito de ";
				break;
			case 9:
				nome = "Nove de ";
				break;
			case 10:
				nome = "Dez de ";
				break;
			case 11:
				nome = "Valete de ";
				break;
			case 12:
				nome = "Dama de ";
				break;
			case 13:
				nome = "Rei de ";
				break;
			}

			switch (naipe) {
			case 1:
				nome = nome + "ouros";
				break;
			case 2:
				nome = nome + "paus";
				break;
			case 3:
				nome = nome + "copas";
				break;
			case 4:
				nome = nome + "espadas";
				break;
			}

			saida.println(nome);

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
