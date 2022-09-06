import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Produtor {
    public static void main(String[] args) throws IOException{
        final int portaDefault = 80;
		int porta = portaDefault;
		Socket sock = null;
		Scanner sc = new Scanner(System.in);
        PrintWriter saida = null;
        BufferedReader entrada = null;
        String nomeHost = null;
        String resposta = null;
        int tempoProducao = 0;

        if ((args.length == 1) || (args.length == 2)) {
			nomeHost = args[0];
			if (args.length == 2) {
				porta = Integer.parseInt(args[1]);
			}
		} else {
			System.out.println("\n\nUso Correto: Produtor <NomeDoHost> [porta]\n\n");
			System.exit(1);
		}

        System.out.println("Digite o tempo de intervalo entre producoes: (em segundos)");
        tempoProducao = sc.nextInt();
        sc.close();

        while(true) {
            try {
                sock = new Socket(nomeHost, porta);
                saida = new PrintWriter(sock.getOutputStream(), true);
                entrada = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                saida.println("Produtor");
                resposta = entrada.readLine();

                sock.close();
                saida.close();
                entrada.close();

                System.out.println("Caixa " + resposta + " produzida");
                Thread.sleep(tempoProducao * 1000);
                System.out.println("Voce pode colocar uma nova caixa");
            } catch (UnknownHostException e) {
                System.err.println("\n\nHost nao encontrado!\n");
                System.out.println("nUso Correto: Produtor <NomeDoHost> [porta]\n\n");
                System.exit(1);
            } catch (InterruptedException e) {
                System.err.println(e);
                System.exit(1);
            }
        }
    }
}
