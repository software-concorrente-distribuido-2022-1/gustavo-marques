import java.net.*;
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

		double idade = 0;
		String categoria = null;
		String mensagem = null;

		try {
			saida = new PrintWriter(this.socketCliente.getOutputStream(), true);
			entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));

			mensagem = entrada.readLine();
			idade = Integer.parseInt(mensagem);

			if (idade >= 5 && idade <= 7) {
				categoria = "Infantil A";
			} else if (idade >= 8 && idade <= 10) {
				categoria = "Infantil B";
			} else if (idade >= 11 && idade <= 13) {
				categoria = "Juvenil A";
			} else if (idade >= 14 && idade <= 17) {
				categoria = "Juvenil B";
			} else if (idade >= 18) {
				categoria = "Adulto";
			}

			saida.println("Categoria: " + categoria);

			System.out.println("Cliente " + endCliente.getHostAddress() + " atendido com a mensagem " + mensagem);

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

			new Conexao(socketCliente).start();
		}
	}
}
