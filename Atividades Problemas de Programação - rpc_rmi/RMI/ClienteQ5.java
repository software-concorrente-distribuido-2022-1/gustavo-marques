import java.rmi.Naming;
import java.util.Scanner;

public class ClienteQ5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questoes obj = null;
        int idade = 0;
        String mensagem = "em branco";

        try {
            obj = (Questoes) Naming.lookup("//localhost/QuestoesServer");

            System.out.println("Digite a idade:");
            idade = sc.nextInt();

            mensagem = obj.q5(idade);
            System.out.println(mensagem);
        } catch (Exception e) {
            System.out.println("Cliente exception: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
