import java.net.*;
import java.io.*;

public class Servidor {
	public static void main(String[] args) throws IOException {
		final int portaDefault = 8080;
		
		String mensagem;
		int porta;

		Socket socketCliente = null;
		ServerSocket socketServidor = null;
		BufferedReader entrada = null;

		Deposito dep = new Deposito();

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

		System.out.println("\nServidor ativado. " + "Aguardando Clientes na porta " + porta + "...\n");

		while (true) {
			socketCliente = null;
			try {
				socketCliente = socketServidor.accept();
			} catch (IOException e) {
				System.err.println("Erro de E/S " + e);
				socketServidor.close();
				System.exit(1);
			}

			entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			mensagem = entrada.readLine();

			if (mensagem.equals("Produtor")) {
				new ProdutorThread(socketCliente, dep).start();
			}
			else if (mensagem.equals("Consumidor")) {
				new ConsumidorThread(socketCliente, dep).start();
			}
		}
	}
}
