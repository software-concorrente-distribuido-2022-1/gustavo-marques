import java.rmi.Naming;
import java.util.Scanner;

public class ClienteQ4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questoes obj = null;
        double altura = 0.0;
        String sexo = null;
        String mensagem = "em branco";

        try {
            obj = (Questoes) Naming.lookup("//localhost/QuestoesServer");

            System.out.println("Digite a altura (em metros):");
            altura = sc.nextDouble();
            sc.nextLine();
            System.out.println("Digite o sexo:");
            sexo = sc.nextLine();

            mensagem = obj.q4(altura, sexo);
            System.out.println(mensagem);
        } catch (Exception e) {
            System.out.println("Cliente exception: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
