import java.rmi.Naming;
import java.util.Scanner;

public class Consumidor {
    public static void main(String[] args) {
        Metodos obj = null;
		Scanner sc = new Scanner(System.in);
        int tempoProducao = 0;
        int caixa;

        System.out.println("Digite o tempo de intervalo entre producoes: (em segundos)");
        tempoProducao = sc.nextInt();
        sc.close();

        while(true) {
            try {
                obj = (Metodos) Naming.lookup("//localhost/Deposito");
                caixa = obj.retirar();

                System.out.println("Caixa " + caixa + " retirada");
                Thread.sleep(tempoProducao * 1000);
                System.out.println("Voce pode retirar uma nova caixa");
            } catch (Exception e) {
                System.out.println("Cliente exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
