import java.rmi.Naming;
import java.util.Scanner;

public class ClienteQ8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questoes obj = null;
        double saldoMedio = 0.0;
        String mensagem = "em branco";

        try {
            obj = (Questoes) Naming.lookup("//localhost/QuestoesServer");

            System.out.println("Digite o saldo medio:");
            saldoMedio = sc.nextDouble();

            mensagem = obj.q8(saldoMedio);
            System.out.println(mensagem);
        } catch (Exception e) {
            System.out.println("Cliente exception: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
