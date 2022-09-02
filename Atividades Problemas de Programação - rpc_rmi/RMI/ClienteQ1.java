import java.rmi.Naming;
import java.util.Scanner;

public class ClienteQ1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questoes obj = null;
        String nome = null;
        String cargo = null;
        double salario = 0.0;
        String mensagem = "em branco";

        try {
            obj = (Questoes) Naming.lookup("//localhost/QuestoesServer");

            System.out.println("Digite o nome:");
            nome = sc.nextLine();
            System.out.println("Digite o cargo:");
            cargo = sc.nextLine();
            System.out.println("Digite o salario:");
            salario = sc.nextDouble();
            
            mensagem = obj.q1(nome, cargo, salario);
            System.out.println(mensagem);
        } catch (Exception e) {
            System.out.println("Cliente exception: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
