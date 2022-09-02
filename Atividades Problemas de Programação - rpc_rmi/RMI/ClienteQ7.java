import java.rmi.Naming;
import java.util.Scanner;

public class ClienteQ7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questoes obj = null;
        int idade = 0;
        int tempoServico = 0;
        String mensagem = "em branco";

        try {
            obj = (Questoes) Naming.lookup("//localhost/QuestoesServer");

            System.out.println("Digite a idade:");
            idade = sc.nextInt();
            System.out.println("Digite o tempo de servico (em anos):");
            tempoServico = sc.nextInt();

            mensagem = obj.q7(idade, tempoServico);
            System.out.println(mensagem);
        } catch (Exception e) {
            System.out.println("Cliente exception: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
