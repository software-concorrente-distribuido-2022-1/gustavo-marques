import java.rmi.Naming;
import java.util.Scanner;

public class ClienteQ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questoes obj = null;
        String nome = null;
        String sexo = null;
        int idade = 0;
        String mensagem = "em branco";

        try {
            obj = (Questoes) Naming.lookup("//localhost/QuestoesServer");

            System.out.println("Digite o nome:");
            nome = sc.nextLine();
            System.out.println("Digite o sexo:");
            sexo = sc.nextLine();
            System.out.println("Digite a idade:");
            idade = sc.nextInt();

            mensagem = obj.q2(nome, sexo, idade);
            System.out.println(mensagem);
        } catch (Exception e) {
            System.out.println("Cliente exception: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
