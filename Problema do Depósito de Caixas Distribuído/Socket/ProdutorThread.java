import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ProdutorThread extends Thread {
	private String nome;
	private Deposito deposito;
	private Socket socketCliente;

	public ProdutorThread(Socket socketCliente, Deposito deposito) {
		this.socketCliente = socketCliente;
		this.deposito = deposito;
	}

	public void run() {
		InetAddress endCliente = this.socketCliente.getInetAddress();
		this.nome = "Produtor " + endCliente.getHostAddress();
		this.setName(nome);

		try {
			PrintWriter saida = new PrintWriter(this.socketCliente.getOutputStream(), true);

			int caixa = deposito.colocar();
			saida.println(caixa);

			System.out.println(nome + " produziu uma caixa");

			socketCliente.close();
			saida.close();
		} catch (IOException e) {
			System.out.println("Erro E/S " + e);
		}
	}
}
