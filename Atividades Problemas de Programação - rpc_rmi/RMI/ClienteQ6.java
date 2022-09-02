import java.rmi.Naming;
import java.util.Scanner;

public class ClienteQ6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questoes obj = null;
        String nome = null;
        String nivel = null;
        double salarioBruto = 0.0;
        int qtdDependentes = 0;
        String mensagem = "em branco";

        try {
            obj = (Questoes) Naming.lookup("//localhost/QuestoesServer");

            System.out.println("Digite o nome:");
            nome = sc.nextLine();
            System.out.println("Digite o nivel:");
            nivel = sc.nextLine();
            System.out.println("Digite o salario bruto:");
            salarioBruto = sc.nextDouble();
            System.out.println("Digite o numero de dependentes:");
            qtdDependentes = sc.nextInt();

            mensagem = obj.q6(nome, nivel, salarioBruto, qtdDependentes);
            System.out.println(mensagem);
        } catch (Exception e) {
            System.out.println("Cliente exception: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
