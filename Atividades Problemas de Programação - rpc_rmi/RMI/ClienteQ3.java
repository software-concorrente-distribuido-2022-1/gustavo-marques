import java.rmi.Naming;
import java.util.Scanner;

public class ClienteQ3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questoes obj = null;
        double nota1 = 0.0;
        double nota2 = 0.0;
        double nota3 = 0.0;
        String mensagem = "em branco";

        try {
            obj = (Questoes) Naming.lookup("//localhost/QuestoesServer");

            System.out.println("Digite a N1:");
            nota1 = sc.nextDouble();
            System.out.println("Digite a N2:");
            nota2 = sc.nextDouble();
            System.out.println("Digite a N3:");
            nota3 = sc.nextDouble();

            mensagem = obj.q3(nota1, nota2, nota3);
            System.out.println(mensagem);
        } catch (Exception e) {
            System.out.println("Cliente exception: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
