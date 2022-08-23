import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ConsumidorThread extends Thread {
	private String nome;
	private Socket socketCliente;
	private Deposito deposito;

	public ConsumidorThread(Socket socketCliente, Deposito deposito) {
		this.socketCliente = socketCliente;
		this.deposito = deposito;
	}

	public void run() {
		InetAddress endCliente = this.socketCliente.getInetAddress();
		nome = "Consumidor " + endCliente.getHostAddress();
		this.setName(nome);
			
		try {
			PrintWriter saida = new PrintWriter(this.socketCliente.getOutputStream(), true);

			int caixa = deposito.retirar();
			saida.println(caixa);

			System.out.println(nome + " retirou uma caixa");

			socketCliente.close();
			saida.close();
		} catch (IOException e) {
			System.out.println("Erro E/S " + e);
		}
	}
}
